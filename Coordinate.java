import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;


public class Coordinate{

	private int x;
	private int y; 
	
	public Coordinate(Integer x, Integer y) {
		this.x = x;
		this.y = y; 
	}
	
	public int getX() {
		return x; 
	}
	
	public int getY() {
		return y;
		
	}
	
	List<String> shotsFired = new ArrayList<String>();
	public void shotList(Coordinate shot) {
		shotsFired.add(Integer.toString(shot.getX())+Integer.toString(shot.getY()));
	}
	
	public boolean check(Coordinate coords) {
		if (coords.getX() < 0 || coords.getY() < 0 || coords.getX() >= 8 || coords.getY() >= 8) {
			return true;
		}
		if(shotsFired.contains(Integer.toString(coords.getX())+Integer.toString(coords.getY()))==true)
			return true;
		else
			return false;
	}
	
	public int hashCode() {
		return Objects.hash(x, y);
	}
	
	 public boolean equals(Object obj) {
	        if (obj == this)
	            return true;
	        else if (!(obj instanceof Coordinate))
	            return false;

	        Coordinate that = (Coordinate) obj;
	        return this.x == that.x && this.y == that.y;
	    }
	
		
}
