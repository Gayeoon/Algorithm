package S_2070;

import java.util.Scanner;

public class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		StringBuffer sb = new StringBuffer();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			if (n < m)
				sb.append("#" + test_case + " <\n");
			else if (n == m)
				sb.append("#" + test_case + " =\n");
			else
				sb.append("#" + test_case + " >\n");
		}
		System.out.print(sb);
	}
}