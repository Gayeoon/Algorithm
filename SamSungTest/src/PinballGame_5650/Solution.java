package PinballGame_5650;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

class Hole {
	int row, col;

	Hole(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

class Solution {

	public static void main(String args[]) throws Exception {
		int arr[][];
		HashMap<Hole, HashMap<Integer, Integer>> dp;
		int[] Dr = { -1, 1, 0, 0 };
		int[] Dc = { 0, 0, -1, 1 };
		HashMap<Integer, ArrayList<Hole>> wormhole;

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */
		int answer[] = new int[T];
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			arr = new int[n][n];
			dp = new HashMap<>();
			wormhole = new HashMap<>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
					if (6 <= arr[i][j] && arr[i][j] <= 10) {
						if (wormhole.containsKey(arr[i][j])) {
							ArrayList<Hole> list = new ArrayList<>();
							list = wormhole.get(arr[i][j]);
							list.add(new Hole(i, j));
							wormhole.put(arr[i][j], list);
						} else {
							ArrayList<Hole> list = new ArrayList<>();
							list.add(new Hole(i, j));
							wormhole.put(arr[i][j], list);
						}
					}
				}
			}
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] != 0)
						continue;

					for (int k = 0; k < 4; k++) {
						int nr = i + Dr[k];
						int nc = j + Dc[k];
						int dir = k;
						int cnt = 0;

						while (true) {
							if (nr == i && nc == j)
								break;

							if (nr < 0) {
								dir = 1;
								cnt++;
							} else if (nr >= n) {
								dir = 0;
								cnt++;
							} else if (nc < 0) {
								dir = 3;
								cnt++;
							} else if (nc >= n) {
								dir = 2;
								cnt++;
							}

							else if (arr[nr][nc] == -1)
								break;
							else if (wormhole.containsKey(arr[nr][nc])) {
								ArrayList<Hole> list = new ArrayList<>();
								list = wormhole.get(arr[nr][nc]);
								if (nr == list.get(0).row && nc == list.get(0).col) {
									nr = list.get(1).row;
									nc = list.get(1).col;
								} else {
									nr = list.get(0).row;
									nc = list.get(0).col;
								}
							} else {
								int d = findDir(arr[nr][nc], dir);
								if (d != dir) {
									dir = d;
									cnt++;
								}
							}

							nr += Dr[dir];
							nc += Dc[dir];

						}
						max = Math.max(max, cnt);
					}

				}
			}
			if (max == Integer.MIN_VALUE)
				answer[test_case - 1] = 0;
			else
				answer[test_case - 1] = max;
		}
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.println("#" + test_case + " " + answer[test_case - 1]);
		}
	}

	static int findDir(int num, int dir) {
		if (num == 0)
			return dir;

		switch (dir) {
		case 0:
			if (num == 1 || num == 4 || num == 5)
				return 1;
			else if (num == 2)
				return 3;
			else
				return 2;
		case 1:
			if (num == 2 || num == 3 || num == 5)
				return 0;
			else if (num == 1)
				return 3;
			else
				return 2;
		case 2:
			if (num == 3 || num == 4 || num == 5)
				return 3;
			else if (num == 1)
				return 0;
			else
				return 1;
		case 3:
			if (num == 1 || num == 2 || num == 5)
				return 2;
			else if (num == 3)
				return 1;
			else
				return 0;
		default:
			break;
		}
		return -1;
	}
}