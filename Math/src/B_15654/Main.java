package B_15654;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int arr[];
	static boolean visit[];
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();

		arr = new int[n];
		visit = new boolean[n];

		for (int i = 0; i < n; i++)
			arr[i] = input.nextInt();

		Arrays.sort(arr);

		solve(0, n, m, "");
		System.out.print(sb);
	}

	static void solve(int depth, int n, int m, String str) {
		if (depth >= m) {
			sb.append(str + "\n");
			return;
		}
		for (int i = 0; i < n; i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			solve(depth + 1, n, m, str + arr[i] + " ");
			visit[i] = false;
		}
	}

}
