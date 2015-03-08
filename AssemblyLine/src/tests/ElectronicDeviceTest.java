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

public class ElectronicDeviceTest {

	class CarMockUp extends Car {
		
		List<ElectronicDeviceMockUp> electronics;

		CarMockUp(String name, Chasis chasis, List<Wheel> wheels,
				Engine engine, List<ElectronicDeviceMockUp> electronics,
				List<Sit> sits, Upholstery uph, List<Glass> glasses) {

			this.electronics = electronics;
		}
		
		public List<ElectronicDeviceMockUp> getElectronicsMockUp() {
			return electronics;
		}
	}

	class ElectronicDeviceMockUp extends Chasis {

		ElectronicDeviceMockUp(String s) {
			super(s);
		}

		public String setup(CarMockUp c) {
			for (ElectronicDeviceMockUp e : c.getElectronicsMockUp()) {
				e.setIsPlaced(true);
			}
			// To change for graphic application instead of console output
			return "ElectronicDevice placed correctly";
		}
	}

	String randomString = "Sony";
	String randomString2 = "Pioner";
	CarMockUp car;

	@Test
	public void testInitialization() {
		ElectronicDevice e = new ElectronicDevice(randomString);
		assertEquals(randomString, e.getName());
	}

	@Test
	public void testInitializationNull() {
		ElectronicDevice e = new ElectronicDevice(null);
		assertEquals(null, e.getName());
	}

	@Test
	public void testGetName() {
		ElectronicDevice e = new ElectronicDevice(randomString);
		assertEquals(randomString, e.getName());
	}

	@Test
	public void testSetName() {
		ElectronicDevice e = new ElectronicDevice(randomString);
		e.setName(randomString2);
		assertEquals(randomString2, e.getName());
	}

	@Test
	public void testSetup() {
		ElectronicDeviceMockUp e = new ElectronicDeviceMockUp(randomString);
		List<ElectronicDeviceMockUp> list = new ArrayList<ElectronicDeviceMockUp>();
		list.add(e);
		car = new CarMockUp("", null, null, null, list, null, null, null);
		assertEquals("ElectronicDevice placed correctly", e.setup(car));
	}

}
