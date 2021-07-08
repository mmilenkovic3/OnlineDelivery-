package dto;

import helpers.LocalVariables;
import model.RestaurantType;
import model.Status;

public class RestaurantDTO {
	
	private String name;
	private RestaurantType type;
	private double width;
	private double length;
	private String addressName;
	private String number;
	private String city;
	private int postCode;
	private Status status;
	private double grade;
	private String logo;
	
	public double getGrade() {
		return grade;
	}


	public void setGrade(double grade) {
		this.grade = grade;
	}


	public RestaurantDTO() {}
	
	
	public RestaurantDTO(String name, RestaurantType type, double width, double length, String addressName,
			String number, String city, int postCode, Status status,double grade) {
		super();
		this.name = name;
		this.type = type;
		this.width = width;
		this.length = length;
		this.addressName = addressName;
		this.number = number;
		this.city = city;
		this.postCode = postCode;
		this.status = status;
		this.grade = grade;
	}




	public RestaurantDTO(String name, RestaurantType type, double width, double length, String addressName,
			String number, String city, int postCode, Status status,double grade, String logo) {
		super();
		this.name = name;
		this.type = type;
		this.width = width;
		this.length = length;
		this.addressName = addressName;
		this.number = number;
		this.city = city;
		this.postCode = postCode;
		this.status = status;
		this.grade = grade;
		this.logo = logo;
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


	public double getWidth() {
		return width;
	}


	public void setWidth(double width) {
		this.width = width;
	}


	public double getLength() {
		return length;
	}


	public void setLength(double length) {
		this.length = length;
	}


	public String getAddressName() {
		return addressName;
	}


	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public int getPostCode() {
		return postCode;
	}


	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public String getLogo() {
		return logo;
	}


	public void setLogo(String logo) {
		this.logo = logo;
	}


	@Override
	public String toString() {
		return "RestaurantDTO [name=" + name + ", type=" + type + ", width=" + width + ", length=" + length
				+ ", addressName=" + addressName + ", number=" + number + ", city=" + city + ", postCode=" + postCode
				+ ", status=" + status + ", logo=" + logo + "]";
	}

	
}
