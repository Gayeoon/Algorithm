package B_17070;

import java.util.Scanner;

public class Main {
	static int n;
	static int[][] arr;
	static int[] Dr = { 0, 1, 1 };
	static int[] Dc = { 1, 0, 1 };
	static int cnt = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		n = input.nextInt();
		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				arr[i][j] = input.nextInt();
		}

		solve(0, 1, 0);
		System.out.print(cnt);
	}
	
	static void solve(int row, int col, int dir) {
		if (row == n - 1 && col == n - 1) {
			cnt++;
			return;
		}
		
		for(int i=0; i<3; i++) {
			if(i == 0 && dir == 1)
				continue;
			if(i == 1 && dir == 0)
				continue;
			
			if (check(row + Dr[i], col + Dc[i], i))
				solve(row + Dr[i], col + Dc[i], i);
		}
	}

	static boolean check(int nr, int nc, int dir) {
		if (nr < 0 || nr >= n || nc < 0 || nc >= n)
			return false;
		if (arr[nr][nc] == 1)
			return false;

		if (dir == 2) {
			if (arr[nr - 1][nc] == 1 || arr[nr][nc - 1] == 1)
				return false;
		}

		return true;

	}
}
