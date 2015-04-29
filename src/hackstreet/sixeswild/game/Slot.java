package hackstreet.sixeswild.game;

/**
 * A Permanent game entity with a fixed Location and variable Tile.
 * 
 * @author Tim, Nicholas
 *
 */
public class Slot {
	
	//-----Very Very Bad TODO
	public boolean selected = false;
	//-----GET RID BAD CODE NO NO NO

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

	/**
	 * Returns true if this slot has a tile that can be moved using gravity.
	 * @return
	 */
	public boolean hasTile() {
		return this.tile != null;
	}
	
	@Override
	public String toString(){
		return "Slot"+loc.toString();
	}

}
