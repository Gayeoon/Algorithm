package B_9663;

import java.util.Scanner;

public class Main {
	static boolean chess[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		chess = new boolean[n][n];

		System.out.println(solve(0, 0));

	}

	static boolean check(int row, int col) {
		for (int i = 0; i < row; i++) {
			if (chess[i][col])
				return false;
		}
		
		int nc = col;
		int nr = row;
		for (int i = 0; i < chess.length; i++) {
			if (nc < 0 || nr < 0) {
				break;
			}
			if(chess[nr][nc]) return false;
			nc--;
			nr--;
		}
		nc = col;
		nr = row;
		for (int i = 0; i < chess.length; i++) {
			if (nr < 0 || nc == chess.length) 
				break;
			
			if (chess[nr][nc])
					return false;
			nc++;
			nr--;
		}
		return true;
	}
	static int solve(int row, int cnt) {
		int count = 0;
		if (cnt == chess.length)
			return 1;
		for (int i = 0; i < chess.length; i++) {
			if (check(row, i)) {
				chess[row][i] = true;
				count += solve(row + 1, cnt + 1);
				chess[row][i] = false;
			}
		}
		return count;
	}
}
