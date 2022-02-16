package B_16987;

import java.util.Scanner;

public class Main {
	static int N, max = 0;
	static int[][] egg = new int[8][2];
	static boolean[] state = new boolean[8];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();

		for (int i = 0; i < N; i++) {
			egg[i][0] = input.nextInt();
			egg[i][1] = input.nextInt();
		}

		solve(0,0);
		System.out.println(max);
	}

	public static void solve(int idx, int cnt) {
		if (cnt >= N - 1 || idx >= N) {
			max = Math.max(max, cnt);
			return;
		}

		if (state[idx]) {
			solve(idx + 1, cnt);
		} else {
			for (int i = 0; i < N; i++) {
				if (state[i] || idx == i)
					continue;
				egg[idx][0] -= egg[i][1];
				egg[i][0] -= egg[idx][1];

				int temp = 0;
				if (egg[idx][0] <= 0) {
					state[idx] = true;
					temp++;
				}
				if (egg[i][0] <= 0) {
					state[i] = true;
					temp++;
				}

				solve(idx + 1, cnt + temp);

				egg[idx][0] += egg[i][1];
				egg[i][0] += egg[idx][1];

				state[idx] = false;

				state[i] = false;

			}
		}
	}
}
