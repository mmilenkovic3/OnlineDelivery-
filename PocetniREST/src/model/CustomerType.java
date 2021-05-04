package model;

public class CustomerType {
	
	private Type type;
	private double discount;
	private double requiredPoints;
	
	public CustomerType() {}
	
	public CustomerType(Type type, double discount, double requiredPoints) {
		super();
		this.type = type;
		this.discount = discount;
		this.requiredPoints = requiredPoints;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getRequiredPoints() {
		return requiredPoints;
	}

	public void setRequiredPoints(double requiredPoints) {
		this.requiredPoints = requiredPoints;
	}

	@Override
	public String toString() {
		return "CustomerType [type=" + type + ", discount=" + discount + ", requiredPoints=" + requiredPoints + "]";
	}
	
	

}
