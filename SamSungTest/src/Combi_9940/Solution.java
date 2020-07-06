package Combi_9940;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String args[]) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(bf.readLine());

		String answer[] = new String[T];
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(bf.readLine());
			String[] line = bf.readLine().split(" ");
			if (line.length == n) {
				answer[test_case - 1] = "Yes";
				boolean check[] = new boolean[n+1];
				for (int i = 0; i < n; i++) {
					int tmp = Integer.parseInt(line[i]);
					if (tmp > n || check[tmp]) {
						answer[test_case - 1] = "No";
						break;
					} else {
						check[tmp] = true;
					}
				}
			} else {
				answer[test_case - 1] = "No";
			}

		}
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.println("#" + test_case + " " + answer[test_case - 1]);
		}

	}
}