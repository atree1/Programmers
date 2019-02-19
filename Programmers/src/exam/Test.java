package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*문제 설명
수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한 조건
시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
입출력 예
answers	return
[1,2,3,4,5]	[1]
[1,3,2,4,2]	[1,2,3]
*/

class Abandoner {
	private int[] answer;
	private int collect;
	private int number;
	public Abandoner(int number) {
		this.number = number;
	}
	public void setAnswer(int[] answer) {
		this.answer = answer;
	}
	public int[] getAnswer() {
		return answer;
	}
	public int getCollect() {
		return collect;
	}
	public void increaseCollect() {
		this.collect++;
	}
	public int getNumber() {
		return number;
	}

}

public class Test {

	public static int[] solution(int[] answers) {
		Abandoner[] abandoners = new Abandoner[3];
		for (int i = 0; i < 3; i++) {
			abandoners[i] = new Abandoner(i + 1);
		}
		abandoners[0].setAnswer(new int[] { 1, 2, 3, 4, 5 });
		abandoners[1].setAnswer(new int[] { 2, 1, 2, 3, 2, 4, 2, 5 });
		abandoners[2].setAnswer(new int[] { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 });
		

		for (int i = 0; i < 3; i++) {
			int answer[] = abandoners[i].getAnswer();
			for (int j = 0; j < answers.length; j++) {
				if (answers[j] == answer[j % answer.length]) {
					abandoners[i].increaseCollect();
				}
			}
		}
		Arrays.sort(abandoners, (a1, a2) -> {
			return a2.getCollect() - a1.getCollect();
		});
		List<Integer> array = new ArrayList<>();
		array.add(abandoners[0].getNumber());
		for (int i = 1; i < 3; i++) {
			if (abandoners[0].getCollect() == abandoners[i].getCollect()) {
				array.add(abandoners[i].getNumber());
			}
		}

		int[] answer = new int[array.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = array.get(i);
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(Test.solution(new int[] { 1, 2, 3, 4, 5 })));
	}
}
