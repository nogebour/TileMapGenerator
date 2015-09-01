package MapGenerator.MapGenerator;

public enum TileType {
	FIELD, 		// 0
	DESERT, 	// 1
	MOUNTAIN,	// 2
	HIGH_MOUNTAIN, // 3
	WATER,		// 4
	CITY;		// 5
	
	
	public static boolean excludedType(TileType type){
		if(type == CITY || type == HIGH_MOUNTAIN){
			return true;
		}
		return false;
	}
	
	public static int getIntValue(TileType theType){
		TileType[] theTypes = TileType.values();
		for(int i = 0; i < theTypes.length; i++){
			if (theType == theTypes[i]){
				return i;
			}
		}
		return -1;
	}
}


