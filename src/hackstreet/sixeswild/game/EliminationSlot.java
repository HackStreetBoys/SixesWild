package hackstreet.sixeswild.game;

public class EliminationSlot extends Slot{

	/** Has the slot been used yet*/
	private boolean eliminated;
	
	public EliminationSlot(Location loc) {
		super(loc);
		this.eliminated = false;
	}
	
	public void setEliminated(){
		this.eliminated = true;
	}
	
	public boolean isEliminated(){
		return this.eliminated;
	}

}
