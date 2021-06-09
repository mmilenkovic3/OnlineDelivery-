package services;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Restaurant;
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
		
		User user = (User) request.getSession().getAttribute("loggedUser");
		if(user == null) return Response.status(415).entity("Not allowed").build();
		else
			return Response.status(200).entity(RestaurantRepository.GetAllUsers()).build();
	}



}
