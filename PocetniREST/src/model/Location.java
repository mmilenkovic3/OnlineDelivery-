package model;

public class Location {
	private double width;
	private double length;
	private Address address;
	
	public Location(double width, double length, Address address) {
		super();
		this.width = width;
		this.length = length;
		this.address = address;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Location [width=" + width + ", length=" + length + ", address=" + address + "]";
	}
	
	
	

}
