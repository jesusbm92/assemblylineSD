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

public class WheelTest {

	class CarMockUp extends Car {

		List<WheelMockUp> wheels;

		CarMockUp(String name, Chasis chasis, List<WheelMockUp> wheels,
				Engine engine, List<ElectronicDevice> electronics,
				List<Sit> sits, Upholstery uph, List<Glass> glasses) {

			this.wheels = wheels;
		}

		public List<WheelMockUp> getWheelMockUp() {
			return wheels;
		}

		public void setWheel2(List<WheelMockUp> wheels) {
			this.wheels = wheels;
		}
	}

	class WheelMockUp extends Wheel {

		WheelMockUp(String s) {
			super(s);
		}

		public String setup(CarMockUp c) {
			List<WheelMockUp> l = new ArrayList<WheelMockUp>();

			l = c.getWheelMockUp();

			for (Wheel g : l) {

				g.setIsPlaced(true);

			}

			c.setWheel2(l);
			// To change for graphic application instead of console output
			return "Wheels placed correctly";
		}
	}

	String randomkindOfWheel = "Front left";
	String randomkindOfWheel2 = "Back left";
	CarMockUp car;

	@Test
	public void testInitialization() {
		Wheel w = new Wheel(randomkindOfWheel);
		assertEquals(randomkindOfWheel, w.getKindOfWheel());
	}

	@Test
	public void testInitializationNull() {
		Wheel w = new Wheel(null);
		assertEquals(null, w.getKindOfWheel());
	}

	@Test
	public void testKindOfWheel() {
		Wheel w = new Wheel(randomkindOfWheel);
		assertEquals(randomkindOfWheel, w.getKindOfWheel());
	}

	@Test
	public void testSetKindOfWheel() {
		Wheel w = new Wheel(randomkindOfWheel);
		w.setKindOfWheel(randomkindOfWheel2);
		assertEquals(randomkindOfWheel2, w.getKindOfWheel());
	}

	@Test
	public void testSetup() {
		WheelMockUp w = new WheelMockUp(randomkindOfWheel);
		List<WheelMockUp> list = new ArrayList<WheelMockUp>();
		list.add(w);
		car = new CarMockUp("", null, list, null, null, null, null, null);
		assertEquals("Wheels placed correctly", w.setup(car));
	}

}
