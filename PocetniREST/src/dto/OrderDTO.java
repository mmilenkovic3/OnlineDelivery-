package dto;

import java.util.ArrayList;

import model.Basket;

public class OrderDTO {
	private ArrayList<Basket> articles;   
	private int idRestaurant;
	private String restaurantName;
	private double price;
	private String username;
	
	public OrderDTO() {
		
	}
	public OrderDTO(ArrayList<Basket> articles, int idRestaurant, String restaurantName, double price,
			String username) {
		
		this.articles = articles;
		this.idRestaurant = idRestaurant;
		this.restaurantName = restaurantName;
		this.price = price;
		this.username = username;
	}
	public ArrayList<Basket> getArticles() {
		return articles;
	}
	public void setArticles(ArrayList<Basket> articles) {
		this.articles = articles;
	}
	public int getIdRestaurant() {
		return idRestaurant;
	}
	public void setIdRestaurant(int idRestaurant) {
		this.idRestaurant = idRestaurant;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
}
