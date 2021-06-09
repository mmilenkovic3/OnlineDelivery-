package repository;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Restaurant;
import model.User;

public class RestaurantRepository {
	
	public static ObjectMapper objMapper = new ObjectMapper();
	public static String pathUsers = "C:\\Users\\Milenkovic\\git\\repository\\PocetniREST\\WebContent\\files\\restaurants.json";

	public static ArrayList<Restaurant> GetAllUsers() {

		try {

			ArrayList<Restaurant> restaurant = new ArrayList<Restaurant>(
					Arrays.asList(objMapper.readValue(Paths.get(pathUsers).toFile(), Restaurant[].class)));

			return restaurant;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Restaurant getRestaurantByID(int id)
	{
		for(Restaurant r : GetAllUsers())
		{
			if(r.getId() == id)
				return r;
		}
		
		return null;
		
	}
	
	public static Restaurant saveRestaurant(Restaurant restaurant)
	{		
		
		return null;
		
	}
	
	
	
	

}

	
