package B_3109;

import java.util.Scanner;

public class Main {
	static char[][] arr;
	static int Dr[] = { -1, 0, 1 };
	static int Dc[] = { 1, 1, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();

		arr = new char[n][m];

		for (int i = 0; i < n; i++)
			arr[i] = input.next().toCharArray();

		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (dfs(i, 0))
				ans++;
		}

		System.out.println(ans);
	}

	static boolean dfs(int row, int col) {
		if (col == arr[0].length - 1)
			return true;

		for (int i = 0; i < 3; i++) {
			int nr = row + Dr[i];
			int nc = col + Dc[i];

			if (nr < 0 || nr >= arr.length || nc < 0 || nc >= arr[0].length || arr[nr][nc] == 'x')
				continue;

			arr[nr][nc] = 'x';

			if (dfs(nr, nc))
				return true;
		}

		return false;
	}
}
