import java.util.Scanner;
public class Coordinate {
	
	
	private double x, y;
	public Coordinate(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public Coordinate() {
		super();
		this.x = 0;
		this.y = 0;
	}

	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	

	@Override
	public String toString() {
		return "Coordinate (" + x + ", " + y + ")";
	}
	
	public int compareTo(Coordinate otherCoordinate){
		if ((x < otherCoordinate.x) || ((x == otherCoordinate.x) && (y < otherCoordinate.y))){
			return -1;
		}
		else if ((x == otherCoordinate.x) && (y == otherCoordinate.y)){
			return 0;
		}
		return 1;
	}
	
	public static double  distanceBetween(Coordinate c1, Coordinate c2){
		double d = Math.sqrt(Math.pow(c1.getX() - c2.getX(), 2) + Math.pow(c1.getY() - c2.getY(), 2));
		return d;
	}
	

}
