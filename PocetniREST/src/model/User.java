package model;

import java.util.ArrayList;
import java.util.Date;

public class User {
	
	private Role role;
	private String username;
	private String password;
	private String name;
	private String lastname;
	private Gender gender;
	private Date birthday;
	
	private ArrayList<Order> allOrder;
	private ArrayList<Basket> basket;
	private double points;	
	private CustomerType customerType;
	
	private int idRestaurant; //MENAGER
	private ArrayList<Integer> idAllDelivery; //DELIVERER
	
	public User() {}
	
/*public User(Role role ,String username, String password, String name, String lastname, Gender gender/*, Date birthday) {
		
		this.role = role;
		this.username = username;
		this.password = password;
		this.name = name;
		this.lastname = lastname;
		this.gender = gender;
		this.birthday = birthday;
		this.allOrder = new ArrayList<Order>();
		this.basket = new ArrayList<Basket>();
		this.points = 10;
		this.customerType = new CustomerType();
		this.idRestaurant = 0;
		this.idAllDelivery = new ArrayList<Integer>();
	}*/
	
	public User(Role role, String username, String password, String name, String lastname, Gender gender, Date birthday,
			ArrayList<Order> allOrder, ArrayList<Basket> basket, double points, CustomerType customerType,
			int idRestaurant, ArrayList<Integer> idAllDelivery) {
		super();
		this.role = role;
		this.username = username;
		this.password = password;
		this.name = name;
		this.lastname = lastname;
		this.gender = gender;
		this.birthday = birthday;
		this.allOrder = allOrder;
		this.basket = basket;
		this.points = points;
		this.customerType = customerType;
		this.idRestaurant = idRestaurant;
		this.idAllDelivery = idAllDelivery;
	}
	
	

public User(String username, String password, String name, String lastname, Gender gender, Date birthday) {
		
		this.role = Role.CUSTOMER;
		this.username = username;
		this.password = password;
		this.name = name;
		this.lastname = lastname;
		this.gender = gender;
		this.birthday = birthday;
		this.allOrder = new ArrayList<Order>();
		this.basket = new ArrayList<Basket>();
		this.points = 10;
		this.customerType = new CustomerType();
		this.idRestaurant = 0;
		this.idAllDelivery = new ArrayList<Integer>();
	}
	
	
	




	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public ArrayList<Order> getAllOrder() {
		return allOrder;
	}

	public void setAllOrder(ArrayList<Order> allOrder) {
		this.allOrder = allOrder;
	}

	public ArrayList<Basket> getBasket() {
		return basket;
	}

	public void setBasket(ArrayList<Basket> basket) {
		this.basket = basket;
	}

	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	public int getIdRestaurant() {
		return idRestaurant;
	}

	public void setIdRestaurant(int idRestaurant) {
		this.idRestaurant = idRestaurant;
	}

	public ArrayList<Integer> getIdAllDelivery() {
		return idAllDelivery;
	}

	public void setIdAllDelivery(ArrayList<Integer> idAllDelivery) {
		this.idAllDelivery = idAllDelivery;
	}

	@Override
	public String toString() {
		return "User [role=" + role + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", lastname=" + lastname + ", gender=" + gender + ", birthday=" + birthday + ", allOrder=" + allOrder
				+ ", basket=" + basket + ", points=" + points + ", customerType=" + customerType + ", idRestaurant="
				+ idRestaurant + ", idAllDelivery=" + idAllDelivery + "]";
	}
	
	
	

}
