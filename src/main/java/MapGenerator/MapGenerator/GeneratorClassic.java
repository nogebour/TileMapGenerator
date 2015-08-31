package MapGenerator.MapGenerator;

import java.util.Iterator;

public class GeneratorClassic extends Generator {

	public GeneratorClassic (int height, int width){
		super(height, width);
		Constraint theConst = new ConstraintNotAlone();
		theConst.addType(TileType.FIELD);
		theConst.addType(TileType.MOUNTAIN);
		theConst.addType(TileType.DESERT);
		this.theConstraintList.add(theConst);
		theConst = new ConstraintNotTooMuch(0.20);
		theConst.addType(TileType.WATER);
		this.theConstraintList.add(theConst);
	}

	public GeneratorClassic (){
		super();
		Constraint theConst = new ConstraintNotAlone();
		theConst.addType(TileType.FIELD);
		theConst.addType(TileType.MOUNTAIN);
		theConst.addType(TileType.DESERT);
		this.theConstraintList.add(theConst);
		theConst = new ConstraintNotTooMuch(0.20);
		theConst.addType(TileType.WATER);
		this.theConstraintList.add(theConst);
	}

	@Override
	protected void assertConstraint() {
		System.out.println("Start Assert");
		TileType[] theTypes = TileType.values();
		TileType[][] aMap = theMap.getMap();
		int[][] aMapInt = theMap.getMapInt();
		boolean status = true;
		do{
			for(int i = 0; i < aMap.length; ++i){
				System.out.println("Start height");
				for(int j = 0; j < aMap[i].length; ++j){
					System.out.println("Start width");
					Iterator<Constraint> iterator = this.theConstraintList.iterator();
					while (iterator.hasNext()) {
						System.out.println("Start Constraint");
						Constraint aConstraint = iterator.next();        			
						if (aConstraint.isConcerned(aMap[i][j])){
							if(!aConstraint.respectConstraints(theMap, j, i)){
								int resultTile = generateCase(theTypes);
								System.out.println("Replace case ("+i+","+j+") with type : "+aMap[i][j]+" by type "+theTypes[resultTile]+".");
								aMap[i][j]=theTypes[resultTile];
								aMapInt[i][j]=resultTile;
								while(aConstraint.continueUntilOk() && !aConstraint.respectConstraints(theMap, j, i)){
									resultTile = generateCase(theTypes);
									System.out.println("Replace case ("+i+","+j+") with type : "+aMap[i][j]+" by type "+theTypes[resultTile]+".");
									aMap[i][j]=theTypes[resultTile];
									aMapInt[i][j]=resultTile;                    			
								}
							}
						}        			
					}
				}
			}
		}while(!status);
		System.out.println("End Assert");
	}
}
