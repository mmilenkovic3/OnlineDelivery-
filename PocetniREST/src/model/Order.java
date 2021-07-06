package model;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Order {
	private long id; //10 characters
	private ArrayList<Basket> articles; //  
	private int idRestaurant;
	private String restaurantName;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date date;	
	private double price;
	private OrderStatus status;
	private String username;
	
	public Order() {}
	

	
	public Order(long id, ArrayList<Basket> articles, int idRestaurant, String restaurantName, Date date,
			 double price, OrderStatus status, String username) {
		super();
		this.id = id;
		this.articles = articles;
		this.idRestaurant = idRestaurant;
		this.restaurantName = restaurantName;
		this.date = date;
		this.price = price;
		this.status = status;
		this.username = username;
	}



	public Order(long id, int idRestaurant, ArrayList<Basket> articles, String restaurantName, double price, String username) {
		super();
		this.id = id;
		this.articles = articles;
		this.idRestaurant = idRestaurant;
		this.restaurantName = restaurantName;
		this.date = new Date();
		this.price = price;
		this.status = OrderStatus.PROCESSING;
		this.username = username;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
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



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}


	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public OrderStatus getStatus() {
		return status;
	}



	public void setStatus(OrderStatus status) {
		this.status = status;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}

	
	
	
	
}
