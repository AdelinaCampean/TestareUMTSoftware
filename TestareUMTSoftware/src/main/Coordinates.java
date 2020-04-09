package main;

public class Coordinates {
	
	private int x;
	private int y;
	
	public Coordinates(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}


	public int distanceBetweenP(Coordinates p1, Coordinates p2)
	{
		return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y); 
	}
	
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	

	@Override
	public String toString() {
		return "("+x+","+y+")";
	}
	
}
