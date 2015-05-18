package domain;

public class Price {
	private double amount;
	
	public Price(){
		amount = 0;
	}
	
	public void setPrice(double amount) {
		this.amount = amount;
		
	}
	public double retrieveAmount(){
		return amount;
	}

}
