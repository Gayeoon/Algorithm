package Magnetic;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int answer[] = new int[10];
		for (int test_case = 1; test_case <= 1; test_case++) {
			int n = sc.nextInt();
			int arr[][] = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int count = 0;
			for (int j = 0; j < n; j++) {
				for (int i = 0; i < n; i++) {
					if (arr[i][j] == 0)
						continue;
					if (arr[i][j] == 1) {
						arr[i][j] = 0;
						for (int k = i + 1; k < n; k++) {
							if (arr[k][j] == 2) {
								i = k;
								arr[k][j] = 0;
								count++;
								break;
							} else if (arr[k][j] == 1)
								arr[k][j] = 0;
						}
					} else if (arr[i][j] == 2) {
						arr[i][j] = 0;
						for (int k = i - 1; k >= 0; k--) {
							if (arr[k][j] == 1) {
								i = k;
								arr[k][j] = 0;
								count++;
								break;
							}
						}
					}
				}

			}

			answer[test_case - 1] = count;
		}
		for (int test_case = 1; test_case <= 10; test_case++) {
			System.out.println("#" + test_case + " " + answer[test_case - 1]);
		}
	}
}