package tests;

import static org.junit.Assert.*;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import domain.AssemblyStation;
import domain.Component;
import domain.Drawable;
import domain.Product;
import domain.Warehouse;

public class WarehouseTest {

	public class MockUpWarehouse {

		private List<MockUpAssemblyStation> assemblyStations;

		public MockUpWarehouse() {
			super();
			// TODO Auto-generated constructor stub
		}

		public void setAssemblyStations(
				List<MockUpAssemblyStation> assemblyStations) {
			this.assemblyStations = assemblyStations;
		}

		public void generateComponents(MockUpComponent c, Integer n) {
			// Here we must add the number of components n
			c.setStock(n);
		}
	}

	public class MockUpAssemblyStation {
		private MockUpComponent c1;
		private MockUpWarehouse warehouse;

		// private int StockInStation;

		public MockUpAssemblyStation(MockUpComponent c) {
			// TODO Auto-generated constructor stub
			c1 = c;

		}

		public void placeComponent(MockUpProduct p) {
			if (c1.getStock() < 1) {
				warehouse.generateComponents(c1, 1);
			}
			p.addComponent(c1);

		}

		public void setWarehouse(MockUpWarehouse w) {
			this.warehouse = w;

		}
	}

	public class MockUpProduct implements Drawable {

		private List<MockUpComponent> components;

		@Override
		public BufferedImage draw(int width, int height) {
			BufferedImage img = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics2D graphics = img.createGraphics();

			// just draw all components next to each other
			int offset = 0;
			for (MockUpComponent c : components) {
				graphics.drawImage(c.draw(width / components.size(), 0), null,
						offset, 0);
				offset += width / components.size();
			}
			return img;
		}

		public Boolean addComponent(MockUpComponent c) {
			components.add(c);
			return true; // for later, maybe we want checks to assure the
							// component fits?
		}

	}

	public class MockUpComponent implements Drawable {

		private Boolean isPlaced;
		private int stock;

		public MockUpComponent() {
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

		public void setStock(int n) {
			this.stock = n;
		}

		public int getStock() {
			return stock;

		}

		@Override
		public BufferedImage draw(int width, int height) {
			// TODO Auto-generated method stub
			return null;
		}
	}

	@Test
	public void newWarehouse() {
		Warehouse w = new Warehouse();
		assertNotNull(w);
	}

	@Test
	public void setAssemblyStationsTest() {
		int expectedStations = 2;
		
		MockUpWarehouse w = new MockUpWarehouse();
		MockUpComponent c = new MockUpComponent();
		MockUpComponent c2 = new MockUpComponent();
		MockUpAssemblyStation m = new MockUpAssemblyStation(c);
		MockUpAssemblyStation m2 = new MockUpAssemblyStation(c2);
		List<MockUpAssemblyStation> l = new ArrayList();
		l.add(m);
		l.add(m2);
		w.setAssemblyStations(l);
		
		assertEquals(expectedStations,w.assemblyStations.size());
	}

	@Test
	public void generateComponentsTest(){
		int expectedComponents = 10;
		
		MockUpWarehouse w = new MockUpWarehouse();
		MockUpComponent c = new MockUpComponent();
		MockUpAssemblyStation m = new MockUpAssemblyStation(c);
		List<MockUpAssemblyStation> l = new ArrayList();
		l.add(m);
		w.setAssemblyStations(l);
		
		w.generateComponents(c, expectedComponents);
		assertEquals(expectedComponents,w.assemblyStations.get(0).c1.getStock());
	}
	
}
