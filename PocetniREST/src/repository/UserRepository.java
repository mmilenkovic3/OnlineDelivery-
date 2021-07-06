package repository;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Gender;
import model.Role;
import model.Type;
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
			User u = null;
			if(user.getRole() == Role.MANAGER || user.getRole() == Role.DELIVERER)			
				{
					 u = new User(user.getRole(), user.getUsername(), user.getPassword(), user.getName(), user.getLastname(), user.getGender(), user.getBirthday());
				}else
				{
					 u = new User(user.getUsername(), user.getPassword(), user.getName(), user.getLastname(), user.getGender(), user.getBirthday());
				}
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
	static User loggedUser = null;
	
	public static User LogIn(User user)
	{
		loggedUser = FindUser(user.getUsername(), user.getPassword());
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
	
	public static User editUser(HashMap<String,String> data) 
	{
		ArrayList<User> users = GetAllUsers();
		User editedU = new User();
		
		try
		{
			for(User user : users)
		
		{				
			if((user.getUsername()).contentEquals(data.get("username")))
			{				
				
				user.setName(data.get("name"));
				user.setLastname(data.get("lastname"));										
				try {
					user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(data.get("birthday")));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();			} 
								
				
				if(data.get("gender").equals("MALE"))
					user.setGender(Gender.MALE);
				else
					user.setGender(Gender.FEMALE);
				
				user.setUsername(data.get("username"));				
				editedU = user;				
				break;
			}
		}
			objMapper.writeValue(Paths.get(pathUsers).toFile(), users);
			return editedU;	
			
		}catch (IOException e) {

			e.printStackTrace();
		}
		return null;
		
		
	}
	
	
	public static User findUserByUsername(String username)
	{
		for(User u : GetAllUsers())
		{
			if(u.getUsername().equals(username))
			{				
				return u;
			}
		}
		return null;
	}
	
	public static void saveList(ArrayList<User> users)
	{
		try {
			
			objMapper.writeValue(Paths.get(pathUsers).toFile(), users);
			
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void addRestaurantToManager(HashMap<String,String> data) throws IOException
	{
		//salje username usera i idRestorana
		ArrayList<User> users = UserRepository.GetAllUsers();
		for(User u : users)
		{
			if(u.getUsername().equals(data.get("username")))
			{
				System.out.println("Pronasao usera kome ce da dodeli restoran.");
				u.setIdRestaurant(Integer.parseInt(data.get("idRestaurant")));
				
				
				
			}
		}		
		
		objMapper.writeValue(Paths.get(pathUsers).toFile(), users);
		
	}
	
	public static ArrayList<User> sortAscName()
	{
		ArrayList<User> list = UserRepository.GetAllUsers(); 
		list.sort(Comparator.comparing(User::getName));
		return list;
	}
	public ArrayList<User> sortDescName()
	{
		ArrayList<User> list = UserRepository.GetAllUsers(); 
		list.sort(Comparator.comparing(User::getName).reversed());
		return list;
	}
	
	public static ArrayList<User> sortAscUsername()
	{
		ArrayList<User> list = UserRepository.GetAllUsers(); 
		list.sort(Comparator.comparing(User::getUsername));
		return list;
	}
	
	public static ArrayList<User> sortByPoints()
	{
		ArrayList<User> list = UserRepository.GetAllUsers(); 
		list.sort(Comparator.comparing(User::getPoints));
		return list;
	}
	
	public static ArrayList<User> sortByLastName()
	{
		ArrayList<User> list = UserRepository.GetAllUsers(); 
		list.sort(Comparator.comparing(User::getLastname));
		return list;
	}
	
	public static ArrayList<User> searchByName(HashMap<String, String> name)
	{
		ArrayList<User> newList = new ArrayList<User>();
		for(User r : GetAllUsers())
		{
			if(r.getName().startsWith(name.get("name")))
				newList.add(r);			
		}
		
		return newList;
	}
	

	public static ArrayList<User> fillterByRole(HashMap<String, String> role) {
		Role roleType = null;
			if(role.get("role").equals("ADMIN"))
				roleType = Role.ADMIN;
			else if(role.get("role").equals("CUSTOMER"))
				roleType = Role.CUSTOMER;
			else if(role.get("role").equals("MANAGER"))
				roleType = Role.MANAGER;
			else if(role.get("role").equals("DELIVERER"))
				roleType = Role.DELIVERER;
			
			
			
		ArrayList<User> newList = new ArrayList<User>();
		for(User r : GetAllUsers())
		{
			if(r.getRole().equals(roleType))
			{
				newList.add(r);
			}
				
			
		}
		
		return newList;
	}
	
	public static ArrayList<User> fillterByType(HashMap<String, String> type) {		
		Type userType = null;
			if(type.get("type").equals("GOLDEN"))
				userType = Type.GOLDEN;
			else if(type.get("type").equals("SILVER"))
				userType = Type.SILVER;
			else if(type.get("type").equals("BRONZE"))
				userType = Type.BRONZE;		
			
			
		ArrayList<User> newList = new ArrayList<User>();
		for(User r : GetAllUsers())
		{
			if(r.getCustomerType().getType().equals(userType))
			{
				newList.add(r);
			}
				
			
		}
		
		return newList;
	}

	public static User LoggedUser() {
		// TODO Auto-generated method stub
		return loggedUser;
	}
	
	
	

}
