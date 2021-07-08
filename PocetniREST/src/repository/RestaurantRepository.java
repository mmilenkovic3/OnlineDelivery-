package repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import dto.RestaurantDTO;
import helpers.LocalVariables;
import model.Address;
import model.Location;
import model.Restaurant;
import model.RestaurantType;

public class RestaurantRepository {
	
	public static ObjectMapper objMapper = new ObjectMapper();
	public static String pathRestaurant = LocalVariables.ROOT_PATH + "\\PocetniREST\\WebContent\\files\\restaurants.json";

	public static ArrayList<Restaurant> GetAllRestaurant() {

		try {
			
			ArrayList<Restaurant> restaurant = new ArrayList<Restaurant>(
					Arrays.asList(objMapper.readValue(Paths.get(pathRestaurant).toFile(), Restaurant[].class)));

			return restaurant;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static Restaurant getRestaurantByID(int id)
	{
		for(Restaurant r : GetAllRestaurant())
		{
			if(r.getId() == id)
				return r;
		}
		
		return null;
		
	}
	
	public static Restaurant saveRestaurant(RestaurantDTO restaurantDTO) throws IOException
	{		
		System.out.println("Saving the restaurant..");
		 int id = GetAllRestaurant().size() + 1;
		 
		 /*for (Restaurant r : GetAllRestaurant()) {
			 if(r.getId() == )
			
		}*/
		
		ArrayList<Restaurant> restaurants = GetAllRestaurant();
		Address address = new Address(restaurantDTO.getAddressName(),
					restaurantDTO.getNumber(),
					restaurantDTO.getCity(),
					restaurantDTO.getPostCode());
		
		Location location = new Location(
				
				restaurantDTO.getWidth(),
				restaurantDTO.getLength(),
				address);
		
		Restaurant r = new Restaurant(id, restaurantDTO.getName(), 
										  restaurantDTO.getType(),										  
										  restaurantDTO.getStatus(), 
										  restaurantDTO.getGrade(),
										  location
										  );
		
		restaurants.add(r);
		objMapper.writeValue(Paths.get(pathRestaurant).toFile(), restaurants);
		
		return r;
		
	}
	
	
	public static void savePhoto(String imageUrl) throws IOException
	{
		
		while (imageUrl.contains("\\")) {
			String[] parts = imageUrl.split("\\\\");
			imageUrl.trim();
			imageUrl = parts[parts.length - 1];

		}
		System.out.println(imageUrl);
		Path source = Paths.get(imageUrl);
		Path destination = Paths.get(LocalVariables.ROOT_PATH + "\\PocetniREST\\WebContent\\images");
		Files.createDirectories(destination);
		Files.copy(source,  destination);
		    // I decided to replace already existing files with same name
		
	
	}
	
	public static ArrayList<Restaurant> searchByName(HashMap<String, String> name)
	{
		ArrayList<Restaurant> newList = new ArrayList<Restaurant>();
		for(Restaurant r : GetAllRestaurant())
		{
			if(r.getName().startsWith(name.get("name")))
				newList.add(r);
			
		}
		
		return newList;
	}
	
	public static ArrayList<Restaurant> searchByType(HashMap<String, String> type)
	{
		System.out.println(type.get("type"));
		RestaurantType rType = null;
			if(type.get("type").equals("CHINESE"))
				rType = RestaurantType.CHINESE;
			else if(type.get("type").equals("MEXICAN"))
				rType = RestaurantType.MEXICAN;
			else if(type.get("type").equals("ITALIAN"))
				rType = RestaurantType.ITALIAN;
			
			
			
		ArrayList<Restaurant> newList = new ArrayList<Restaurant>();
		for(Restaurant r : GetAllRestaurant())
		{
			if(r.getType().equals(rType))
			{
				newList.add(r);
			}
				
			
		}
		
		return newList;
	}
	
	public static ArrayList<Restaurant> searchByCity(HashMap<String, String> city)
	{
		ArrayList<Restaurant> newList = new ArrayList<Restaurant>();
		for(Restaurant r : GetAllRestaurant())
		{
			if(r.getLocation().getAddress().getCity().startsWith(city.get("city")))
				newList.add(r);
			
		}
		
		return newList;
	}
	
	public static ArrayList<Restaurant> searchByGrade(HashMap<String, String> grade)
	{
		ArrayList<Restaurant> newList = new ArrayList<Restaurant>();
		for(Restaurant r : GetAllRestaurant())
		{
			if(r.getGrade() == Double.parseDouble(grade.get("grade")))
				newList.add(r);
			
		}
		
		return newList;
	}
	
	
	
	
	
	
	
	
	

}

	
