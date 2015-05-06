package hackstreet.sixeswild.config;

public class LightningLevelConfig extends AbstractLevelConfig{

	/** Number of seconds in the game*/
	private int seconds;
	
	public LightningLevelConfig(int numMoves){
		super("Lightning");
		this.seconds = numMoves;
		this.Type = "Lightning";
	}
	
	public int getSeconds() {
		return seconds;
	}
}
