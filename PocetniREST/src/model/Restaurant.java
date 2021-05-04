package model;

import java.util.ArrayList;

public class Restaurant {
	
	private int id;
	private String name;
	private RestaurantType type;
	private ArrayList<Integer> idArticles; 
	private Status status;
	private Location location;
	private String logo;
	
	public Restaurant(int id, String name, RestaurantType type, ArrayList<Integer> idArticles, Status status,
			Location location, String logo) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.idArticles = idArticles;
		this.status = status;
		this.location = location;
		this.logo = logo;
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
		return idArticles;
	}
	public void setArticles(ArrayList<Integer> idArticles) {
		this.idArticles = idArticles;
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
	
	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", type=" + type + ", articles=" + idArticles + ", status="
				+ status + ", location=" + location + ", logo=" + logo + "]";
	}
	
}
