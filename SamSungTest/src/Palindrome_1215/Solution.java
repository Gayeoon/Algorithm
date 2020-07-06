package Palindrome_1215;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;

class Solution {
	static char[][] arr;
	static int Dr[] = { 0, 1 };
	static int Dc[] = { 1, 0 };

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		int answer[] = new int[T];
		for (int test_case = 1; test_case <= T; test_case++) {
			int len = sc.nextInt();
			arr = new char[8][8];
			for (int i = 0; i < 8; i++) {
				String temp = sc.next();
				for (int j = 0; j < 8; j++) {
					arr[i][j] = temp.charAt(j);
				}
			}
			int cnt = 0;
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					Stack<Character> stack = new Stack<>();
					if (j <= 8 - len) {
						if (solve(len, i, j, 0, 0, stack)) {
							cnt++;
							System.out.println(i+" "+j);
						}
					}
					if (i <= 8 - len) {
						stack = new Stack<>();
						if (solve(len, i, j, 0, 1, stack)) {
							cnt++;
							System.out.println(i + " " + j);
						}
					}
				}
			}
			answer[test_case - 1] = cnt;
		}
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.println("#" + test_case + " " + answer[test_case - 1]);
		}

	}

	static boolean solve(int len, int row, int col, int index, int dir, Stack<Character> stack) {
		if (index == len && stack.size() == 0)
			return true;
		boolean result = false;
		if (index < len / 2) {
			stack.push(arr[row][col]);
			result = solve(len, row + Dr[dir], col + Dc[dir], index + 1, dir, stack);
		} else if (len % 2 == 1 && index == len / 2) {
			result = solve(len, row + Dr[dir], col + Dc[dir], index + 1, dir, stack);
		} else {
			if (stack.pop() == arr[row][col]) {
				result = solve(len, row + Dr[dir], col + Dc[dir], index + 1, dir, stack);
			} else
				return false;
		}
		return result;
	}
}