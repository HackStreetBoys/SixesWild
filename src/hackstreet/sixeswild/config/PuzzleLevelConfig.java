package hackstreet.sixeswild.config;

/**
 * 
 * @author Nicholas
 *
 */
public class PuzzleLevelConfig extends AbstractLevelConfig {
	
	private int numMoves;
	
	public PuzzleLevelConfig(int numMoves){
		this.numMoves = numMoves;
	}
	
	public int getNumMoves() {
		return numMoves;
	}
}
