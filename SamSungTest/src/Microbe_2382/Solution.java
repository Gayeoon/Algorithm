package Microbe_2382;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Microbe implements Comparable<Microbe> {
	int row, col, num, dir;

	Microbe(int row, int col, int num, int dir) {
		this.row = row;
		this.col = col;
		this.num = num;
		this.dir = dir;
	}

	@Override
	public int compareTo(Microbe m) {
		if (this.num >= m.num)
			return -1;
		else
			return 1;
	}
}

public class Solution {

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		int answer[] = new int[T];
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();

			ArrayList<Microbe> list = new ArrayList<>();
			for (int i = 0; i < k; i++) {
				int row = sc.nextInt();
				int col = sc.nextInt();
				int num = sc.nextInt();
				int dir = sc.nextInt();
				list.add(new Microbe(row, col, num, dir - 1));
			}
			int Dr[] = { -1, 1, 0, 0 };
			int Dc[] = { 0, 0, -1, 1 };

			int[][] arr = new int[n][n];
			for (int t = 0; t < m; t++) {
				for (int i = 0; i < n; i++)
					Arrays.fill(arr[i], -1);
				list.sort(null);
				int size = list.size();

				for (int i = 0; i < size; i++) {
					if (list.get(i).num == 0)
						break;
					Microbe tmp = list.get(i);
					int nr = list.get(i).row + Dr[list.get(i).dir];
					int nc = list.get(i).col + Dc[list.get(i).dir];
					if (nr < 0 || nc < 0 || nr > n - 1 || nc > n - 1) {
						nr -= Dr[list.get(i).dir];
						nc -= Dc[list.get(i).dir];
					}
					if (nr == 0 || nc == 0 || nr == n - 1 || nc == n - 1) {
						int dir = 0;
						if (list.get(i).dir == 0 || list.get(i).dir == 2)
							dir = list.get(i).dir + 1;
						else
							dir = list.get(i).dir - 1;
						list.set(i, new Microbe(nr, nc, list.get(i).num / 2, dir));
					} else {
						list.set(i, new Microbe(nr, nc, list.get(i).num, list.get(i).dir));
					}

					if (arr[list.get(i).row][list.get(i).col] == -1 || i < arr[list.get(i).row][list.get(i).col]) {
						arr[list.get(i).row][list.get(i).col] = i;
					} else {
						int idx = arr[list.get(i).row][list.get(i).col];
						list.set(idx, new Microbe(nr, nc, list.get(idx).num + list.get(i).num, list.get(idx).dir));
						list.set(i, new Microbe(nr, nc, 0, list.get(i).dir));
					}
				}
			}

			list.sort(null);
			int sum = 0;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).num == 0)
					break;
				sum += list.get(i).num;
			}
			answer[test_case - 1] = sum;
		}
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.println("#" + test_case + " " + answer[test_case - 1]);
		}

	}
}