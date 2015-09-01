package MapGenerator.MapGenerator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Map {
	private TileType[][] map;
	private int[][] mapInt;
	private int height;
	private int width;
	/**
	 * @return the map
	 */
	public TileType[][] getMap() {
		return map;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(TileType[][] map) {
		this.map = map;
	}

	/**
	 * @return the mapInt
	 */
	public int[][] getMapInt() {
		return mapInt;
	}

	/**
	 * @param mapInt the mapInt to set
	 */
	public void setMapInt(int[][] mapInt) {
		this.mapInt = mapInt;
	}
	
	public Map(int height, int width){
		this.height=height;
		this.width=width;
		this.map = new TileType[width][height];
		this.mapInt = new int[width][height];
	}
	
	public String printMap(){
		HashMap<TileType,String> theStrings = new HashMap<TileType, String>();
    	theStrings.put(TileType.FIELD,"1"); 		// 0
    	theStrings.put(TileType.DESERT,"O"); 	// 1
    	theStrings.put(TileType.MOUNTAIN,"M");	// 2
		theStrings.put(TileType.WATER,"_");		// 3
		theStrings.put(TileType.CITY,"Z");
		theStrings.put(TileType.HIGH_MOUNTAIN,"H");
		String theSMap ="";
		for(int i = 0; i < mapInt.length; ++i){
        	for(int j = 0; j < mapInt[i].length; ++j){
        		theSMap += theStrings.get(map[i][j])+" ";
        	}
        	theSMap += "\n";
        }
		return theSMap;
	}
	
	public HashMap<TileType, Double> getStats(){
		HashMap<TileType, Double> theResult = new HashMap<TileType, Double>();
		for (int i =0; i<TileType.values().length; i++){
			theResult.put(TileType.values()[i], (double) 0);
		}
		int nbTiles = 0;
		for(int i = 0; i < mapInt.length; ++i){
        	for(int j = 0; j < mapInt[i].length; ++j){
        		theResult.put(map[i][j], theResult.get(map[i][j])+1);
        		nbTiles ++;
        	}
        }
		Iterator<TileType> theSet = theResult.keySet().iterator();
		while(theSet.hasNext()){
			TileType aType = theSet.next();
			theResult.put(aType, theResult.get(aType)/nbTiles);
		}
		return theResult;
	}
	
	public TileType getType(int height, int width){
		return map[height][width];
	}
	
	public TileType getNorthType(int height, int width){
		if(height == 0){
			return null;
		}
		return map[height-1][width];
	}
	public TileType getSouthType(int height, int width){
		if(height == map.length-1){
			return null;
		}
		return map[height+1][width];
	}
	public TileType getEastType(int height, int width){
		if(width == map[height].length-1){
			return null;
		}
		return map[height][width+1];
	}
	public TileType getWestType(int height, int width){
		if(width == 0){
			return null;
		}
		return map[height][width-1];
	}
	public TileType getNorthWestType(int height, int width){
		if(height == 0 || width == 0){
			return null;
		}
		return map[height-1][width-1];
	}
	public TileType getNorthEastType(int height, int width){
		if(height == 0 || width == map[height].length-1){
			return null;
		}
		return map[height-1][width+1];
	}
	public TileType getSouthEastType(int height, int width){
		if(height == map.length-1 || width == map[height].length-1){
			return null;
		}
		return map[height+1][width+1];
	}
	public TileType getSouthWestType(int height, int width){
		if(height == map.length-1 || width == 0){
			return null;
		}
		return map[height+1][width-1];
	}

}
