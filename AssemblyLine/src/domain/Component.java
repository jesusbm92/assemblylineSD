package domain;

import java.awt.image.BufferedImage;

public class Component implements Drawable{

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

	@Override
	public BufferedImage draw(int width, int height) {
		// TODO Auto-generated method stub
		return null;
	}

}
