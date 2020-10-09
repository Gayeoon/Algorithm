package S_7194;

import java.util.Scanner;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int s = sc.nextInt();
			int t = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (b == 1) {
				int tmp = t - s;
				if (tmp % a == 0) {
					System.out.println("#" + test_case + " " + (t - s) / a);
				} else {
					System.out.println("#" + test_case + " -1");
				}
				continue;
			}
			int goHome = 0;
			while (s != t) {
				if (t % b == 0) {
					if (t / b < s) {
						goHome++;
						t -= a;
					} else {
						goHome++;
						t /= b;
					}
				} else {
					goHome++;
					t -= a;
				}
				if (s > t) {
					goHome = -1;
					break;
				}
			}
			System.out.println("#" + test_case + " " + goHome);
		}
	}
}