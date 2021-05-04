package model;

import java.util.ArrayList;
import java.util.Date;

public class Order {
	private int id; //10 characters
	private ArrayList<Integer> idOrderedArticles; // list of id arcticles 
	private int idRestaurant;
	private String restaurantName;
	private Date dateAndTime;
	private double price;
	private OrderStatus status;
	
}
