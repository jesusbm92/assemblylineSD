package domain;

public interface Command {
	
	//The command pattern is use to modularization and to
	//make the program able to be changed (for example assembly lines
	//of cars to another kind of assembly line

	public void setup(Object AssemblyLineItem);
}
