package PaintChess;

import java.util.Scanner;

public class Main {
	static char[][] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();

		arr = new char[n][m];

		for (int i = 0; i < n; i++) {
			String str = input.next();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= n - 8; i++) {
			for (int j = 0; j <= m - 8; j++) {
				min = Math.min(min, find(i, j));
			}
		}
		System.out.println(min);
	}

	static int find(int row, int col) {
		int w_cnt = 0, b_cnt = 0;
		char white = 'W';
		char black = 'B';

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (arr[i + row][j + col] != white)
					w_cnt++;
				if (arr[i + row][j + col] != black)
					b_cnt++;
				char tmp = white;
				white = black;
				black = tmp;
			}
			char tmp = white;
			white = black;
			black = tmp;
		}
		return Math.min(w_cnt, b_cnt);
	}
}
