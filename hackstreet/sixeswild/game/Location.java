package hackstreet.sixeswild.game;

public class Location {

	private int x;
	private int y;
	
	public Location(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Location){
			Location other = (Location)o;
			return other.x==this.x && other.y==this.y;
		}
		return false;
	}
}
