package model;

public class Address {
	private String name;
	private String number;
	private String City;
	private int postCode;
	
	public Address(String name, String number, String city, int postCode) {
		super();
		this.name = name;
		this.number = number;
		City = city;
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
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

	@Override
	public String toString() {
		return "Address [name=" + name + ", number=" + number + ", City=" + City + ", postCode=" + postCode + "]";
	}
	
	

}
