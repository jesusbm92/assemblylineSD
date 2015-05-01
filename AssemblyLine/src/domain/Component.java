package domain;


abstract class Component{

	private int stock;

	public Component() {
		this.stock = 0;
	}
	
	public void setStock(int n){
		this.stock = n;
	}
	
	public int getStock(){
		return stock;
	
	}

}
