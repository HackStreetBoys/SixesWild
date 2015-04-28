package hackstreet.sixeswild.game;

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
}