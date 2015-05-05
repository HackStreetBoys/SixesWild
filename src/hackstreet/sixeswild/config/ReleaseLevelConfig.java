package hackstreet.sixeswild.config;

import hackstreet.sixeswild.game.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Pat
 * 
 */
public class ReleaseLevelConfig extends AbstractLevelConfig {
	
	private int numMoves;
	private List<Location> bucketLocations;
	
	public ReleaseLevelConfig(int numMoves){
		super("Release");
		this.Type = "Release";
		this.numMoves = numMoves;
		this.bucketLocations = new ArrayList<Location>();
	}
	
	public int getNumMoves() {
		return numMoves;
	}
	
	public void setBucketLocations(ArrayList<Location> bucketLocations) {
		this.bucketLocations = bucketLocations;
	}
	
	public List<Location> getBucketLocations(){
		return this.bucketLocations;
	}
}
