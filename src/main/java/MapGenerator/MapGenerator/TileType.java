package MapGenerator.MapGenerator;

public enum TileType {
	FIELD, 		// 0
	DESERT, 	// 1
	MOUNTAIN,	// 2
	WATER,		// 3
	CITY;		// 4
	
	
	public static boolean excludedType(TileType type){
		if(type == CITY){
			return true;
		}
		return false;
	}
}


