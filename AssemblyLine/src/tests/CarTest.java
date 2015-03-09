package domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CarTest {



	@Test
	public void testGetName() {
		Car car = new Car();
		String model = "Porse";
		car.setName(model);	
		assertEquals(model, car.getName());
	}

	@Test
	public void testSetName() {
		Car car = new Car();
		String model = "Porse";
		car.setName(model);	
		assertEquals(model, car.getName());
	}

	@Test
	public void testGetChasis() {
		Car car = new Car();
		Chasis chasis = new Chasis();
		car.setChasis(chasis);
		assertEquals(chasis, car.getChasis());
	}

	@Test
	public void testSetChasis() {
		Car car = new Car();
		Chasis chasis = new Chasis();
		car.setChasis(chasis);
		assertEquals(chasis, car.getChasis());
	}

	@Test
	public void testGetWheels() {
		Car car = new Car();
		List<Wheel> wheelList = new ArrayList<Wheel>();
		Wheel wheelFrontR = new Wheel();
		Wheel wheelFrontL = new Wheel();
		Wheel wheelBackR = new Wheel();
		Wheel wheelBackL = new Wheel();
		wheelList.add(wheelFrontR);
		wheelList.add(wheelFrontL);
		wheelList.add(wheelBackR);
		wheelList.add(wheelBackL);
		
		car.setWheels(wheelList);
		assertEquals(wheelList, car.getWheels());
		
	}

	@Test
	public void testSetWheels() {
		Car car = new Car();
		List<Wheel> wheelList = new ArrayList<Wheel>();
		Wheel wheelFrontR = new Wheel();
		Wheel wheelFrontL = new Wheel();
		Wheel wheelBackR = new Wheel();
		Wheel wheelBackL = new Wheel();
		wheelList.add(wheelFrontR);
		wheelList.add(wheelFrontL);
		wheelList.add(wheelBackR);
		wheelList.add(wheelBackL);
		
		car.setWheels(wheelList);
		assertEquals(wheelList, car.getWheels());
	}

	@Test
	public void testGetEngine() {
		Car car = new Car();
		Engine engineAssambled = new Engine();
		car.setEngine(engineAssambled);
		assertEquals(engineAssambled, car.getEngine());
	}

	@Test
	public void testSetEngine() {
		Car car = new Car();
		Engine engineAssambled = new Engine();
		car.setEngine(engineAssambled);
		assertEquals(engineAssambled, car.getEngine());
	}

	@Test
	public void testGetElectronics() {
		Car car = new Car();
		List<ElectronicDevice> elDeviceAssambled = new ArrayList<ElectronicDevice>();
		ElectronicDevice elDMusic = new ElectronicDevice();
		ElectronicDevice elDRSensor = new ElectronicDevice();
		ElectronicDevice elDWindows = new ElectronicDevice();
		ElectronicDevice elDCruise = new ElectronicDevice();
		elDeviceAssambled.add(elDMusic);
		elDeviceAssambled.add(elDRSensor);
		elDeviceAssambled.add(elDWindows);
		elDeviceAssambled.add(elDCruise);
		car.setElectronics(elDeviceAssambled);
		assertEquals(elDeviceAssambled, car.getElectronics());
	}

	@Test
	public void testSetElectronics() {
		Car car = new Car();
		List<ElectronicDevice> elDeviceAssambled = new ArrayList<ElectronicDevice>();
		ElectronicDevice elDMusic = new ElectronicDevice();
		ElectronicDevice elDRSensor = new ElectronicDevice();
		ElectronicDevice elDWindows = new ElectronicDevice();
		ElectronicDevice elDCruise = new ElectronicDevice();
		elDeviceAssambled.add(elDMusic);
		elDeviceAssambled.add(elDRSensor);
		elDeviceAssambled.add(elDWindows);
		elDeviceAssambled.add(elDCruise);
		car.setElectronics(elDeviceAssambled);
		assertEquals(elDeviceAssambled, car.getElectronics());
	}

	@Test
	public void testGetSits() {
		Car car = new Car();
		List<Sit> sitsAssambled = new ArrayList<Sit>();
		Sit sitFD = new Sit();
		Sit sitCD = new Sit();
		Sit sitBack = new Sit();
		sitsAssambled.add(sitFD);
		sitsAssambled.add(sitCD);
		sitsAssambled.add(sitBack);
		car.setSits(sitsAssambled);
		assertEquals(sitsAssambled, car.getSits());
	}

	@Test
	public void testSetSits() {
		Car car = new Car();
		List<Sit> sitsAssambled = new ArrayList<Sit>();
		Sit sitFD = new Sit();
		Sit sitCD = new Sit();
		Sit sitBack = new Sit();
		sitsAssambled.add(sitFD);
		sitsAssambled.add(sitCD);
		sitsAssambled.add(sitBack);
		car.setSits(sitsAssambled);
		assertEquals(sitsAssambled, car.getSits());
	}

	@Test
	public void testGetUph() {
		Car car = new Car();
		Upholstery uphAssambled = new Upholstery();
		car.setUph(uphAssambled);
		assertEquals(uphAssambled, car.getUph());
	}

	@Test
	public void testSetUph() {
		Car car = new Car();
		Upholstery uphAssambled = new Upholstery();
		car.setUph(uphAssambled);
		assertEquals(uphAssambled, car.getUph());
	}

	@Test
	public void testGetGlasses() {
		Car car = new Car();
		List<Glass> glassAssambled = new ArrayList<Glass>();
		Glass glassF = new Glass();
		Glass glassB = new Glass();	
		Glass glassS = new Glass();
		glassAssambled.add(glassF);
		glassAssambled.add(glassB);
		glassAssambled.add(glassS);
		car.setGlasses(glassAssambled);
		assertEquals(glassAssambled, car.getGlasses());
	}

	@Test
	public void testSetGlasses() {
		Car car = new Car();
		List<Glass> glassAssambled = new ArrayList<Glass>();
		Glass glassF = new Glass();
		Glass glassB = new Glass();	
		Glass glassS = new Glass();
		glassAssambled.add(glassF);
		glassAssambled.add(glassB);
		glassAssambled.add(glassS);
		car.setGlasses(glassAssambled);
		assertEquals(glassAssambled, car.getGlasses());
	}

}
