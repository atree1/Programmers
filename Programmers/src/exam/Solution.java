package exam;

/*문제 설명
수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

제한사항
마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
completion의 길이는 participant의 길이보다 1 작습니다.
참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
참가자 중에는 동명이인이 있을 수 있습니다.
입출력 예
participant									completion							return
[leo, kiki, eden]		                   [eden, kiki]							leo
[marina, josipa, nikola, vinko, filipa]	   [josipa, filipa, marina, nikola]		vinko
[mislav, stanko, mislav, ana]	           [stanko, ana, mislav]				mislav

*/
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	public String solution(String[] participant, String[] completion) {

		
		//hashMap 이용
		Map<String, Integer> hm = new HashMap<>();
		String answer = "";
		for (String str : participant) {
			hm.put(str, hm.getOrDefault(str, 0) + 1);
		}
		for (String str : completion) {
			hm.put(str, hm.get(str) - 1);
		}

		for (String key : hm.keySet()) {
			if (hm.get(key) != 0) {
				answer = key;
			}
		}
	
		/* 정렬이용
		Arrays.sort(participant);
		Arrays.sort(completion);
		answer = participant[participant.length - 1];

		for (int i = 0; i < completion.length; i++) {
			if (!participant[i].equals(completion[i])) {

				answer = participant[i];
				break;
			}
		}
		 */
		return answer;
	}

	public static void main(String[] args) {

		Solution s = new Solution();
		String[] parti = { "leo", "kiki", "eden" };
		String[] completion = { "kiki", "eden" };

		System.out.println(s.solution(parti, completion));

	}
}