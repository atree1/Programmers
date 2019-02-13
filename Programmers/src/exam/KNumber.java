package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KNumber {
	 public int[] solution(int[] array, int[][] commands) {
		 
		 int size=commands.length;
		 int[] answer = new int[size];
		
/*		 내가 푼 버전 	
		 	for(int i=0;i<size;i++) {
	        
		 		List<Integer> slice=new ArrayList<>();
		 	     for(int j=commands[i][0]-1;j<commands[i][1];j++) {
		 	    	 slice.add(array[j]);
		 	     }
		 	     slice.sort((n1,n2)->n1-n2);
		 	    
		 	     answer[i]=slice.get(commands[i][2]-1);
		 	     
		 
		 	}
	        
*/	
	
		 //copyOfRange 이용 버전
		 for(int i=0;i<size;i++) {
			 int[] temp=Arrays.copyOfRange(commands[i], commands[i][0]-1, commands[i][1]);
			 Arrays.sort(temp);
			 answer[i]=temp[commands[i][2]-1];
			 
		 }
		 return answer;
	    }
	 
	
	 
}
