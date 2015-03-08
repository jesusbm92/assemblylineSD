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

public class SitTest {

	class CarMockUp extends Car {

		List<SitMockUp> sits;

		CarMockUp(String name, Chasis chasis, List<Wheel> wheels,
				Engine engine, List<ElectronicDevice> electronics,
				List<SitMockUp> sits, Upholstery uph, List<Glass> glasses) {

			this.sits = sits;
		}

		public List<SitMockUp> getSitMockUp() {
			return sits;
		}

		public void setSits2(List<SitMockUp> sits) {
			this.sits = sits;
		}
	}

	class SitMockUp extends Glass {

		SitMockUp(String s) {
			super(s);
		}

		public String setup(CarMockUp c) {
			List<SitMockUp> l = new ArrayList<SitMockUp>();

			l = c.getSitMockUp();

			for (Glass g : l) {

				g.setIsPlaced(true);

			}

			c.setSits2(l);
			// To change for graphic application instead of console output
			return "Glasses placed correctly";
		}
	}

	String randomkindOfSit = "Front";
	String randomkindOfSit2 = "Back";
	CarMockUp car;

	@Test
	public void testInitialization() {
		Sit s = new Sit(randomkindOfSit);
		assertEquals(randomkindOfSit, s.getKindOfSit());
	}

	@Test
	public void testInitializationNull() {
		Sit s = new Sit(null);
		assertEquals(null, s.getKindOfSit());
	}

	@Test
	public void testKindOfSit() {
		Sit s = new Sit(randomkindOfSit);
		assertEquals(randomkindOfSit, s.getKindOfSit());
	}

	@Test
	public void testSetKindOfGlass() {
		Sit s = new Sit(randomkindOfSit);
		s.setKindOfSit(randomkindOfSit2);
		assertEquals(randomkindOfSit2, s.getKindOfSit());
	}

	@Test
	public void testSetup() {
		SitMockUp s = new SitMockUp(randomkindOfSit);
		List<SitMockUp> list = new ArrayList<SitMockUp>();
		list.add(s);
		car = new CarMockUp("", null, null, null, null, list, null, null);
		assertEquals("Glasses placed correctly", s.setup(car));
	}

}
