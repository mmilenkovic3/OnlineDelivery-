package repository;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;


import model.Gender;

import model.User;

public class UserRepository {

	public static ObjectMapper objMapper = new ObjectMapper();
	public static String pathUsers = "C:\\Users\\Milenkovic\\git\\repository\\PocetniREST\\WebContent\\files\\users.json";

	public static ArrayList<User> GetAllUsers() {

		try {

			ArrayList<User> users = new ArrayList<User>(
					Arrays.asList(objMapper.readValue(Paths.get(pathUsers).toFile(), User[].class)));

			return users;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static User saveGuest(User user) throws IOException
	{
		if(UniqueUsername(user.getUsername()))
		{
			System.out.println("Sa user repo.");
			String json = objMapper.writeValueAsString(user);
			ArrayList<User> users = GetAllUsers();
			User u = new User(user.getUsername(), user.getPassword(), user.getName(), user.getLastname(), user.getGender(), user.getBirthday());
			users.add(u);
			objMapper.writeValue(Paths.get(pathUsers).toFile(), users);
			return u;
		}
		return null;
		
	}

	public static boolean UniqueUsername(String username)
	{
		for(User u : GetAllUsers())
		{
			if(u.getUsername().equals(username))
			{
				System.out.println("Unsername nije uniq.");
				return false;				
			}
		}
		System.out.println("Unikatno username.");
		return true;
	}
	
	public static User LogIn(User user)
	{
		User loggedUser = FindUser(user.getUsername(), user.getPassword());
		if(loggedUser == null)
			return null;
		else
			return loggedUser;
	}
	
	public static User FindUser(String username, String password)
	{
		System.out.println("Find user");
	
		for(User u : GetAllUsers())
		{
			if(u.getUsername().equals(username) && u.getPassword().equalsIgnoreCase(password))
			{
				System.out.println("Nasao korisnika za logovanje!");
				return u;
			}
		}
		return null;
	}

}
