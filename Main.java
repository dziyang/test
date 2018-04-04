
public class Main {
	
	public int x;
	public int y;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		ProbabilityMap alpha = new ProbabilityMap();
		
		alpha.heatMap();
		alpha.printMap();
		alpha.getBest();
		alpha.convertBest();
		System.out.println(alpha.convertBest());
		alpha.shotList(alpha.getBest());
		System.out.println(alpha.shotsFired);
		alpha.heatMap();
		alpha.printMap();
		//System.out.println(alpha.getBest());
		//alpha.test();
		

	}

	/**
	public static void main(String[] args) {
		int a = 65;
		System.out.println((char)(a+1));
		char b = 'b';
		System.out.println(b+"hi");
	}
	*/
}
