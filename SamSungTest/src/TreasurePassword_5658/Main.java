package TreasurePassword_5658;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		long[] answer = new long[T];
		for (int test_case = 1; test_case <= T; test_case++) {
			HashMap<String, Long> hash = new HashMap<>();

			int n = sc.nextInt();
			int k = sc.nextInt();
			String str = sc.next();
			int start = 0;
			int div = n / 4;
			int end = div;
			for(int w = 0; w<div; w++) {
				for (int q = 0; q < 4; q++) {
					String temp = "";
					if (end > str.length()) {
						//start = str.length() + start;
						for (int i = start; i < str.length(); i++) {
							temp += str.charAt(i) + "";
						}
						for (int i = 0; i < end - str.length(); i++) {
							temp += str.charAt(i) + "";
						}
						start = end - str.length();
					} else {
						temp = str.substring(start, end);
						start = end;
					}
					end = start + div;

					if (hash.containsKey(temp))
						continue;					
					hash.put(temp, Long.parseLong(temp, 16));
				}
				start--;
				end--;
			}

			List<String> keySetList = new ArrayList<String>(hash.keySet());
			Collections.sort(keySetList, (o1, o2) -> (hash.get(o2).compareTo(hash.get(o1))));
			int cnt = 1;
			for (String key : keySetList) {
				if (cnt == k) {
					answer[test_case - 1] = hash.get(key);
					break;
				}
				cnt++;
			}
		}
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.println("#" + test_case + " " + answer[test_case - 1]);
		}
	}
}