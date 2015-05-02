package hackstreet.sixeswild.config;

/**
 * 
 * @author Pat
 * 
 */
public class ReleaseLevelConfig extends AbstractLevelConfig {
	
	private int numMoves;
	
	public ReleaseLevelConfig(int numMoves){
		super("Release");
		this.Type = "Release";
		this.numMoves = numMoves;
	}
	
	public int getNumMoves() {
		return numMoves;
	}
}
