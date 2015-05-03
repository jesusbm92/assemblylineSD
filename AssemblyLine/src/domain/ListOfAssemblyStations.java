package domain;

import java.util.ArrayList;
import java.util.List;

public class ListOfAssemblyStations {
	
	private List<AssemblyStation> orderedStations;
	private int lastStation;
	
	
	public ListOfAssemblyStations(){
		orderedStations = new ArrayList<AssemblyStation>();
		lastStation = -1;
	}
	
	public void addStation(AssemblyStation station){
		orderedStations.add(station);
	}
	
	public AssemblyStation getNextStation(){
		lastStation++;
		if (lastStation >= orderedStations.size()) {
			return null;
		}
		else
		{
			return orderedStations.get(lastStation);
		}
	}
	public int length(){
		return orderedStations.size();
	}
	
	public AssemblyStation get(int i){
		return orderedStations.get(i);
	}
}
