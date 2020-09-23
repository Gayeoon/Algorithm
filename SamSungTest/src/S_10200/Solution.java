package S_10200;

import java.util.Scanner;

public class Solution {

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();

			sb.append("#" + test_case + " ");

			if (a < b)
				sb.append(a + " ");
			else
				sb.append(b + " ");

			if (n >= (a + b))
				sb.append(0 + "\n");
			else
				sb.append((a + b - n) + "\n");
		}

		System.out.print(sb);
	}
}