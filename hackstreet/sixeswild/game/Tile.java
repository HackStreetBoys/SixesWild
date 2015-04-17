package hackstreet.sixeswild.game;

public class Tile {

	private int value;
	private int multiplier;
	
	public Tile(int value, int multiplier){
		this.value = value;
		this.multiplier = multiplier;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public int getMultiplier(){
		return this.multiplier;
	}
}
