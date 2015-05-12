package domain;

public class EntryComponent {

	private int stock;
	private int threshold;
	private SimpleComponent type;
	private Double time;
	

	public EntryComponent(){		
	}
	
	public Double getTime() {
		return time;
	}
	
	public void setTime(Double time) {
		this.time = time;
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
