package View_1206;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int answer[] = new int[1];
		for (int test_case = 1; test_case <= 1; test_case++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][10];
			boolean[][] build = new boolean[n][10];
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				list.add(sc.nextInt());
				if (list.get(i) != 0) {
					Arrays.fill(build[i], 0, list.get(i), true);
				} else {
					Arrays.fill(arr[i], 1);
				}
			}
			for (int i = 2; i < n - 2; i++) {
				if (list.get(i) == 0)
					continue;
				int temp = list.get(i) - list.get(i - 1);
				if (temp < 0)
					temp = 0;
				for (int j = temp; j > 0; j--) {
					if (!build[i - 2][list.get(i) - j]) {
						arr[i][list.get(i) - j] = 2;
					}
				}
			}

			int count = 0;
			for (int i = n - 3; i >= 2; i--) {
				if (list.get(i) == 0)
					continue;
				int temp = list.get(i) - list.get(i + 1);
				if (temp < 0)
					temp = 0;
				for (int j = temp; j > 0; j--) {
					if (arr[i][list.get(i) - j] != 2)
						continue;
					if (!build[i + 2][list.get(i) - j]) {
						count++;
					}
				}
			}
			answer[test_case -1] = count;
		}
		for (int test_case = 1; test_case <= 1; test_case++) {
			System.out.println("#" + test_case + " " + answer[test_case - 1]);
		}
	}
}