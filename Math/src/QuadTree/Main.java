package QuadTree;

import java.util.Scanner;

public class Main {
	static int arr[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();

		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String temp = input.next();
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(""+temp.charAt(j));
			}
		}
		if (N == 1) {
			System.out.println(arr[0][0]);
		} else {
			System.out.println(solve(0, 0, N));
		}
	}
	static String solve(int row, int col, int offset) {
		if (offset == 1) {
			return "" + arr[row][col];
		} else {
			String result = "";
			String prev = "";
			String next = "";
			boolean flag = true;

			prev = solve(row, col, offset / 2);
			result += prev;

			next = solve(row, col + offset / 2, offset / 2);
			if (next.length() != 1 || !prev.equals(next))
				flag = false;
			prev = next;
			result += prev;

			next = solve(row + offset / 2, col, offset / 2);
			if (next.length() != 1 || flag && !prev.equals(next))
				flag = false;
			prev = next;
			result += prev;

			next = solve(row + offset / 2, col + offset / 2, offset / 2);
			if (next.length() != 1 || flag && !prev.equals(next))
				flag = false;
			prev = next;
			result += prev;

			if (flag) {
				return prev;
			} else {
				return "(" + result + ")";
			}
		}
	}

}
