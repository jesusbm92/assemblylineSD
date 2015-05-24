package domain;

import java.util.ArrayList;
import java.util.List;

public class Rule {

    private List<SimpleComponent> rule = new ArrayList<SimpleComponent>();
	
	//The handler will call addRule with the name of the 
	//object to add a rule
	public void addComponent(SimpleComponent object)
	{
		rule.add(object);
	}
	
	public void removeComponent(SimpleComponent object){
		rule.remove(object);
	}
	
	public void removeComponentAt(int index){
		rule.remove(index);
	}
	
	public int size() {
		return rule.size();
	}
	
	public SimpleComponent getComponentAt(int index) {
		return rule.get(index);
	}
	
	//To check if the assembly is legitimate, a composed component can be checked against the rules
	public boolean checkProduct(ComposedComponent product)
	{
		if (product.retrieveComponents().size() != rule.size()) {
			return false;
		}
		
		for (int i=0; i<rule.size(); i++) {
			if (rule.get(i) != product.retrieveComponents().get(i)) {//@todo check this, comparing component with simplecomponent
				return false;
			}
		}
		
		return true;
	}
	
	
	
	/* Katrina commented this out!!!
	public ArrayList<String> rulesList;
	public AssemblyLine assline;
	
	public Rules()
	{
		rulesList = new ArrayList<String>();
		assline = new AssemblyLine();
		//rules is creating the assemblyline and owning it
	}
	
	//The handler will call addRule with the name of the 
	//object to add a rule
	public void addRule(String object)
	{
		rulesList.add(object);
		assline.addAssemblyStation(object);
		//order to create assembly station
		//AssemblyStation(Component);
		//component is a String to reduce the interdependance between the modules
		//assemblyline will call the method with component
	}
	
	//To check if the assembly is legitimate, the assembly line
	//call this fonction with the step number and name to add
	public boolean checkRule(int step, String objet)
	{
		if (rulesList.isEmpty())
		{
			return false;
		}
		else
		{
			return rulesList.get(step - 1) == objet;
		}
	}
	*/
}
