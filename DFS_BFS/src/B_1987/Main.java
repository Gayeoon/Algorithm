package B_1987;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static char[][] board;
	static int Dr[] = { -1, 1, 0, 0 };
	static int Dc[] = { 0, 0, -1, 1 };
	static HashMap<Character, Integer> hash = new HashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int r = input.nextInt();
		int c = input.nextInt();

		board = new char[r][c];

		for (int i = 0; i < r; i++) {
			String s = input.next();
			for (int j = 0; j < c; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		hash.put(board[0][0], 1);
		System.out.println(1+solve(0,0));
	}

	static int solve(int row, int col) {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			int nr = row + Dr[i];
			int nc = col + Dc[i];

			if (nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length)
				continue;
			
			if(hash.containsKey(board[nr][nc])) continue;
			
			hash.put(board[nr][nc], 1);
			count = Math.max(count, solve(nr, nc)+1);
			hash.remove(board[nr][nc]);
		}
		
		return count;
	}

}
