package MapGenerator.MapGenerator;

import java.util.HashMap;
import java.util.Iterator;

public class ConstraintNotTooMuch extends Constraint {
	private double threshold;

	public ConstraintNotTooMuch(double threshold) {
		super();
		this.threshold = threshold;
		this.isBycase = false;
	}

	@Override
	public boolean respectConstraints(Map theMap, int width, int height) {
		Iterator<TileType> typeIterator = this.theTypeConcerned.iterator();
		while(typeIterator.hasNext()){
			if(theMap.getStats().get(typeIterator.next()) > this.threshold){
				return false;
			}
		}
		return true;
	}

	private boolean isAlone(Map theMap, int width, int height, TileType theType){
		return !(theMap.getNorthType(height, width) == theType && theMap.getSouthType(height, width) == theType && theMap.getWestType(height, width) == theType && theMap.getEastType(height, width) == theType);
	}
	
	@Override
	public void tryResolveConstraint(Map theMap, int width, int height) {
		Iterator<TileType> typeIterator = this.theTypeConcerned.iterator();
		while(typeIterator.hasNext()){
			TileType aType = typeIterator.next();
			if(theMap.getStats().get(aType) > this.threshold){
				for(int i = 0; i < theMap.getMap().length; ++i){
					for(int j = 0; j < theMap.getMap()[i].length; ++j){
						if(theMap.getMap()[i][j] == aType && isAlone(theMap, j, i, aType)){
							int resultTile = Generator.generateCase(TileType.values());
							System.out.println("Replace case ("+i+","+j+") with type : "+theMap.getMap()[i][j]+" by type "+TileType.values()[resultTile]+".");
							theMap.getMap()[i][j]=TileType.values()[resultTile];
							theMap.getMapInt()[i][j]=resultTile;
						}
					}
				}
			}
		}

	}

}
