import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ProbabilityMap {

	private int value;
	
	//Are these ships alive?
	
	private boolean d = true;
	private boolean c = true;
	private boolean s = true;
	private boolean b = true;
	private boolean a = true;
	
	private HashMap<Coordinate, Integer> prob = new HashMap<Coordinate, Integer>();
	
	HashMap<Coordinate, Integer> copy = new HashMap<Coordinate, Integer>();

	private Coordinate[][] storage = new Coordinate[8][8];
	
	public void heatMap() {
		
		value = 0; 
		
		for (int i = 0; i < 8; i ++) {
			
			for (int j = 0; j < 8; j ++) {
				
				Coordinate map = new Coordinate(i,j);
				//storage[i][j] = map;
				int probability = 0; 
				
				if (map.check(map) == false ) {
					
					if (d == true) {
						if (map.check(new Coordinate((i-1),j)) == false) {
							probability ++; 
						}
						if (map.check(new Coordinate((i+1),j)) == false) {
							probability ++; 
						}
						if (map.check(new Coordinate((i),j-1)) == false) {
							probability ++; 
						}
						if (map.check(new Coordinate((i),j+1)) == false) {
							probability ++; 
						}
					}
					
					if (c == true) {
						if (map.check(new Coordinate((i-1),j)) == false && map.check(new Coordinate(i-2,j)) == false) {
							probability ++; 
						}
						if (map.check(new Coordinate((i+1),j)) == false && map.check(new Coordinate(i+2,j)) == false) {
							probability ++; 
						}
						if (map.check(new Coordinate((i),(j-1))) == false && map.check(new Coordinate(i,j-2)) == false) {
							probability ++; 
						}
						if (map.check(new Coordinate((i),j+1)) == false && map.check(new Coordinate(i,j+2)) == false) {
							probability ++; 
						}
					}
					
					if (s == true) {
						if (map.check(new Coordinate((i-1),j)) == false && map.check(new Coordinate(i-2,j)) == false) {
							probability ++; 
						}
						if (map.check(new Coordinate((i+1),j)) == false && map.check(new Coordinate(i+2,j)) == false) {
							probability ++; 
						}
						if (map.check(new Coordinate((i),j-1)) == false && map.check(new Coordinate(i,j-2)) == false) {
							probability ++; 
						}
						if (map.check(new Coordinate((i),j+1)) == false && map.check(new Coordinate(i,j+2)) == false) {
							probability ++; 
						}
					}
					
				  
					if (b == true) {
						if (map.check(new Coordinate((i-1),j)) == false && map.check(new Coordinate(i-2,j)) == false
								&& map.check(new Coordinate(i-3,j)) == false) {
							
							probability ++; 
						}
						if (map.check(new Coordinate((i+1),j)) == false && map.check(new Coordinate(i+2,j)) == false
								&& map.check(new Coordinate(i+3,j)) == false) {
							probability ++; 
						}
						if (map.check(new Coordinate((i),j-1)) == false && map.check(new Coordinate(i,j-2)) == false
								&& map.check(new Coordinate(i,j-3)) == false) {
							probability ++; 
						}
						if (map.check(new Coordinate((i),j+1)) == false && map.check(new Coordinate(i,j+2)) == false
								&& map.check(new Coordinate(i,j+3)) == false) {
							probability ++; 
						}
					}
					
					if (a == true) {
						if (map.check(new Coordinate((i-1),j)) == false 
								&& map.check(new Coordinate(i-2,j)) == false
								&& map.check(new Coordinate(i-3,j)) == false
								&& map.check(new Coordinate(i-4,j)) == false) {
							
							probability ++; 
						}
						if (map.check(new Coordinate((i+1),j)) == false 
								&& map.check(new Coordinate(i+2,j)) == false
								&& map.check(new Coordinate(i+3,j)) == false
								&& map.check(new Coordinate(i+4,j)) == false) {
							probability ++; 
						}
						if (map.check(new Coordinate((i),j-1)) == false 
								&& map.check(new Coordinate(i,j-2)) == false
								&& map.check(new Coordinate(i,j-3)) == false
								&& map.check(new Coordinate(i,j-4)) == false) {
							probability ++; 
						}
						if (map.check(new Coordinate((i),j+1)) == false 
								&& map.check(new Coordinate(i,j+2)) == false
								&& map.check(new Coordinate(i,j+3)) == false
								&& map.check(new Coordinate(i,j+4)) == false) {
							probability ++; 
						}
						
						
						
					}
					
				}
				
				value = (probability > value) ? probability : value; 
				//System.out.println(probability);
				prob.put(map, probability);
				//System.out.println(prob.get(map));
				
				
			
				
			}

			
		}
		
		
		
		
		
	}
	
	
	public void test() {
		copy.putAll(prob);
		System.out.println(copy);
	}
	
	List<String> shotsFired = new ArrayList<String>();
	public void shotList(Coordinate shot) {
		shotsFired.add(Integer.toString(shot.getX())+Integer.toString(shot.getY()));
	}
	
	
	
	public Coordinate getBest() {
		
		List<Coordinate> best = new ArrayList <Coordinate>();
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				
				Coordinate theta = new Coordinate(i,j);
				int probability = prob.get(theta);
				if (probability >= value) {
					best.add(theta);
				}
			}
		}
		
		if (best.size() == 1){
			return best.get(0);
		}
		
		else {
			Random r = new Random();
			int next = r.nextInt(best.size());
			return best.get(next);
		}
	}
	
	public String convertBest() {
		Coordinate gamma = getBest();
		return ((char)(gamma.getX()+65)+Integer.toString(gamma.getY()+1));
	}
	
	public void printMap() {
		
		
		for (int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				//System.out.println(prob.get(storage[i][j]) + "\t");
				Coordinate beta = new Coordinate(i,j);
				System.out.print(prob.get(beta) + "\t");
			}
			System.out.println();
		}
		System.out.println("----------------------------");
	}
	
	
}
