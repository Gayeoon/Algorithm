package B_2239;

import java.util.Scanner;

public class Main {
	static int arr[][] = new int[9][9];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		for (int i = 0; i < 9; i++) {
			String str = input.next();

			for (int j = 0; j < 9; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		solve(0, 0);
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

	static boolean solve(int row, int col) {
		if (col == 9) {
			col = 0;
			row++;
		}
		if (row == 9) {
			return true;
		}
		if (arr[row][col] != 0)
			return solve(row, col + 1);

		boolean result;
		for (int i = 1; i <= 9; i++) {
			if (isOkay(row, col, i)) {
				arr[row][col] = i;
				result = solve(row, col + 1);
				if (result)
					return result;
			}
		}
		arr[row][col] = 0;
		return false;
	}

	static boolean isOkay(int row, int col, int val) {
		for (int i = 0; i < 9; i++) {
			if (arr[row][i] == val)
				return false;
			if (arr[i][col] == val)
				return false;
		}

		int rMin, rMax, cMin, cMax;

		if (row < 3) {
			rMin = 0;
			rMax = 3;
		} else if (row < 6) {
			rMin = 3;
			rMax = 6;
		} else {
			rMin = 6;
			rMax = 9;
		}

		if (col < 3) {
			cMin = 0;
			cMax = 3;
		} else if (col < 6) {
			cMin = 3;
			cMax = 6;
		} else {
			cMin = 6;
			cMax = 9;
		}
		
		for(int i=rMin; i<rMax; i++) {
			for(int j=cMin; j<cMax; j++) {
				if(arr[i][j] == val)
					return false;
			}
		}
		return true;
	}
}
