package B_15655;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int arr[];
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();

		arr = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = input.nextInt();

		Arrays.sort(arr);

		solve(0, 0, n, m, "");
		System.out.print(sb);
	}

	static void solve(int depth, int idx, int n, int m, String str) {
		if (depth >= m) {
			sb.append(str + "\n");
			return;
		}
		for (int i = idx; i < n; i++) {
			solve(depth + 1, i+1, n, m, str + arr[i] + " ");
		}
	}

}