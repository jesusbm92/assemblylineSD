package domain;

import java.util.ArrayList;

public class Rules {

	public ArrayList<String> rulesList;
	
	public Rules()
	{
		rulesList = new ArrayList<String>();
	}
	
	//The handler will call addRule with the name of the 
	//object to add a rule
	public void addRule(String object)
	{
		rulesList.add(object);
		//order to create assembly station
		//AssemblyStation(Component);
		//So Rules must have a link with component to work with it
		//here the component is a String, so something will have
		//to turn it into a component (assemblystation work)
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
	
/*
 //test of the class Rules
		public static void main(String[] args) {
			Rules r = new Rules();
			System.out.println("Rules does not belongs : " + r.checkRule(1, "Murphy"));
			r.addRule("Carotte");
			System.out.println("Rules belongs : " + r.checkRule(1, "Carotte"));
			System.out.println("Rules does not belong : " + r.checkRule(1, "Ohm"));
		}
	*/
}
