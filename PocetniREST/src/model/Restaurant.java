package model;

import java.util.ArrayList;

public class Restaurant {
	
	private int id;
	private String name;
	private RestaurantType type;
	private ArrayList<Integer> articles; 
	private Status status;
	private Location location;
	private double grade;
	private String logo;	
	

	private Restaurant() {}
	
	public Restaurant(int id,String name, RestaurantType type, Status status, double grade, Location location) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.articles = new ArrayList<Integer>();
		this.status = status;
		this.location = location;
		this.grade = grade;
		this.logo = "./images/meal-icon.png";
	}
	
	
	public Restaurant(int id, String name, RestaurantType type, ArrayList<Integer> articles, Status status,
			Location location, double grade, String logo) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.articles = articles;
		this.status = status;
		this.location = location;
		this.grade = grade;
		this.logo = logo;
	}
	
	
	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public RestaurantType getType() {
		return type;
	}
	public void setType(RestaurantType type) {
		this.type = type;
	}
	public ArrayList<Integer> getArticles() {
		return articles;
	}
	public void setArticles(ArrayList<Integer> idArticles) {
		this.articles = idArticles;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	
	
}
