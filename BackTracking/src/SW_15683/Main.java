package SW_15683;

import java.util.ArrayList;
import java.util.Scanner;

class CCTV {
	int row, col, type;

	CCTV(int row, int col, int type) {
		this.row = row;
		this.col = col;
		this.type = type;
	}
}

public class Main {
	static int[][] arr;
	static int n, m;
	static ArrayList<CCTV> list = new ArrayList<>();
	static int Dr[] = { -1, 0, 1, 0 };
	static int Dc[] = { 0, -1, 0, 1 };
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();

		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = input.nextInt();
				if (arr[i][j] >= 1 && arr[i][j] <= 5)
					list.add(new CCTV(i, j, arr[i][j]));
			}
		}

		solve(0);
		System.out.println(result);
	}

	static void solve(int idx) {
		if (idx >= list.size()) {
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (arr[i][j] == 0)
						cnt++;
				}
			}
			result = Math.min(result, cnt);
			return;
		}

		int[][] copyArr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copyArr[i][j] = arr[i][j];
			}
		}

		switch (list.get(idx).type) {
		case 1:
			for (int i = 0; i < 4; i++) {
				watching(idx, i);
				solve(idx + 1);
				disWatching(idx, i, copyArr);

			}
			break;
		case 2:
			for(int i=0; i<2; i++) {
				watching(idx, i);
				watching(idx, i+2);
				solve(idx+1);
				disWatching(idx, i, copyArr);
				disWatching(idx, i+2, copyArr);
			}
			break;
		case 3:
			watching(idx, 0);
			watching(idx, 1);
			solve(idx+1);
			for(int i=1; i<4; i++) {
				disWatching(idx, i-1, copyArr);
				watching(idx, (i+1)%4);
				solve(idx+1);
			}
			disWatching(idx, 0, copyArr);
			disWatching(idx, 3, copyArr);
			break;
		case 4:
			watching(idx, 0);
			watching(idx, 1);
			watching(idx, 2);
			solve(idx+1);
			for(int i=1; i<4; i++) {
				disWatching(idx, i-1, copyArr);
				watching(idx, (i+2)%4);
				solve(idx+1);
			}
			disWatching(idx, 0, copyArr);
			disWatching(idx, 1, copyArr);
			disWatching(idx, 3, copyArr);
			break;
		case 5:
			for(int i=0; i<4; i++)
				watching(idx, i);
			solve(idx+1);
			for(int i=0; i<4; i++)
				disWatching(idx, i, copyArr);
			break;
		}
	}

	static void disWatching(int idx, int dir, int[][] copyArr) {
		int nr = list.get(idx).row;
		int nc = list.get(idx).col;
		while (true) {
			nr += Dr[dir];
			nc += Dc[dir];

			if (nr < 0 || nr >= n || nc < 0 || nc >= m || arr[nr][nc] == 6)
				break;
			arr[nr][nc] = copyArr[nr][nc];
		}
	}

	static void watching(int idx, int dir) {
		int nr = list.get(idx).row;
		int nc = list.get(idx).col;
		while (true) {
			nr += Dr[dir];
			nc += Dc[dir];

			if (nr < 0 || nr >= n || nc < 0 || nc >= m || arr[nr][nc] == 6)
				break;
			if (arr[nr][nc] != 0)
				continue;
			arr[nr][nc] = -1;
		}
	}
}
