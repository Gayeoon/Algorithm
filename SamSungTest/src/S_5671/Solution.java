package S_5671;

import java.util.Scanner;

public class Solution {
	static int result = 0;
	static boolean visit[];
	static String arr[];

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			result = 0;
			arr = new String[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.next();
			}

			if (m >= 21)
				sb.append("#" + test_case + " " + n + "\n");
			else {
				visit = new boolean[26];
				visit[0] = visit['e' - 'a'] = visit['i' - 'a'] = visit['o' - 'a'] = visit['u' - 'a'] = true;
				solve(0, 0, m);
				sb.append("#" + test_case + " " + result + "\n");
			}
		}
		System.out.print(sb);
	}

	static void solve(int start, int cnt, int m) {
		if (cnt == m) {
			int tmp = 0;
			for (int i = 0; i < arr.length; i++) {
				boolean flag = true;
				for (int j = 0; j < arr[i].length(); j++) {
					if (!visit[arr[i].charAt(j) - 'a']) {
						flag = false;
						break;
					}
				}
				if (flag)
					tmp++;
			}
			result = Math.max(tmp, result);
			return;
		}

		for (int i = start; i < 26; i++) {
			if (!visit[i]) {
				visit[i] = true;
				solve(i, cnt + 1, m);
				visit[i] = false;
			}
		}
	}

}