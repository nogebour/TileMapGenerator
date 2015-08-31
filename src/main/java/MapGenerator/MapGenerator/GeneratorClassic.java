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
		theConst = new ConstraintNotTooMuch(0.25);
		theConst.addType(TileType.MOUNTAIN);
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
			status = true;
			Iterator<Constraint> iterator = this.theConstraintList.iterator();
			while (iterator.hasNext()) {
				Constraint aConstraint = iterator.next();
				if(aConstraint.isByCase()){
					if(!aConstraint.respectConstraints(theMap, 0, 0)){
						status = false;
						aConstraint.tryResolveConstraint(theMap,0,0);
						while(aConstraint.continueUntilOk() && !aConstraint.respectConstraints(theMap, 0, 0)){
							aConstraint.tryResolveConstraint(theMap,0,0);
						}
					}
				}
			}
			for(int i = 0; i < aMap.length; ++i){
				System.out.println("Start height");
				for(int j = 0; j < aMap[i].length; ++j){
					System.out.println("Start width");
					iterator = this.theConstraintList.iterator();
					while (iterator.hasNext()) {
						System.out.println("Start Constraint");
						Constraint aConstraint = iterator.next();        			
						if (aConstraint.isConcerned(aMap[i][j])){
							if(!aConstraint.respectConstraints(theMap, j, i)){
								status = false;
								aConstraint.tryResolveConstraint(theMap, i, j);
								while(aConstraint.continueUntilOk() && !aConstraint.respectConstraints(theMap, j, i)){
									aConstraint.tryResolveConstraint(theMap, i, j);                  			
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
