package exam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*���� ����
��ȭ��ȣ�ο� ���� ��ȭ��ȣ ��, �� ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��찡 �ִ��� Ȯ���Ϸ� �մϴ�.
��ȭ��ȣ�� ������ ���� ���, ������ ��ȭ��ȣ�� �������� ��ȭ��ȣ�� ���λ��Դϴ�.

������ : 119
���ؿ� : 97 674 223
������ : 11 9552 4421
��ȭ��ȣ�ο� ���� ��ȭ��ȣ�� ���� �迭 phone_book �� solution �Լ��� �Ű������� �־��� ��, 
� ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��찡 ������ false�� �׷��� ������ true�� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���� ����
phone_book�� ���̴� 1 �̻� 1,000,000 �����Դϴ�.
�� ��ȭ��ȣ�� ���̴� 1 �̻� 20 �����Դϴ�.
����� ����
phone_book	return
[119, 97674223, 1195524421]	false
[123,456,789]	true
[12,123,1235,567,88]	false
*/
public class PhoneList {
	public boolean solution(String[] phone_book) {

		Map<Integer, String> hm = new HashMap<>();
		Arrays.sort(phone_book);

		for (int i = 0; i < phone_book.length - 1; i++) {
			hm.put(i, phone_book[i]);

			for (int j = i + 1; j < phone_book.length; j++) {
				if (phone_book[j].startsWith(hm.get(i))) {
					return false;
				}
			}
		}

		return true;
	}
}