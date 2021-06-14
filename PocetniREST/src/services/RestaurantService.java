package services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dto.RestaurantDTO;
import model.Restaurant;
import model.Role;
import model.User;
import repository.RestaurantRepository;
import repository.UserRepository;

@Path("/restaurant")
public class RestaurantService {
	@Context
	HttpServletRequest request;
	
	User loggedUser;


	@GET
	@Path("/getRestaurantById")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRestaurantById() {		
		
		User user = (User) request.getSession().getAttribute("loggedUser");
		Restaurant r = RestaurantRepository.getRestaurantByID(user.getIdRestaurant());
		return Response.status(200).entity(r).build();
	}
	
	@GET
	@Path("/getAllRestaurant")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllRestaurant() {
			List<Restaurant> list = RestaurantRepository.GetAllRestaurant(); 
			list.sort(Comparator.comparing(Restaurant::getStatus));
			
			return Response.status(200).entity(list).build();
	}

	@POST
	@Path("/saveRestaurant")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveRestaurant(RestaurantDTO restaurantDTO) throws IOException {	
		
		User user = (User) request.getSession().getAttribute("loggedUser");
		if(user == null) return Response.status(500).entity("Internal Server Error").build();
		
		else if(user.getRole() != Role.ADMIN)
			return Response.status(401).entity("401 Unauthorized").build();
		else
		{
			Restaurant r = RestaurantRepository.saveRestaurant(restaurantDTO);
			return Response.status(200).entity(r).build();
		}
			
		
		
	}
	
	@POST
	@Path("/saveRestaurantToManager")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveRestaurantToManager(HashMap<String, String> data) throws IOException {
		User user = (User) request.getSession().getAttribute("loggedUser");
		if(user == null)
			return Response.status(500).entity("Internal Server Error").build();
		else if(user.getRole() != Role.ADMIN)
			return Response.status(401).entity("401 Unauthorized").build();
		else
		{
			System.out.println("Dodao id restorana menageru! (SERVIS)");
			UserRepository.addRestaurantToManager(data);
			return Response.status(200).entity("Successeffully added manager to restaurant!").build();
		}
		
		
	}
	
	@POST
	@Path("/uploadPhoto")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response uploadPhoto(HashMap<String, String> fileName) throws IOException {
		
		User user = (User) request.getSession().getAttribute("loggedUser");
		if(user == null)
			return Response.status(500).entity("Internal Server Error").build();
		else if(user.getRole() != Role.ADMIN)
			return Response.status(401).entity("401 Unauthorized").build();
		else
		{
			System.out.println("Dodao fotogragiju)");
			RestaurantRepository.savePhoto(fileName.get("fileName"));
			return Response.status(200).entity("Successeffully uploaded!").build();
		}
		
		
	}
}
