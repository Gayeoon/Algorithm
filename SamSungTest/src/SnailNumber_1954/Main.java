package SnailNumber_1954;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */
		List<int[][]> list = new ArrayList<>();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int arr[][] = new int[n][n];

			int iidx = 0, jidx = 0;
			int i = -1, j = 1;
			int cnt = 1;
			boolean flag = false;
			if(n == 1) {
				arr[0][0] = 1;
				list.add(arr);
				continue;
			}
			while (true) {
				if (arr[iidx][jidx] != 0)
					break;
				arr[iidx][jidx] = cnt;
				cnt++;
				if (flag) {
					if (jidx == n - 1 || jidx == 0 || arr[iidx][jidx + j] != 0) {
						flag = false;
						j = j * (-1);
						iidx += i;
					} else
						jidx += j;
				} else {
					if (iidx == n - 1 || iidx == 0 || arr[iidx + i][jidx] != 0) {
						flag = true;
						i = i * (-1);
						jidx += j;
					} else
						iidx += i;
				}
			}
			list.add(arr);
		}
		for (int test_case = 1; test_case <= T; test_case++) {
			int[][] arr = list.get(test_case-1);
			System.out.println("#" + test_case);
			for (int a = 0; a < arr.length; a++) {
				for (int b = 0; b < arr[0].length; b++) {
					System.out.print(arr[a][b]+" ");
				}
				System.out.println("");
			}

		}
	}
}
