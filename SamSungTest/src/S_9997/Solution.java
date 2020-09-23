package S_9997;

import java.util.Scanner;

public class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			sb.append("#" + test_case + " " + (n / 30) + " ");
			n %= 30;
			n /= 0.5;
			sb.append(n + "\n");
		}

		System.out.print(sb);
	}
}