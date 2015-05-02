package hackstreet.sixeswild.config;

/**
 * 
 * @author Nicholas
 *
 */
public class EliminationLevelConfig extends AbstractLevelConfig {

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
