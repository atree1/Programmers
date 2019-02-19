package exam;

import java.util.Arrays;

/*
  ���� ����
H-Index�� �������� ���꼺�� ������� ��Ÿ���� ��ǥ�Դϴ�. ��� �������� H-Index�� ��Ÿ���� ���� h�� ���Ϸ��� �մϴ�. ��Ű���1�� ������, H-Index�� ������ ���� ���մϴ�.

� �����ڰ� ��ǥ�� ���� n�� ��, h�� �̻� �ο�� ������ h�� �̻��̰� ������ ������ h�� ���� �ο�Ǿ��ٸ� h�� �� �������� H-Index�Դϴ�.

� �����ڰ� ��ǥ�� ������ �ο� Ƚ���� ���� �迭 citations�� �Ű������� �־��� ��, �� �������� H-Index�� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
�����ڰ� ��ǥ�� ������ ���� 1�� �̻� 1,000�� �����Դϴ�.
������ �ο� Ƚ���� 0ȸ �̻� 10,000ȸ �����Դϴ�.
����� ��
citations	return
[3, 0, 6, 1, 5]	3
*/
public class HIndex {

	public int solution(int[] citations) {
		int answer = 0;
		int h=0;
		Arrays.sort(citations);
		int len=citations.length;
		for(int i = 0; i <= citations[len-1]; i++) {
            for(int j = 0; j < len; j++) {
                if(citations[j] >= i) {
                   answer++;
                }
            }

            if(i == answer) {
                h = i;
            }

            answer = 0;
        }


		return h;

	}

  


	public static void main(String[] args) {
		HIndex h = new HIndex();
		int[] c = { 3, 0, 6, 1, 5 };
		System.out.println(h.solution(c));
	}
}