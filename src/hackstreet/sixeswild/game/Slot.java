package hackstreet.sixeswild.game;

/**
 * A Permanent game entity with a fixed Location and variable Tile.
 * 
 * @author Nicholas
 *
 */
public class Slot {

	/** The Location of the tile, [0][0] to [8][8]. */
	private Location loc;
	
	/** The Tile at this location. */
	private Tile tile;
	
	public Slot(Location loc){
		this.loc = loc;
	}
	
	public Location getLoc() {
		return loc;
	}

	public Tile getTile() {
		return tile;
	}

	public void setTile(Tile tile) {
		this.tile = tile;
	}

}
