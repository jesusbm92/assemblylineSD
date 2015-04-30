package domain;

import java.util.ArrayList;

public class Rules {

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
}
