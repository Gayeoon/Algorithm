package S_8275;

import java.util.Scanner;

class Case {
	int start, end, cnt;

	Case(int start, int end, int cnt) {
		this.start = start;
		this.end = end;
		this.cnt = cnt;
	}
}

public class Solution {
	static int[] arr;
	static int[] result;
	static int N, X, M;
	static Case[] hint;
	static int max = 0;
	static boolean flag = false;
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			X = sc.nextInt();
			M = sc.nextInt();
			max = 0;
			flag = false;
			
			hint = new Case[M];
			for (int i = 0; i < M; i++) {
				hint[i] = new Case(sc.nextInt(), sc.nextInt(), sc.nextInt());
			}
			arr = new int[N];
			result = new int[N];

			solve(0, 0);

			if (!flag)
				sb.append("#" + test_case + " -1\n");
			else {
				sb.append("#" + test_case);
				for (int i = 0; i < N; i++) {
					sb.append(" " + result[i]);
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}

	static void solve(int depth, int cnt) {
		if (depth >= N) {
			if (isOk()) {
				flag = true;
				if (max < cnt) {
					max = cnt;
					for (int i = 0; i < N; i++) {
						result[i] = arr[i];
					}
				} else if (max == cnt) {
					if (order()) {
						for (int i = 0; i < N; i++) {
							result[i] = arr[i];
						}
					}
				}
			}
			return;
		}
		for (int i = 0; i <= X; i++) {
			arr[depth] = i;
			solve(depth + 1, cnt + i);
		}
	}

	static boolean order() {
		for (int i = 0; i < N; i++) {
			if(result[i] < arr[i])
				return false;
			if (result[i] > arr[i])
				return true;
		}
		return false;
	}

	static boolean isOk() {
		for (int i = 0; i < M; i++) {
			int cnt = 0;
			for (int s = hint[i].start-1; s < hint[i].end; s++) {
				cnt += arr[s];
			}
			if (cnt != hint[i].cnt)
				return false;
		}
		return true;
	}
}