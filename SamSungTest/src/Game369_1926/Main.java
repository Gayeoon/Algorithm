package Game369_1926;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.HashMap;

public class Main {

	static HashMap<String, String> hash;

	public static void main(String args[]) throws Exception {
		/*
		 * �Ʒ��� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸκ��� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�. �������� �ۼ��� �ڵ带
		 * �׽�Ʈ �� ��, ���Ǹ� ���ؼ� input.txt�� �Է��� ������ ��, �� �ڵ带 ���α׷��� ó�� �κп� �߰��ϸ� ���� �Է��� ������ ��
		 * ǥ�� �Է� ��� ���Ϸκ��� �Է��� �޾ƿ� �� �ֽ��ϴ�. ���� �׽�Ʈ�� ������ ������ �Ʒ� �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �����ϴ�.
		 * ��, ä���� ���� �ڵ带 �����Ͻ� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ� ó�� �ϼž� �մϴ�.
		 */
		// System.setIn(new FileInputStream("res/input.txt"));

		/*
		 * ǥ���Է� System.in ���κ��� ��ĳ�ʸ� ����� �����͸� �о�ɴϴ�.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
		 */
		hash = new HashMap<>();
		hash.put("3", "-");
		hash.put("6", "-");
		hash.put("9", "-");

		for (int i = 1; i <= T; i++) {
			String str = solve(i + "");
			if (str.equals(""))
				System.out.print(i + " ");
			else
				System.out.print(str + " ");
		}
	}

	static String solve(String str) {
		int len = str.length();
		if (hash.containsKey(str))
			return hash.get(str);

		if (len > 1) {
			String temp = solve(str.substring(1, len));
			String result = "";
			if (temp.contains("-")) {
				if (hash.get(str.charAt(0) + "").equals("-"))
					result = "-" + temp;
				else
					result = temp;
			} else {
				if (hash.get(str.charAt(0) + "").equals("-"))
					result = "-";
				else
					result = str;
			}
			hash.put(str, result);
			return result;
		} else {
			hash.put(str, str);
			return str;
		}
	}
}