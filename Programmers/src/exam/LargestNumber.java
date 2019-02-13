package exam;

import java.util.ArrayList;
import java.util.List;

public class LargestNumber {
	public String solution(int[] numbers) {


		List<String> nums = new ArrayList<>();
		for (int num : numbers) {
			nums.add(num+"");
		}

		nums.sort((n1, n2) -> {
			if(n1.charAt(0)==n2.charAt(0)) {
				int nn1=Integer.parseInt(n1+n2);
				System.out.println(nn1);
				int nn2=Integer.parseInt(n2+n1);
				System.out.println(nn2);
				return nn2-nn1;
			}
			
			return n2.charAt(0) - n1.charAt(0) ;
		}
		);
		  StringBuilder sb = new StringBuilder();
		for (String num : nums) {
			sb.append(num);
		}

		return  sb.charAt(0) == '0' ? "0" : sb.toString();
	}

	public static void main(String[] args) {
		LargestNumber l = new LargestNumber();
		System.out.println(l.solution(new int[] { 3, 30, 34, 5, 9 ,111,130}));
	}
}