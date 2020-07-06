package DesertCafe_2105;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;

public class Main {

	static int Dr[] = { 1, 1, -1, -1 };
	static int Dc[] = { -1, 1, 1, -1 };
	static int Dir[] = { 3, 2, 1, 0 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		int answer[] = new int[T];
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int arr[][] = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int max = -1;
			for (int i = 0; i < n - 2; i++) {
				for (int j = 1; j < n - 1; j++) {
					ArrayList<Integer> list = new ArrayList<>();
					list.add(arr[i][j]);
					max = Math.max(max, solve(arr, 0, i, j, i+Dr[0], j+Dc[0], list, false));
				}
			}
			answer[test_case - 1] = max;
		}

		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.println("#" + test_case + " " + answer[test_case - 1]);
		}
	}

	static int solve(int[][] arr, int dir, int startRow, int startCol, int row, int col, ArrayList<Integer> list,
			boolean flag) {
		int result = -1;
		if(row == startRow && col == startCol)
			return list.size();
		if(row < 0 || row >= arr.length || col < 0 || col >= arr[0].length)
			return -1;
		if(list.contains(arr[row][col]))
			return -1;
		list.add(arr[row][col]);
		result = solve(arr, dir, startRow, startCol, row+Dr[dir], col+Dc[dir], list, flag);
		if(dir != 3)
			result = Math.max(result, solve(arr, dir+1, startRow, startCol, row+Dr[dir+1], col+Dc[dir+1], list, flag));
		list.remove((Object)arr[row][col]);
		return result;
	}
}