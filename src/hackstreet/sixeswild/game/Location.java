package hackstreet.sixeswild.game;

import java.util.ArrayList;

/**
 * Stores x and y coordinates on the game board.
 * 
 * @author Nicholas
 *
 */
public class Location {

	/** The x-coordinate of the tile, {0-8}. */
	private int x;
	
	/** The y-coordinate of the tile, {0-8}. */
	private int y;
	
	/**
	 * Location constructor.
	 * @param x The x-coordinate of the tile, {0-8}.
	 * @param y The y-coordinate of the tile, {0-8}.
	 */
	public Location(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	@Override
	public int hashCode(){
		return 13 * x + y;
	}
	
	public Location pullNearbyLocation(int xDiff, int yDiff){
		return new Location(this.x+xDiff,this.y+yDiff);
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Location){
			Location other = (Location)o;
			return other.x==this.x && other.y==this.y;
		}
		return false;
	}
		
	/**
	 * Returns a list of all the adjacent Location spots,
	 * without any checking for InertSlot, EliminationSlot, or
	 * already visited locations.
	 * 
	 * @return List of adjacent locations
	 */
	public ArrayList<Location> getRawAdjacentLocations() {	
		ArrayList<Location> adjacentLocs = new ArrayList<Location>();
		Location aboveLoc = new Location(this.x,this.y-1);
		if(aboveLoc.isValid())
			adjacentLocs.add(aboveLoc);
		
		Location rightLoc = new Location(this.x+1,this.y);
		if(rightLoc.isValid())
			adjacentLocs.add(rightLoc);
		
		Location belowLoc = new Location(this.x,this.y+1);
		if(belowLoc.isValid())
			adjacentLocs.add(belowLoc);
		
		Location leftLoc = new Location(this.x-1,this.y);
		if(leftLoc.isValid())
			adjacentLocs.add(leftLoc);
		
		return adjacentLocs;
	}
	
	public boolean isValid(){
		return this.x>=0 && this.x<=8 && this.y>=0 && this.y<=8;
	}
	
	@Override
	public String toString(){
		return "(" + x + "," + y + ")";
	}
}
