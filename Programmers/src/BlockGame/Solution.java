package BlockGame;

import java.util.ArrayList;

public class Solution {
	static int[][] bd;

	public static void main(String[] args) {

		int[][] board = {{0,0,0,0,0,0,0,0,0,0}
		,{0,0,0,0,0,0,0,0,0,0}
		,{0,0,0,0,0,0,0,0,0,0}
		,{0,0,0,0,0,0,0,0,0,0}
		,{0,0,0,2,2,0,0,0,0,0}
		,{0,0,0,2,1,0,0,0,0,0}
		,{0,0,0,2,1,0,0,0,0,0}
		,{0,0,0,0,1,1,0,0,0,0}
		,{0,0,0,0,0,0,0,0,0,0}
		,{0,0,0,0,0,0,0,0,0,0}};
		int answer = 0;
		int min = board.length;
		bd = board;
		for (int j = 0; j < board[0].length; j++) {
			for (int i = 0; i < board.length; i++) {
				if (board[i][j] != 0) {
					min = Math.min(min, i);
					break;
				}
				board[i][j] = -1;
			}
		}

		int prev = 0;
		while (true) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = min; i < bd.length; i++) {
				for (int j = 0; j < bd[0].length; j++) {
					if (bd[i][j] <= 0)
						continue;
					int tmp = bd[i][j];
					if (list.contains(tmp))
						continue;
					if (check(i, j, bd[i][j])) {
						answer++;
					}
					list.add(tmp);
				}
			}
			if (prev == answer)
				break;
			prev = answer;
		}
		System.out.println(answer);
	}

	public static boolean check(int row, int col, int color) {
		int like = 0;
		int me = 0;
		boolean flag = true;
		for (int i = row; i < row + 2; i++) {
			if (!flag)
				break;
			for (int j = col - 2; j < col + 2; j++) {
				if (i >= bd.length || j >= bd.length || i < 0 || j < 0)
					continue;
				if (like > 4 || me > 2) {
					flag = false;
					break;
				}

				if (bd[i][j] == color)
					like++;
				if (bd[i][j] == -1)
					me++;
			}
		}
		if (like != 4 && me != 2)
			flag = false;
		if (flag) {
			for (int i = row; i < row + 2; i++) {
				for (int j = col - 2; j < col + 2; j++) {
					if (i >= bd.length || j >= bd.length || i < 0 || j < 0)
						continue;
					if (bd[i][j] == color)
						bd[i][j] = -1;
				}
			}
			return true;
		}
		flag = true;
		like = me = 0;
		for (int i = row; i < row + 3; i++) {
			if (!flag)
				break;
			for (int j = col - 1; j < col + 1; j++) {
				if (i >= bd.length || j >= bd.length || i < 0 || j < 0)
					continue;
				if (like > 4 || me > 2) {
					flag = false;
					break;
				}
				if (bd[i][j] == color)
					like++;
				if (bd[i][j] == -1)
					me++;
			}
		}
		if (like != 4 && me != 2)
			flag = false;
		if (flag) {
			for (int i = row; i < row + 3; i++) {
				for (int j = col - 1; j < col + 1; j++) {
					if (i >= bd.length || j >= bd.length || i < 0 || j < 0)
						continue;

					if (bd[i][j] == color)
						bd[i][j] = -1;
				}
			}
			return true;
		}

		return false;
	}
}