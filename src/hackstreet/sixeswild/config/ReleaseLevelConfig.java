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
	
	/** Number of moves in the game*/
	private int numMoves;
	/** List of bucket locations*/
	private List<Location> bucketLocations;
	/** List of six starter locations*/
	private List<Location> sixLocations;
	
	public ReleaseLevelConfig(int numMoves){
		super("Release");
		this.Type = "Release";
		this.numMoves = numMoves;
		this.bucketLocations = new ArrayList<Location>();
		this.sixLocations = new ArrayList<Location>();
	}
	
	public int getNumMoves() {
		return numMoves;
	}
	
	public void setSixLocations(ArrayList<Location> sixLocations){
		this.sixLocations = sixLocations;
	}
	
	public List<Location> getSixLocations(){
		return this.sixLocations;
	}
	
	public void setBucketLocations(ArrayList<Location> bucketLocations) {
		this.bucketLocations = bucketLocations;
	}
	
	public List<Location> getBucketLocations(){
		return this.bucketLocations;
	}
}
