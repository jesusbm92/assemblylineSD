package domain;

public class EntryComponent {

	private int stock;
	private int threshold;
	private SimpleComponent type;
	
	public EntryComponent(){		
	}
	
	public void requestStock(int n){
		this.stock = n;
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
