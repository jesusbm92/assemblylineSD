package domain;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		Car carProduce = new Car();
		Main.putChasis(carProduce);
		Main.putWheels(carProduce);
		Main.putEngine(carProduce);
		Main.putElectronicDevice(carProduce);
		Main.putSit(carProduce);
		Main.putUpholstery(carProduce);
		Main.putGlass(carProduce);
		
	}
	
	static void putChasis(Car c){
		Chasis chasisAssamble = new Chasis();
		c.setChasis(chasisAssamble);
		c.getChasis().setup(c);
		
	}
	static void putWheels(Car c){
		List<Wheel> wheelList = new ArrayList<Wheel>();
		Wheel wheelFrontR = new Wheel();
		wheelFrontR.setKindOfWheel("Front Right");
		Wheel wheelFrontL = new Wheel();
		wheelFrontL.setKindOfWheel("Front Left");
		Wheel wheelBackR = new Wheel();
		wheelBackR.setKindOfWheel("Back Right");
		Wheel wheelBackL = new Wheel();
		wheelBackL.setKindOfWheel("Back Left");
		wheelList.add(wheelFrontR);
		wheelList.add(wheelFrontL);
		wheelList.add(wheelBackR);
		wheelList.add(wheelBackL);
		
		c.setWheels(wheelList);
		c.getWheels().get(0).setup(c);
		
		
	}
	static void putEngine(Car c){
		Engine engineAssambled = new Engine();
		engineAssambled.setBrand("Honda");
		engineAssambled.setHorsepower(200);
		c.setEngine(engineAssambled);
		c.getEngine().setup(c);
		
	}

	static void putElectronicDevice(Car c){
		List<ElectronicDevice> elDeviceAssambled = new ArrayList<ElectronicDevice>();
		ElectronicDevice elDMusic = new ElectronicDevice();
		elDMusic.setName("Music Device");
		ElectronicDevice elDRSensor = new ElectronicDevice();
		elDRSensor.setName("Rain Sensor");
		ElectronicDevice elDWindows = new ElectronicDevice();
		elDWindows.setName("Windows Control");
		ElectronicDevice elDCruise = new ElectronicDevice();
		elDCruise.setName("Cruise Control");
		elDeviceAssambled.add(elDMusic);
		elDeviceAssambled.add(elDRSensor);
		elDeviceAssambled.add(elDWindows);
		elDeviceAssambled.add(elDCruise);
		c.setElectronics(elDeviceAssambled);
		c.getElectronics().get(0).setup(c);
		
	}
	static void putSit(Car c){
		List<Sit> sitsAssambled = new ArrayList<Sit>();
		Sit sitFD = new Sit();
		sitFD.setKindOfSit("Front Driver");
		Sit sitCD = new Sit();
		sitCD.setKindOfSit("Co Driver");
		Sit sitBack = new Sit();
		sitBack.setKindOfSit("Back");
		sitsAssambled.add(sitFD);
		sitsAssambled.add(sitCD);
		sitsAssambled.add(sitBack);
		c.setSits(sitsAssambled);
		c.getSits().get(0).setup(c);

		
	}
	static void putUpholstery(Car c){
		Upholstery uphAssambled = new Upholstery();
		uphAssambled.setType("Red");
		c.setUph(uphAssambled);
		c.getUph().setup(c);
		
	}
	static void putGlass(Car c){
		List<Glass> glassAssambled = new ArrayList<Glass>();
		Glass glassF = new Glass();
		glassF.setKindOfGlass("Front");
		Glass glassB = new Glass();
		glassB.setKindOfGlass("Back");		
		Glass glassS = new Glass();
		glassS.setKindOfGlass("Side");
		glassAssambled.add(glassF);
		glassAssambled.add(glassB);
		glassAssambled.add(glassS);
		c.setGlasses(glassAssambled);
		c.getGlasses().get(0).setup(c);
		
	}

}

