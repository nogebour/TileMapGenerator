package MapGenerator.MapGenerator;

import java.util.ArrayList;
import java.util.List;

public abstract class Constraint {
	private List<TileType> theTypeConcerned;
	
	public Constraint(){
		theTypeConcerned = new ArrayList<TileType>();
	}
	
	public boolean isConcerned(TileType theType){
		return theTypeConcerned.contains(theType);
	}
	
	public boolean continueUntilOk(){
		return false;
	}
	
	public void addType(TileType aType){
		theTypeConcerned.add(aType);
	}
	
	public abstract boolean respectConstraints(Map theMap, int width, int height);
}
