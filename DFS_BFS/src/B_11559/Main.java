package B_11559;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static char[][] arr = new char[12][6];
	static boolean[][] visit;
	static int[] Dr = { -1, 1, 0, 0 };
	static int[] Dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		for (int i = 0; i < 12; i++) {
			arr[i] = input.next().toCharArray();
		}

		int count = 0;
		boolean flag = true;
		
		while (flag) {
			flag = false;
			visit = new boolean[12][6];

			for (int i = 11; i >= 0; i--) {
				for (int j = 0; j < 6; j++) {
					if (arr[i][j] == '.' || visit[i][j])
						continue;
					if (dfs(i, j, arr[i][j]) >= 4) {
						removeDfs(i, j, arr[i][j]);
						flag = true;
					}
				}
			}

			if(flag) {
				down();
				count++;
			}
		}

		System.out.println(count);
	}

	static int dfs(int row, int col, char str) {
		int cnt = 1;
		visit[row][col] = true;

		for (int i = 0; i < 4; i++) {
			int nr = row + Dr[i];
			int nc = col + Dc[i];

			if (nr < 0 || nr >= 12 || nc < 0 || nc >= 6 || visit[nr][nc] || arr[nr][nc] != str)
				continue;
			cnt += dfs(nr, nc, str);
		}

		return cnt;
	}

	static void removeDfs(int row, int col, char str) {

		for (int i = 0; i < 4; i++) {
			int nr = row + Dr[i];
			int nc = col + Dc[i];

			if (nr < 0 || nr >= 12 || nc < 0 || nc >= 6 || arr[nr][nc] != str)
				continue;
			arr[nr][nc] = '.';
			removeDfs(nr, nc, str);
		}
	}

	static void down() {
		for(int j=0; j<6; j++) {
			ArrayList<Character> list = new ArrayList<>();
			
			for(int i=11; i>=0; i--) {
				if(arr[i][j] == '.') continue;
				list.add(arr[i][j]);
				arr[i][j] = '.';
			}
			
			int idx = 11;
			
			for(int i=0; i<list.size(); i++) {
				arr[idx][j] = list.get(i);
				idx--;
			}
		}
	}
}
