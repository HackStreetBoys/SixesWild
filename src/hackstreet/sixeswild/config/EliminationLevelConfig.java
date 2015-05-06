package hackstreet.sixeswild.config;

/**
 * 
 * @author Nicholas, Pat
 *
 */
public class EliminationLevelConfig extends AbstractLevelConfig {

	/** Number of moves available*/
	private int numMoves;
	
	public EliminationLevelConfig(int numMoves){
		super("Elimination");
		this.numMoves = numMoves;
		this.Type = "Elimination";
	}
	
	public int getNumMoves() {
		return numMoves;
	}

}
