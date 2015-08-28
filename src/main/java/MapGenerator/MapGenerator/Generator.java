package MapGenerator.MapGenerator;

import java.util.Random;

public class Generator {
	private static final int DEFAULT = 20;
	private int height;
	private int width;
	public TileType[][] map;
	public int[][] mapInt;
	
	public Generator (int height, int width){
		this.height=height;
		this.width=width;
	}

	public Generator (){
		this.height=Generator.DEFAULT;
		this.width=Generator.DEFAULT;
	}

	
	public TileType[][] execute(){
		map = new TileType[width][height];
		mapInt = new int[width][height];
		TileType[] theTypes = TileType.values();
		for(int i = 0; i < map.length; ++i){
        	for(int j = 0; j < map[i].length; ++j){
        		int resultTile = randInt(0, theTypes.length-1);
        		map[i][j]=theTypes[resultTile];
        		mapInt[i][j]=resultTile;
        	}
        }
		return map;
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
