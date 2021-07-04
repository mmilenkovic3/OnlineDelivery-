package repository;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dto.OrderDTO;
import model.Order;
import model.OrderStatus;

public class OrderRepository {

	public static ObjectMapper objMapper = new ObjectMapper();
	public static String pathOrder = "C:\\Users\\Milenkovic\\git\\repository\\PocetniREST\\WebContent\\files\\orders.json";

	private static ArrayList<Order> GetAllOrder() {

		try {

			ArrayList<Order> order = new ArrayList<Order>(
					Arrays.asList(objMapper.readValue(Paths.get(pathOrder).toFile(), Order[].class)));

			return order;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static  ArrayList<Order> getOrderByUser(HashMap<String,String> username)
	{
		ArrayList<Order> order = new ArrayList<Order>();
		for(Order o : GetAllOrder())
		{
			if(o.getUsername().equals(username.get("username")))
			{
				order.add(o);
			}
		}
		
		return order;
	}
	
	public static ArrayList<Order> getOrderByRestaurant(HashMap<String, String> idRestaurant)
	{
		ArrayList<Order> order = new ArrayList<Order>();
		for(Order o : GetAllOrder())
		{
			if(o.getIdRestaurant() == Integer.parseInt(idRestaurant.get("idRestaurant")));
			{
				order.add(o);
			}
		}
		
		return order;
	}
	
	public static Order cancelOrder(HashMap<String, String> id) throws IOException
	{
		ArrayList<Order> orders = GetAllOrder();
		Order order = new Order();
		for(Order o : orders)
		{
			if(o.getId() == Long.parseLong(id.get("id")))
			{
				o.setStatus(OrderStatus.CANDELED);
				order = o;
			}
		}	
		objMapper.writeValue(Paths.get(pathOrder).toFile(), orders);
		
		
		
		return order;
	}
	
	public static Order statusAwaiting(HashMap<String, String> id) throws IOException
	{
		ArrayList<Order> orders = GetAllOrder();
		Order order = new Order();
		for(Order o : orders)
		{
			if(o.getId() == Long.parseLong(id.get("id")))
			{
				o.setStatus(OrderStatus.AWAITING);
				order = o;
			}
		}	
		objMapper.writeValue(Paths.get(pathOrder).toFile(), orders);
		
		
		
		return order;
	}
	
	
	
	
	public static Order saveOrder(OrderDTO orderDTO) throws IOException
	{
		ArrayList<Order> allOrder = GetAllOrder();

		long newId = generateID();
		Order newOrder = new Order(newId,orderDTO.getIdRestaurant(), orderDTO.getArticles(),orderDTO.getRestaurantName(),
				orderDTO.getPrice(), orderDTO.getUsername());
	
		/*newOrder.setId(newId);
		newOrder.setArticles(orderDTO.getArticles());
		newOrder.setIdRestaurant(orderDTO.getIdRestaurant());
		newOrder.setRestaurantName(orderDTO.getRestaurantName());
		newOrder.setPrice(orderDTO.getPrice());
		newOrder.setUsername(orderDTO.getUsername());*/
	
		allOrder.add(newOrder);
		
		objMapper.writeValue(Paths.get(pathOrder).toFile(), allOrder);
		return newOrder;
	}
	
	//generator id-jeva sa 10digits
	public static long generateID() { 
	    Random rnd = new Random();
	    char [] digits = new char[10];
	    digits[0] = (char) (rnd.nextInt(9) + '1');
	    for(int i=1; i<digits.length; i++) {
	        digits[i] = (char) (rnd.nextInt(10) + '0');
	    }
	    return Long.parseLong(new String(digits));
	}
	
}
