package hackstreet.sixeswild.config;

/**
 * 
 * @author Nicholas
 *
 */
public class PuzzleLevelConfig extends AbstractLevelConfig {
	
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
