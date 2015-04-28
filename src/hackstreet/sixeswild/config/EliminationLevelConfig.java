package hackstreet.sixeswild.config;

/**
 * 
 * @author Nicholas
 *
 */
public class EliminationLevelConfig extends AbstractLevelConfig {

	private int numMoves;
	
	public EliminationLevelConfig(int numMoves){
		this.numMoves = numMoves;
	}
	
	public int getNumMoves() {
		return numMoves;
	}

}
