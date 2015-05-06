package hackstreet.sixeswild.game;

public class BucketSlot extends Slot{

	/** The state of the slot*/
	private boolean occupied;
	
	public BucketSlot(Location loc) {
		super(loc);
		this.occupied = false;
	}
	
	public boolean isOccupied(){
		return this.occupied;
	}
	
	public void setOccupied(){
		this.occupied = true;
	}

}
