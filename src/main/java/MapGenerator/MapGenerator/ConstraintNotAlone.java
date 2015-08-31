package MapGenerator.MapGenerator;

public class ConstraintNotAlone extends Constraint {
	
	public ConstraintNotAlone() {
		super();
		continueUntilOk = true;
	}	

	@Override
	public boolean respectConstraints(Map theMap, int width, int height) {
		if(this.isConcerned(theMap.getType(height, width))){
			TileType theTile = theMap.getType(height, width);
			System.out.println("Tile type is "+theTile);
			System.out.println("North Tile type is "+theMap.getNorthType(height, width));
			if(theMap.getNorthType(height, width) == theTile){
				return true;
			}
			System.out.println("South Tile type is "+theMap.getSouthType(height, width));
			if(theMap.getSouthType(height, width) == theTile){
				return true;
			}
			System.out.println("East Tile type is "+theMap.getEastType(height, width) );
			if(theMap.getEastType(height, width) == theTile){
				return true;
			}
			System.out.println("West Tile type is "+theMap.getWestType(height, width));
			if(theMap.getWestType(height, width) == theTile){
				return true;
			}
			System.out.println("Does not respect");
			return false;
		}
		System.out.println("Is not concerned");
		return true;
	}

	@Override
	public void tryResolveConstraint(Map theMap, int i, int j) {
		int resultTile = Generator.generateCase(TileType.values());
		System.out.println("Replace case ("+i+","+j+") with type : "+theMap.getMap()[i][j]+" by type "+TileType.values()[resultTile]+".");
		theMap.getMap()[i][j]=TileType.values()[resultTile];
		theMap.getMapInt()[i][j]=resultTile;
	}

}
