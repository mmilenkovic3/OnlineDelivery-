package model;

public class Basket {
	private int idArticle;
	private int quantity;
	private double price;
	
	public Basket(int idArticle, int quantity, double price) {
		super();
		this.idArticle = idArticle;
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
	
	@Override
	public String toString() {
		return "Basket [idArticle=" + idArticle + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
	

}
