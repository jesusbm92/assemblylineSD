package domain;

public class Price {
	private double amount = 0;
	
	public Price(){
	}
	
	public Price(double amount) {
		this.amount = amount;
	}
	
	public void setPrice(double amount) {
		this.amount = amount;
		
	}
	public double retrieveAmount(){
		return amount;
	}

}
