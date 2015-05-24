package domain;

public class Cost {
	private double amount = 0;
	
	public Cost(){
	}
	
	public Cost(double amount) {
		this.amount = amount;
	}
	
	public void setPrice(double amount) {
		this.amount = amount;
		
	}
	public double retrieveAmount(){
		return amount;
	}

}
