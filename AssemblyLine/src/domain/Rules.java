package domain;

import java.util.ArrayList;
import java.util.List;

public class Rules {

    private List<SimpleComponent> rules = new ArrayList<SimpleComponent>();
	
	public Rules()
	{
		
	}
	
	//The handler will call addRule with the name of the 
	//object to add a rule
	public void addRule(SimpleComponent object)
	{
		rules.add(object);
	}
	
	public int size() {
		return rules.size();
	}
	
	public SimpleComponent getRuleAt(int index) {
		return rules.get(index);
	}
	
	//To check if the assembly is legitimate, a composed component can be checked against the rules
	public boolean checkProduct(ComposedComponent product)
	{
		if (product.retrieveComponents().size() != rules.size()) {
			return false;
		}
		
		for (int i=0; i<rules.size(); i++) {
			if (rules.get(i) != product.retrieveComponents().get(i)) {//@todo check this, comparing component with simplecomponent
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
