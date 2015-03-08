package tests;

import static org.junit.Assert.*;

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

public class ChasisTest {
	
	class CarMockUp extends Car{
		
		CarMockUp(String name, Chasis chasis, List<Wheel> wheels, Engine engine,
				List<ElectronicDevice> electronics, List<Sit> sits, Upholstery uph,
				List<Glass> glasses) {
			super(name,chasis,wheels,engine,electronics,sits,uph,glasses);
	}
	}
	
	class ChasisMockUp extends Chasis{
		
		ChasisMockUp(String s){
			super(s);
		}
		
		public String setup(CarMockUp c) {
			c.getChasis().setIsPlaced(true);
			// To change for graphic application instead of console output
			return "Chasis placed correctly";
		}
	}
	

	
	String randomString = "Astra";
	String randomString2 = "Corsa";
	CarMockUp car;
	

	@Test
	public void testInitialization() {
		Chasis c = new Chasis(randomString);
		assertEquals(randomString, c.getModel());
	}
	
	@Test
	public void testInitializationNull() {
		Chasis c = new Chasis(null);
		assertEquals(null, c.getModel());
	}
	
	@Test
	public void testGetModel() {
		Chasis c = new Chasis(randomString);
		assertEquals(randomString, c.getModel());
	}
	
	@Test
	public void testSetModel() {
		Chasis c = new Chasis(randomString);
		c.setModel(randomString2);
		assertEquals(randomString2, c.getModel());
	}
	
	@Test
	public void testSetup() {
		ChasisMockUp c = new ChasisMockUp(randomString);
		car = new CarMockUp("",c,null,null,null,null,null,null);
		assertEquals("Chasis placed correctly",c.setup(car));
	}

}
