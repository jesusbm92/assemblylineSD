package domain;

public class EntryComponent {

	private int stock;
	private int threshold;
	private SimpleComponent type;
	
	public EntryComponent(SimpleComponent type){
		this.type = type;
	}
	
	public void requestStock(int n){
		this.stock = n;
	}
	
	public Boolean request(){
		if (stock <= 0) {
			return false;
		}
		
		this.stock--;
	
		return true;
	}
	
	public int getStock(){
		return stock;
	}
	
	public void setThreshold(int n){
		this.threshold = n;
	}
	
	public int getThreshold(){
		return threshold;
	}
	
	public void setType(SimpleComponent s){
		this.type = s;
	}
	
	public SimpleComponent getType(){
		return type;
	}
	
	
}
