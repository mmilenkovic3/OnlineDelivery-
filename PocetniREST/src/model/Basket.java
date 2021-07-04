package model;

public class Basket {
	private int idArticle;
	private String name;
	private int quantity;
	private double price;
	
	public Basket() {}
	public Basket(int idArticle,String name, int quantity, double price) {
		super();
		this.idArticle = idArticle;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	public int getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Basket [idArticle=" + idArticle + ", name=" + name + ", quantity=" + quantity + ", price=" + price
				+ "]";
	}
	
	
	
	

}
