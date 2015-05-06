package hackstreet.sixeswild.config;

/**
 * 
 * @author Nicholas, Pat
 *
 */
public class PuzzleLevelConfig extends AbstractLevelConfig {
	
	/** Number of moves in the game*/
	private int numMoves;
	
	public PuzzleLevelConfig(int numMoves){
		super("Puzzle");
		this.Type = "Puzzle";
		this.numMoves = numMoves;
	}
	
	public int getNumMoves() {
		return numMoves;
	}
}
