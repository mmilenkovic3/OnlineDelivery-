package services;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dto.OrderDTO;
import model.Order;
import model.User;
import repository.OrderRepository;

@Path("/order")
public class OrderService {
	User loggedUser;
	
	@POST
	@Path("/saveOrder")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveOrder(OrderDTO orderDTO) throws IOException {	
		System.out.println("Service za snimanje ordera..");		
		System.out.println(LocalDateTime.now());
		Order o = OrderRepository.saveOrder(orderDTO);
		return Response.status(200).entity(o).build();
	}
	
	@POST
	@Path("/getOrderByUsername")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOrderByUsername(HashMap<String, String> username) throws IOException {	
		ArrayList<Order> o = OrderRepository.getOrderByUser(username);
		return Response.status(200).entity(o).build();
	}
	
	@POST
	@Path("/getOrderByIdRestaurant")	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOrderByIdRestaurant(HashMap<String, String> idRestaurant) throws IOException {	
		ArrayList<Order>  o = OrderRepository.getOrderByRestaurant(idRestaurant);
		return Response.status(200).entity(o).build();
	}
	
	@POST
	@Path("/cancelOrder")	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cancelOrder(HashMap<String, String> id) throws IOException {	
		Order o = OrderRepository.cancelOrder(id);
		return Response.status(200).entity(o).build();
	}
	

	@POST
	@Path("/statusAwaiting")	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response statusAwaiting(HashMap<String, String> id) throws IOException {	
		Order o = OrderRepository.statusAwaiting(id);
		return Response.status(200).entity(o).build();
	}

}
