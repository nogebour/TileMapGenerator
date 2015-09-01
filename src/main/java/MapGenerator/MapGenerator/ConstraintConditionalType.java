package MapGenerator.MapGenerator;

public class ConstraintConditionalType extends Constraint{
	private TileType theNewtype;
	private int threshold;
	
	public ConstraintConditionalType(TileType aType, int threshold) {
		super();
		this.theNewtype = aType;
		this.endGeneration = true;
		this.threshold = threshold;
	}

	@Override
	public boolean respectConstraints(Map theMap, int width, int height) {
		return true;
	}

	@Override
	public void tryResolveConstraint(Map theMap, int i, int j) {
		TileType theType = theMap.getType(i, j);
		if(this.theTypeConcerned.contains(theMap.getType(i, j))){
			int nbTypeNear = 0;
			if(theMap.getNorthType(i, j) == theType){
				nbTypeNear++;
			}
			if(theMap.getSouthType(i, j) == theType){
				nbTypeNear++;
			}
			if(theMap.getEastType(i, j) == theType){
				nbTypeNear++;
			}
			if(theMap.getWestType(i, j) == theType){
				nbTypeNear++;
			}
			if(nbTypeNear >= this.threshold){
				theMap.getMap()[i][j]=theNewtype;
				theMap.getMapInt()[i][j]=TileType.getIntValue(theNewtype);
			}
		}
	}

	@Override
	public String toString() {
		return "CONSTRAINT CONDITIONAL TYPE";
	}	
}
