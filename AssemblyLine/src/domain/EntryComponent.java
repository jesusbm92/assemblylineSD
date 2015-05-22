package domain;

public class EntryComponent {

	private int stock;
	private SimpleComponent type;
	
	public EntryComponent(SimpleComponent type){
		this.type = type;
	}
	
	public void requestStock(int n){
		this.stock = n;
	}
	
	public Boolean consume(){
		if (stock <= 0) {
			return false;
		}
		
		this.stock--;
	
		return true;
	}
	
	public int getStock(){
		return stock;
	}
	
	public SimpleComponent getType(){
		return type;
	}
	
	
}
