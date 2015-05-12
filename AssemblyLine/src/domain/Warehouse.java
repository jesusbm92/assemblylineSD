package domain;

import java.util.List;

public class Warehouse {
	
	List <EntryComponent> components;
	
	public Warehouse() {
		super();
	}
	
	public void addNewComponent(EntryComponent e){
		components.add(e);
	}
	
	public void removeComponent(EntryComponent e){
		components.remove(e);
	}
	


}
