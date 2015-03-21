package domain;

public class Component {

	private Boolean isPlaced;
	private int stock;

	public Component() {
		super();
		this.isPlaced = false;
		this.stock = 0;
	}

	public Boolean getIsPlaced() {
		return isPlaced;
	}

	public void setIsPlaced(Boolean isPlaced) {
		this.isPlaced = isPlaced;
	}
	
	public void setStock(int n){
		this.stock = n;
	}
	
	public int getStock(){
		return stock;
	
	}

}
