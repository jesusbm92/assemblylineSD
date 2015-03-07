package domain;

import java.util.List;

public class Car {
	private String name;
	private Chasis chasis;
	private List<Wheel> wheels;
	private Engine engine;
	private List<ElectronicDevice> electronics;
	private List<Sit> sits;
	private Upholstery uph;
	private List<Glass> glasses;

	public Car(String name, Chasis chasis, List<Wheel> wheels, Engine engine,
			List<ElectronicDevice> electronics, List<Sit> sits, Upholstery uph,
			List<Glass> glasses) {
		super();
		this.name = name;
		this.chasis = chasis;
		this.wheels = wheels;
		this.engine = engine;
		this.electronics = electronics;
		this.sits = sits;
		this.uph = uph;
		this.glasses = glasses;
	}

	public Car() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Chasis getChasis() {
		return chasis;
	}

	public void setChasis(Chasis chasis) {
		this.chasis = chasis;
	}

	public List<Wheel> getWheels() {
		return wheels;
	}

	public void setWheels(List<Wheel> wheels) {
		this.wheels = wheels;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public List<ElectronicDevice> getElectronics() {
		return electronics;
	}

	public void setElectronics(List<ElectronicDevice> electronics) {
		this.electronics = electronics;
	}

	public List<Sit> getSits() {
		return sits;
	}

	public void setSits(List<Sit> sits) {
		this.sits = sits;
	}

	public Upholstery getUph() {
		return uph;
	}

	public void setUph(Upholstery uph) {
		this.uph = uph;
	}

	public List<Glass> getGlasses() {
		return glasses;
	}

	public void setGlasses(List<Glass> glasses) {
		this.glasses = glasses;
	}

}
