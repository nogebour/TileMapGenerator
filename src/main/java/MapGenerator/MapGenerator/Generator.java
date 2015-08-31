package MapGenerator.MapGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Generator {
	private static final int DEFAULT = 20;
	private int height;
	private int width;
	protected List<Constraint> theConstraintList;
	protected Map theMap;
	
	public Generator (int height, int width){
		this.height=height;
		this.width=width;
		theMap = new Map(height, width);
		theConstraintList = new ArrayList<Constraint>();
	}

	public Generator (){
		this.height=Generator.DEFAULT;
		this.width=Generator.DEFAULT;
		theMap = new Map(Generator.DEFAULT, Generator.DEFAULT);
		theConstraintList = new ArrayList<Constraint>();
	}

	
	public Map execute(){
		TileType[][] map = theMap.getMap();
		int[][] mapInt = theMap.getMapInt();
		TileType[] theTypes = TileType.values();
		for(int i = 0; i < map.length; ++i){
        	for(int j = 0; j < map[i].length; ++j){
        		int resultTile = generateCase(theTypes);
        		map[i][j]=theTypes[resultTile];
        		mapInt[i][j]=resultTile;
        	}
        }
		this.assertConstraint();
		return theMap;
	}

	protected int generateCase(TileType[] theTypes) {
		int resultTile = randInt(0, theTypes.length-1);
		while (TileType.excludedType(theTypes[resultTile])){
			resultTile = randInt(0, theTypes.length-1);
		}
		return resultTile;
	}
	
	protected abstract void assertConstraint();

	/**
	 * @return the theMap
	 */
	public Map getTheMap() {
		return theMap;
	}

	/**
	 * @param theMap the theMap to set
	 */
	public void setTheMap(Map theMap) {
		this.theMap = theMap;
	}

	public int randInt(int min, int max) {

	    // NOTE: Usually this should be a field rather than a method
	    // variable so that it is not re-seeded every call.
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}

}
