package hackstreet.sixeswild.game;

import java.util.ArrayList;
import java.util.Arrays;

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
		if (x >= 0 && x <= 8)
			this.x = x;
		else
			throw new IllegalArgumentException("x must be between 0 and 8.");
		
		if (y >= 0 && y <= 8)
			this.y = y;
		else
			throw new IllegalArgumentException("y must be between 0 and 8.");
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
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
	public ArrayList<Location> getRawAdjacentLocations()
	{	
		int size = 9;
		ArrayList<Location> adj = new ArrayList<Location>();
		
		// not along an edge
		if ((this.getX() != 0) && (this.getY() != 0) && (this.getX() != size-1) && (this.getY() != size-1))
		{
			adj.addAll(Arrays.asList(
					new Location(this.getX()-1,this.getY()),
					new Location(this.getX(),this.getY()-1), new Location(this.getX(),this.getY()+1),
					new Location(this.getX()+1,this.getY())
					));
		}
		// top left corner
		else if (this.getX() == 0 && this.getY() == 0)
		{
			adj.addAll(Arrays.asList(
					new Location(this.getX(),this.getY()+1),
					new Location(this.getX()+1,this.getY())
					));
		}
		// top right corner
		else if (this.getX() == 0 && this.getY() == size-1)
		{
			adj.addAll(Arrays.asList(
					new Location(this.getX(),this.getY()-1),
					new Location(this.getX()+1,this.getY())
					));
		}
		// bottom right corner
		else if (this.getX() == size-1 && this.getY() == size-1)
		{
			adj.addAll(Arrays.asList(
					new Location(this.getX()-1,this.getY()),
					new Location(this.getX(),this.getY()-1)
					));
		}
		// bottom left corner
		else if (this.getX() == size-1 && this.getY() == 0)
		{
			adj.addAll(Arrays.asList(
					new Location(this.getX()-1,this.getY()),
					new Location(this.getX(),this.getY()+1)
					));
		}
		// top edge
		else if (this.getX() == 0 && this.getY() == 0)
		{
			adj.addAll(Arrays.asList(
					new Location(this.getX(),this.getY()-1), new Location(this.getX(),this.getY()+1),
					new Location(this.getX()+1,this.getY())
					));
		}
		// left edge
		else if (this.getX() == size-1 && this.getY() == 0)
		{
			adj.addAll(Arrays.asList(
					new Location(this.getX()-1,this.getY()),
					new Location(this.getX(),this.getY()+1),
					new Location(this.getX()+1,this.getY())
					));
		}
		// bottom edge
		else if (this.getX() == size-1 && this.getY() == size-1)
		{
			adj.addAll(Arrays.asList(
					new Location(this.getX()-1,this.getY()),
					new Location(this.getX(),this.getY()-1), new Location(this.getX(),this.getY()+1)
					));
		}
		// right edge
		else if (this.getX() == 0 && this.getY() == size-1)
		{
			adj.addAll(Arrays.asList(
					new Location(this.getX()-1,this.getY()),
					new Location(this.getX(),this.getY()-1),
					new Location(this.getX()+1,this.getY())
					));
		}
		else
			throw new IllegalStateException("Location.getAdjacentRawLocations(): logic error");		

		return adj;
	}
}
