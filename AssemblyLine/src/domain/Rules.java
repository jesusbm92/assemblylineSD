package domain;

import java.util.ArrayList;

public class Rules {

	public ListOfAssemblyStations rulesList;
	public AssemblyLine assline;
	
	public Rules()
	{
		rulesList = new ListOfAssemblyStations();
		assline = new AssemblyLine();
		assline.setAssemblyStationOrderList(rulesList);
		
		
		/*for now hardcoded rules in constructor, later move this out to add rules */
		Circle circle1 = new Circle();
		Circle circle2 = new Circle();
		Rectangle rect = new Rectangle();
		SimpleComponent wheel1 = new SimpleComponent();
		SimpleComponent wheel2 = new SimpleComponent();
		SimpleComponent corpus = new SimpleComponent();
		//wheel1.setFigure(circle1);
		//wheel2.setFigure(circle2);
		//corpus.setFigure(rect);
		AssemblyStation as1 = new AssemblyStation(wheel1);
		AssemblyStation as2 = new AssemblyStation(wheel2);
		AssemblyStation as3 = new AssemblyStation(corpus);
		
		rulesList.addStation(as1);
		rulesList.addStation(as2);
		rulesList.addStation(as3);
		/*for now hardcoded rules in constructor, later move this out to add rules */		
		//rules is creating the assemblyline and owning it
	}
	
	//The handler will call addRule with the name of the 
	//object to add a rule
	public void addRule(AssemblyStation object)
	{
		rulesList.addStation(object);
	}
	
	//To check if the assembly is legitimate, the assembly line
	//call this fonction with the step number and name to add
	public boolean checkRule(int step, AssemblyStation objet)
	{
		if (rulesList.length() == 0)
		{
			return false;
		}
		else
		{
			return rulesList.get(step - 1) == objet;
		}
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
