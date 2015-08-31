package MapGenerator.MapGenerator;

public class ConstraintNotTooMuch extends Constraint {
	private double threshold;
	
	public ConstraintNotTooMuch(double threshold) {
		super();
		this.threshold = threshold;
	}
	
	@Override
	public boolean respectConstraints(Map theMap, int width, int height) {
		System.out.println("DEBUG 001 - "+this.threshold);
		if(this.isConcerned(theMap.getType(height, width))){
			if(theMap.getStats().get(theMap.getType(height, width)) > this.threshold){
				System.out.println("Case ("+height+","+width+") does not respect");
				return false;
			}
			return true;
		}
		return true;
	}

}
