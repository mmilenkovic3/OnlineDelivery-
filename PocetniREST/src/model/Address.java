package model;

public class Address {
	private String name;
	private String number;
	private String city;
	private int postCode;
	
	public Address() {}
	
	public Address(String name, String number, String city, int postCode) {
		super();
		this.name = name;
		this.number = number;
		this.city = city;
		this.postCode = postCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCity() {
		return this.city;
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

	@Override
	public String toString() {
		return "Address [name=" + name + ", number=" + number + ", City=" + city + ", postCode=" + postCode + "]";
	}
	
	

}
