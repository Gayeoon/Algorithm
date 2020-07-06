package Cooker_4012;

import java.util.Scanner;
import java.io.FileInputStream;

public class Main {

	static int dp[][];
	static int min;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */
		int answer[] = new int[T];
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			min = Integer.MAX_VALUE;
			dp = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					dp[i][j] = sc.nextInt();
				}
			}
			boolean[] arr = new boolean[n];
			combi(n, n/2, arr, 0);
			answer[test_case - 1] = min;
		}
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.println("#" + test_case + " " + answer[test_case - 1]);
		}
	}

	static void combi(int n, int r, boolean arr[], int index) {

		if (r == 0) {
			int a[] = new int[n / 2];
			int b[] = new int[n / 2];
			int aidx = 0, bidx = 0;
			for (int i = 0; i < n; i++) {
				if (arr[i])
					a[aidx++] = i;
				else
					b[bidx++] = i;
			}
			min = Math.min(min, solve(a, b, n / 2));
		} else if (index >= n)
			return;
		else {
			arr[index] = true;
			combi(n, r - 1, arr, index + 1);
			arr[index] = false;
			combi(n, r, arr, index + 1);
		}
	}

	static int solve(int[] a, int[] b, int n) {
		int Asum = 0, Bsum = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				Asum += dp[a[i]][a[j]];
				Bsum += dp[b[i]][b[j]];
			}
		}
		return Math.abs(Asum - Bsum);
	}
}