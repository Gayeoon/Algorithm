package SW_15684;

import java.util.Scanner;

public class Main {
	static int map[][];
	static int N, H, M, result = Integer.MAX_VALUE;
	static final int LEFT = 1;
	static final int RIGHT = 2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();
		H = input.nextInt();

		map = new int[H][N];
		
		for (int i = 0; i < M; i++) {
			int l = input.nextInt() - 1;
			int r = input.nextInt();
			map[l][r - 1] = LEFT;
			map[l][r] = RIGHT;
		}
		solve(0, 0);
		if(result == Integer.MAX_VALUE)
			result = -1;
		System.out.println(result);
	}

	static void solve(int pos, int cnt) {
		
		if (cnt >= 3 || pos >= N * H) {
			if (game()) {
				result = Math.min(result, cnt);
			}
			return;
		}
		int row = pos / N;
		int col = pos % N;

		if (col < N - 1 && map[row][col] == 0 && map[row][col + 1] == 0) {
			map[row][col] = LEFT;
			map[row][col + 1] = RIGHT;
			solve(pos + 2, cnt + 1);
			map[row][col] = map[row][col + 1] = 0;
		}

		solve(pos + 1, cnt);

	}

	static boolean game() {
		for (int i = 0; i < N; i++) {
			int row = 0;
			int col = i;
			do {
				if (map[row][col] == LEFT)
					col++;
				else if (map[row][col] == RIGHT)
					col--;
				row++;
			} while (row != H);

			if (col != i)
				return false;
		}
		return true;
	}
}
