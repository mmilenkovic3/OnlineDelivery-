package model;

public class Article {
	private int idArticle;
	private String name;
	private FoodType type;
	private int idRestaurant;
	private Qunatity quantiti;
	private String description;
	private String picture;
	
	public Article(int idArticle, String name, FoodType type, int idRestaurant, Qunatity quantiti, String description,
			String picture) {
		super();
		this.idArticle = idArticle;
		this.name = name;
		this.type = type;
		this.idRestaurant = idRestaurant;
		this.quantiti = quantiti;
		this.description = description;
		this.picture = picture;
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

	public Qunatity getQuantiti() {
		return quantiti;
	}

	public void setQuantiti(Qunatity quantiti) {
		this.quantiti = quantiti;
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

	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", name=" + name + ", type=" + type + ", idRestaurant="
				+ idRestaurant + ", quantiti=" + quantiti + ", description=" + description + ", picture=" + picture
				+ "]";
	}
	
	
	
	

}
