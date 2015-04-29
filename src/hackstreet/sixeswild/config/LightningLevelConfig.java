package hackstreet.sixeswild.config;

public class LightningLevelConfig extends AbstractLevelConfig{

	private int seconds;
	
	public LightningLevelConfig(int numMoves){
		super("Lightning");
		this.seconds = numMoves;
	}
	
	public int getSeconds() {
		return seconds;
	}
}
