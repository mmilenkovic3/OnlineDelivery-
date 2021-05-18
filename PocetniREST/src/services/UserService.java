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
	
	User loggedUser;

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
			if((user.getRole() == Role.MANAGER || user.getRole() == Role.DELIVERER ) && loggedUser.getRole() != Role.ADMIN)
				return Response.status(403).entity(HelpersMethods.GetJsonValue("Unauthorized")).build();
			User u = UserRepository.saveGuest(user);				
			return Response.status(200).entity(u).build();
		}		
		return Response.status(400).entity("User with that username already Exists! Please write another one.").build();
			
		
		
	}
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response LogIn(HashMap<String, String> data)
	{
		String password = data.get(data.keySet().toArray()[0]);
		String username = data.get(data.keySet().toArray()[1]);
		User u = UserRepository.FindUser(username, password);
		System.out.println("U: " + username + " P: "+ password);
		loggedUser = u;
		System.out.println(u.getName());
		//System.out.println("USER: " + user);		
		
		u = UserRepository.LogIn(u);
		if(u != null){
			System.out.println("NEKO SE ULOGOVAO.");
				request.getSession().setAttribute("loggedUser", u);
				return Response.status(200).entity(u).build();
			}
		
		return Response.status(400).entity("User doesn't exists!").build();
	}
	
	@GET
	@Path("/getLoggedUser")
	public Response GetLoggedUser()
	{
		System.out.println("Get logged user, pozvan");
		User user = (User) request.getSession().getAttribute("loggedUser");
		System.out.println(user);
		return Response.status(200).entity(user).build();
	}
	
	@GET
	@Path("/logout")
	public Response LogOut() {	
		System.out.println("USAO U LOG OUT?");
		System.out.println(request.getSession().getAttribute("loggedUser"));
		if(GetLoggedUser() != null)
		{
			request.getSession().removeAttribute("loggedUser");
			//return Response.status(200).entity("Successeffully logged out!").build();
			return Response.status(200).build();
		}
		else
			return Response.status(400).entity("Error! Don't have logged user!!").build();
	}
	
	@POST
	@Path("/editUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response Edit(HashMap<String, String> data)
	{
		System.out.println("Usao u edit!");
		System.out.println("podatci" + data);
		if (GetLoggedUser() == null) {
			return Response.status(403).entity(HelpersMethods.GetJsonValue("Unauthorized")).build();
		}
		else
		{
			User user = UserRepository.editUser(data);
			request.getSession().setAttribute("loggedUser", user);
			return Response.status(200).entity(user).build();
		}
			
	}

	
}
