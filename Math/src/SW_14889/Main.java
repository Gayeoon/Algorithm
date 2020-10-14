package SW_14889;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static int[][] skills;
	static int n, result = Integer.MAX_VALUE;
	static LinkedList<Integer> start, link;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		start = new LinkedList<>();
		link = new LinkedList<>();

		skills = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				skills[i][j] = input.nextInt();
			}
		}
		solve(0, 0, 0);
		System.out.println(result);
	}

	static void solve(int idx, int sNum, int lNum) {
		if (idx >= n) {
			int startSum = 0, linkSum = 0;
			for (int i : start) {
				for (int j : start) {
					startSum += skills[i][j];
				}
			}

			for (int i : link) {
				for (int j : link) {
					linkSum += skills[i][j];
				}
			}

			result = Math.min(result, Math.abs(startSum - linkSum));
			return;

		}

		if (sNum < n / 2) {
			start.add(idx);
			solve(idx + 1, sNum + 1, lNum);
			start.removeLast();
		}

		if (lNum < n / 2) {
			link.add(idx);
			solve(idx + 1, sNum, lNum + 1);
			link.removeLast();
		}
	}
}
