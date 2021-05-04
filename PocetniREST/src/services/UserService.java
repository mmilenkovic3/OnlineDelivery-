package services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import helpers.HelpersMethods;
import model.Gender;
import model.Role;
import model.User;
import repository.UserRepository;

@Path("/users")
public class UserService {

	@Context
	HttpServletRequest request;
	
	//User loggedUser;

	@GET
	@Path("/getAllUsers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUsers() {
		ArrayList<User> users = UserRepository.GetAllUsers();
		return Response.status(200).entity(users).build();
	}
	
	@POST
	@Path("/saveGuest")
	public Response saveGuest(User user) throws IOException {

		if(UserRepository.UniqueUsername(user.getUsername()))
		{					
			User u = UserRepository.saveGuest(user);				
			return Response.status(200).entity(u).build();
		}		
		return Response.status(400).entity("User with that username already Exists! Please write another one.").build();
			
		
		
	}
	
	

	
}
