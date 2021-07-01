package model;

public class Article {
	private int idArticle;
	private String name;
	private FoodType type;
	private int idRestaurant;
	private Qunatity quantity;
	private double qunatityNum;
	private double price;
	private String description;
	private String picture;
	
	public Article() {}

	public Article(int idArticle, String name, FoodType type, int idRestaurant, Qunatity quantity, double qunatityNum,
			double price, String description, String picture) {
		super();
		this.idArticle = idArticle;
		this.name = name;
		this.type = type;
		this.idRestaurant = idRestaurant;
		this.quantity = quantity;
		this.qunatityNum = qunatityNum;
		this.price = price;
		this.description = description;
		this.picture = picture;
	}
	
	public Article(int idArticle, String name, FoodType type,  Qunatity quantity, double qunatityNum,
			double price, String description, String picture) {
		super();
		this.idArticle = idArticle;
		this.name = name;
		this.type = type;
		this.quantity = quantity;
		this.qunatityNum = qunatityNum;
		this.price = price;
		this.description = description;
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", name=" + name + ", type=" + type + ", idRestaurant="
				+ idRestaurant + ", quantity=" + quantity + ", qunatityNum=" + qunatityNum + ", price=" + price
				+ ", description=" + description + ", picture=" + picture + "]";
	}

	public int getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FoodType getType() {
		return type;
	}

	public void setType(FoodType type) {
		this.type = type;
	}

	public int getIdRestaurant() {
		return idRestaurant;
	}

	public void setIdRestaurant(int idRestaurant) {
		this.idRestaurant = idRestaurant;
	}

	public Qunatity getQuantity() {
		return quantity;
	}

	public void setQuantity(Qunatity quantity) {
		this.quantity = quantity;
	}

	public double getQunatityNum() {
		return qunatityNum;
	}

	public void setQunatityNum(double qunatityNum) {
		this.qunatityNum = qunatityNum;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	
	
	
	

}
