package repository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.apache.tomcat.util.http.fileupload.FileUtils;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dto.RestaurantDTO;
import model.Address;
import model.Location;
import model.Restaurant;
import model.User;

public class RestaurantRepository {
	
	public static ObjectMapper objMapper = new ObjectMapper();
	public static String pathRestaurant = "C:\\Users\\Milenkovic\\git\\repository\\PocetniREST\\WebContent\\files\\restaurants.json";

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
		Path destination = Paths.get("C:\\Users\\Milenkovic\\git\\repository\\PocetniREST\\WebContent\\images");
		Files.createDirectories(destination);
		Files.copy(source,  destination);
		    // I decided to replace already existing files with same name
		
	
	}
	
	
	
	
	
	
	
	

}

	
