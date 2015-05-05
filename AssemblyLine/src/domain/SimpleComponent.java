package domain;

import java.awt.image.BufferedImage;

public class SimpleComponent extends Component{
	private int stock;
<<<<<<< HEAD
	private Figure figure;
=======
	private Warehouse warehouse;
>>>>>>> origin/dev_mergedV3_martin

	public SimpleComponent(Warehouse warehouse) {
		this.stock = 0;
	}
	
	public void setStock(int n){
		this.stock = n;
	}
	
	public int getStock(){
		return stock;
	}

	@Override
	public BufferedImage draw() {
		if (figure == null) {
			return new BufferedImage(0,0,BufferedImage.TYPE_INT_RGB);
		}
		
		return figure.draw();
	}
}
