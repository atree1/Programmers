package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*���� ����
�����ڴ� ������ ������ ����� �ظ��Դϴ�. ������ ���ι��� ���ǰ��翡 ���� ������ ���� ������ �մϴ�. �����ڴ� 1�� �������� ������ �������� ������ ���� ����ϴ�.

1�� �����ڰ� ��� ���: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2�� �����ڰ� ��� ���: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3�� �����ڰ� ��� ���: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1�� �������� ������ ���������� ������ ������� ���� �迭 answers�� �־����� ��, ���� ���� ������ ���� ����� �������� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���� ����
������ �ִ� 10,000 ������ �����Ǿ��ֽ��ϴ�.
������ ������ 1, 2, 3, 4, 5�� �ϳ��Դϴ�.
���� ���� ������ ���� ����� ������ ���, return�ϴ� ���� �������� �������ּ���.
����� ��
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