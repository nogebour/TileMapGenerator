package MapGenerator.MapGenerator;

import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	HashMap<TileType,String> theStrings = new HashMap<TileType, String>();
    	theStrings.put(TileType.FIELD,"1"); 		// 0
    	theStrings.put(TileType.DESERT,"O"); 	// 1
    	theStrings.put(TileType.MOUNTAIN,"M");	// 2
		theStrings.put(TileType.WATER,"_");		// 3
		theStrings.put(TileType.CITY,"Z");
        Generator aGen = new GeneratorClassic(50,50);
        aGen.execute();
        Map theMap = aGen.getTheMap();
        int[][] theMapInt = theMap.getMapInt();
        float[] statMap = new float[TileType.values().length];
        int nbTiles = 0;
        //TileType[][] theMap = aGen.execute();
        String theSMap = "";
        for(int i = 0; i < theMapInt.length; ++i){
        	for(int j = 0; j < theMapInt[i].length; ++j){
        		theSMap += theStrings.get(theMap.getMap()[i][j])+" ";
        		statMap[theMapInt[i][j]] += 1;
        		nbTiles ++;
        	}
        	theSMap += "\n";
        }
        System.out.println(theSMap);
        System.out.println(theMap.getType(1, 1));
        System.out.println(theMap.getNorthType(1, 1));
        System.out.println(theMap.getSouthType(1, 1));
        System.out.println(theMap.getEastType(1, 1));
        System.out.println(theMap.getWestType(1, 1));
        System.out.println(theMap.getNorthEastType(1, 1));
        System.out.println(theMap.getSouthEastType(1, 1));
        System.out.println(theMap.getNorthWestType(1, 1));
        System.out.println(theMap.getSouthWestType(1, 1));
        System.out.println("////////////////////////////");
        System.out.println(theMap.getType(0,0));
        System.out.println(theMap.getNorthType(0,0));
        System.out.println(theMap.getSouthType(0,0));
        System.out.println(theMap.getEastType(0,0));
        System.out.println(theMap.getWestType(0,0));
        System.out.println(theMap.getNorthEastType(0,0));
        System.out.println(theMap.getSouthEastType(0,0));
        System.out.println(theMap.getNorthWestType(0,0));
        System.out.println(theMap.getSouthWestType(0,0));
        System.out.println("////////////////////////////");
        System.out.println(theMap.getType(19,19));
        System.out.println(theMap.getNorthType(19,19));
        System.out.println(theMap.getSouthType(19,19));
        System.out.println(theMap.getEastType(19,19));
        System.out.println(theMap.getWestType(19,19));
        System.out.println(theMap.getNorthEastType(19,19));
        System.out.println(theMap.getSouthEastType(19,19));
        System.out.println(theMap.getNorthWestType(19,19));
        System.out.println(theMap.getSouthWestType(19,19));
        String stats = "Stats for map:";
        for (int i = 0; i< TileType.values().length; i++){
            stats += " "+(statMap[i]*100/nbTiles)+"% "+TileType.values()[i];        	
        }
        System.out.println("Stats :"+stats);
    }
}
