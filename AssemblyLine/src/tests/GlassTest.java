package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import domain.Car;
import domain.Chasis;
import domain.ElectronicDevice;
import domain.Engine;
import domain.Glass;
import domain.Sit;
import domain.Upholstery;
import domain.Wheel;

public class GlassTest {

	class CarMockUp extends Car {

		List<GlassMockUp> glasses;

		CarMockUp(String name, Chasis chasis, List<Wheel> wheels,
				Engine engine, List<ElectronicDevice> electronics,
				List<Sit> sits, Upholstery uph, List<GlassMockUp> glasses) {

			this.glasses = glasses;
		}

		public List<GlassMockUp> getGlassMockUp() {
			return glasses;
		}

		public void setGlasses2(List<GlassMockUp> glasses) {
			this.glasses = glasses;
		}
	}

	class GlassMockUp extends Glass {

		GlassMockUp(String s) {
			super(s);
		}

		public String setup(CarMockUp c) {
			List<GlassMockUp> l = new ArrayList<GlassMockUp>();

			l = c.getGlassMockUp();

			for (Glass g : l) {

				g.setIsPlaced(true);

			}

			c.setGlasses2(l);
			// To change for graphic application instead of console output
			return "Glasses placed correctly";
		}
	}

	String randomGlass = "Type 1";
	String randomGlass2 = "Type 2";
	CarMockUp car;

	@Test
	public void testInitialization() {
		Glass g = new Glass(randomGlass);
		assertEquals(randomGlass, g.getKindOfGlass());
	}

	@Test
	public void testInitializationNull() {
		Glass g = new Glass(null);
		assertEquals(null, g.getKindOfGlass());
	}

	@Test
	public void testKindOfGlass() {
		Glass g = new Glass(randomGlass);
		assertEquals(randomGlass, g.getKindOfGlass());
	}

	@Test
	public void testSetKindOfGlass() {
		Glass g = new Glass(randomGlass);
		g.setKindOfGlass(randomGlass2);
		assertEquals(randomGlass2, g.getKindOfGlass());
	}

	@Test
	public void testSetup() {
		GlassMockUp g = new GlassMockUp(randomGlass);
		List<GlassMockUp> list = new ArrayList<GlassMockUp>();
		list.add(g);
		car = new CarMockUp("", null, null, null, null, null, null, list);
		assertEquals("Glasses placed correctly", g.setup(car));
	}

}
