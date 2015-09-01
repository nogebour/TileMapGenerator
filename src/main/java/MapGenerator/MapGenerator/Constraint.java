package MapGenerator.MapGenerator;

import java.util.ArrayList;
import java.util.List;

public abstract class Constraint {
	protected List<TileType> theTypeConcerned;
	protected boolean continueUntilOk;
	protected boolean isBycase;
	protected boolean endGeneration;
	
	public Constraint(){
		theTypeConcerned = new ArrayList<TileType>();
		continueUntilOk = false;
		isBycase = true;
		endGeneration = false;
	}
	
	public boolean isConcerned(TileType theType){
		return theTypeConcerned.contains(theType);
	}
	
	public boolean continueUntilOk(){
		return continueUntilOk;
	}
	
	public boolean isByCase(){
		return isBycase;
	}

	
	public void addType(TileType aType){
		theTypeConcerned.add(aType);
	}
	
	public abstract String toString(); 
	
	public abstract boolean respectConstraints(Map theMap, int width, int height);

	public abstract void tryResolveConstraint(Map theMap, int height, int width);

	public boolean isEndGeneration() {
		return endGeneration;
	}
}
