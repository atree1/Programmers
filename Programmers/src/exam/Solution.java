package exam;

/*���� ����
������ ������ �������� �����濡 �����Ͽ����ϴ�. �� �� ���� ������ �����ϰ��� ��� ������ �������� �����Ͽ����ϴ�.

�����濡 ������ �������� �̸��� ��� �迭 participant�� ������ �������� �̸��� ��� �迭 completion�� �־��� ��, �������� ���� ������ �̸��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
������ ��⿡ ������ ������ ���� 1�� �̻� 100,000�� �����Դϴ�.
completion�� ���̴� participant�� ���̺��� 1 �۽��ϴ�.
�������� �̸��� 1�� �̻� 20�� ������ ���ĺ� �ҹ��ڷ� �̷���� �ֽ��ϴ�.
������ �߿��� ���������� ���� �� �ֽ��ϴ�.
����� ��
participant									completion							return
[leo, kiki, eden]		                   [eden, kiki]							leo
[marina, josipa, nikola, vinko, filipa]	   [josipa, filipa, marina, nikola]		vinko
[mislav, stanko, mislav, ana]	           [stanko, ana, mislav]				mislav

*/
import java.util.Arrays;

public class Solution {
    public String solution(String[] participant, String[] completion) {
    	
    	Arrays.sort(participant);
    	Arrays.sort(completion);
    	String answer =participant[participant.length-1];
    	
    	for (int i=0;i<completion.length;i++) {
			if(!participant[i].equals(completion[i])) {
				
				answer=participant[i];
				break;
			}
		}
        
        return answer;
    }
    
    public static void main(String[] args) {
    	
		Solution s=new Solution();
		String[] parti= {"leo", "kiki", "eden"};
		String[] completion= {"kiki", "eden"};
		
		System.out.println(s.solution(parti, completion));
		
		

	}
}