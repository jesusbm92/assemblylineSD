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

public class EngineTest {

class CarMockUp extends Car{
		
		CarMockUp(String name, Chasis chasis, List<Wheel> wheels, Engine engine,
				List<ElectronicDevice> electronics, List<Sit> sits, Upholstery uph,
				List<Glass> glasses) {
			super(name,chasis,wheels,engine,electronics,sits,uph,glasses);
	}
	}
	
	class EngineMockUp extends Engine{
		
		EngineMockUp(String s, Integer i){
			super(s,i);
		}
		
		public String setup(CarMockUp c) {
			c.getEngine().setIsPlaced(true);
			// To change for graphic application instead of console output
			return "Engine placed correctly";
		}
	}
	

	
	String randomBrand = "Honda";
	String randomBrand2 = "Ferrari";
	
	Integer randomHorsepower = 200;
	Integer randomHorsepower2 = 350;
	
	CarMockUp car;
	

	@Test
	public void testInitialization() {
		Engine e = new Engine(randomBrand,randomHorsepower);
		assertEquals(randomBrand, e.getBrand());
	}
	
	@Test
	public void testInitializationNull() {
		Engine e = new Engine(null,null);
		assertEquals(null, e.getBrand());
	}
	
	@Test
	public void testGetBrand() {
		Engine e = new Engine(randomBrand, randomHorsepower);
		assertEquals(randomBrand, e.getBrand());
	}
	
	@Test
	public void testSetBrand() {
		Engine e = new Engine(randomBrand, randomHorsepower);
		e.setBrand(randomBrand2);
		assertEquals(randomBrand2, e.getBrand());
	}
	
	@Test
	public void testGetHorsepower() {
		Engine e = new Engine(randomBrand, randomHorsepower);
		assertEquals(randomHorsepower, e.getHorsepower());
	}
	
	@Test
	public void testSetHorsepower() {
		Engine e = new Engine(randomBrand, randomHorsepower);
		e.setHorsepower(randomHorsepower2);
		assertEquals(randomHorsepower2, e.getHorsepower());
	}
	
	@Test
	public void testSetup() {
		EngineMockUp e = new EngineMockUp(randomBrand, randomHorsepower);
		car = new CarMockUp("",null,null,e,null,null,null,null);
		assertEquals("Engine placed correctly",e.setup(car));
	}

}
