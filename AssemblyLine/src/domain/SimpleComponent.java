package domain;

import java.awt.image.BufferedImage;

public class SimpleComponent extends Component{
	private int stock;
	private Figure figure;

	public SimpleComponent(Warehouse warehouse) {
		this.stock = 0;
	}
	
	public void setStock(int n){
		this.stock = n;
	}
	
	public int getStock(){
		return stock;
	}
	
	public Figure getFigure() {
		return figure;
	}
	
	public void setFigure(Figure fig) {
		figure = fig;
	}

	@Override
	public BufferedImage draw() {
		if (figure == null) {
			return new BufferedImage(0,0,BufferedImage.TYPE_INT_RGB);
		}
		
		return figure.draw();
	}
}
