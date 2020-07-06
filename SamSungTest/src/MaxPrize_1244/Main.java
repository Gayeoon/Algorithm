package MaxPrize_1244;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */
		String answer[] = new String[T];
		for (int test_case = 1; test_case <= T; test_case++) {
			String str = sc.next();
			int cnt = sc.nextInt();
			int num[] = new int[str.length()];
			ArrayList<Integer> compare = new ArrayList<>();
			HashMap<Integer, Integer> hash = new HashMap<>();
			for (int s = 0; s < str.length(); s++) {
				num[s] = Integer.parseInt(str.charAt(s) + "");
				compare.add(num[s]);
				if (hash.containsKey(num[s])) {
					hash.put(num[s], 2);
				} else
					hash.put(num[s], 1);
			}
			Collections.sort(compare, Collections.reverseOrder());
			while (cnt > 0) {
				boolean flag = false;
				for (int i = 0; i < num.length; i++) {
					if (num[i] < compare.get(i)) {
						int t = num[i];
						int index = compare.indexOf(num[i]);
						if (num[index] == compare.get(i)) {
							num[i] = num[index];
							num[index] = t;
							cnt--;
							flag = true;
							break;
						} else {
							for (int j = num.length - 1; j > i; j--) {
								if (num[j] == compare.get(i)) {
									num[i] = compare.get(i);
									num[j] = t;
									cnt--;
									flag = true;
									break;
								}
							}
						}
					}
					if(flag) break;
				}
				if (flag)
					continue;
				if (cnt % 2 == 0)
					break;
				Iterator<Integer> it = hash.keySet().iterator();

				while (it.hasNext()) {
					int key = it.next();
					if (hash.get(key) == 2) {
						cnt = 0;
						break;
					}
				}

				if (cnt != 0) {
					int t = num[num.length - 2];
					num[num.length - 2] = num[num.length - 1];
					num[num.length - 1] = t;
					break;
				}

			}
			String st = "";
			for (int i = 0; i < num.length; i++) {
				st += num[i];
			}
			answer[test_case - 1] = st;
		}
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.println("#" + test_case + " " + answer[test_case - 1]);
		}

	}
}
