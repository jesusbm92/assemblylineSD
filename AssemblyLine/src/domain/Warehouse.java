package domain;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Warehouse {
	
	List<EntryComponent> components;
	
	public Warehouse() {
		populateWarehouse();
	}
	
	public void addNewComponent(EntryComponent e){
		components.add(e);
	}
	
	public void removeComponent(EntryComponent e){
		components.remove(e);
	}
	
	public List<EntryComponent> getAvailableComponents() {
		return components;
	}
	
	private void populateWarehouse() {
		components = createDemoEntryComponents(createDemoObjects());
	}

	private List<EntryComponent> createDemoEntryComponents(List<SimpleComponent> availableComponents) {
		List<EntryComponent> list = new ArrayList<EntryComponent>();
		for (SimpleComponent component : availableComponents) {
			EntryComponent entry = new EntryComponent(component);
			entry.requestStock(5);
			component.setEntryComponent(entry);
			list.add(entry);
		}
		return list;
	}

	private List<SimpleComponent> createDemoObjects() {
		List<SimpleComponent> list = new ArrayList<SimpleComponent>();
		
		SimpleComponent wheel = new SimpleComponent("wheel");
		SimpleComponent engine = new SimpleComponent("engine");
		SimpleComponent window = new SimpleComponent("window");
		
		Circle circle = new Circle(10, 10, Color.GREEN);
		Rectangle rect = new Rectangle(10, 10, Color.RED);
		Triangle triangle = new Triangle(10, 10, Color.BLUE);

		wheel.setFigure(circle);
		engine.setFigure(rect);
		window.setFigure(triangle);
		
		//hardcoded price but should be changed
		wheel.setPrice(new Price(5.2));
		engine.setPrice(new Price(100));
		window.setPrice(new Price(45));
		
		list.add(wheel);
		list.add(engine);
		list.add(window);
		
		return list;
	}
}
