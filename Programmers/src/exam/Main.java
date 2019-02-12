package exam;


public class Main {

	public static void main(String[] args) {
	
		BestAlbum b=new BestAlbum(); 
		String[] parti= {"classic", "pop", "classic", "classic", "pop"};
		int[] completion= {500,600,150,800,2500};
		
		System.out.println(b.solution(parti, completion));
		
		

	}
	
}
