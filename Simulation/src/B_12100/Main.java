package B_12100;

import java.util.Scanner;

public class Main {
	static int n, max = 0;
	static int Dr[] = { -1, 0, 1, 0 };
	static int Dc[] = { 0, -1, 0, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		int arr[][] = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				arr[i][j] = input.nextInt();

		// move(arr, 0);
		combi(arr, 0, "");

		System.out.println(max);
	}

	static void combi(int[][] arr, int cnt, String str) {
		if (cnt == 5) {


			System.out.println("\n");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					System.out.print(arr[i][j] + "\t");
				System.out.println();
			}
			max = Math.max(max, check(arr));
			if(max == 128) {
				int a = 124;
				int b = 123;
				int c = a+b;
				System.out.println("\n im here!! \n");
			}
			System.out.println("\n -------> " + max);
		} else {
			combi(move(arr, 0), cnt + 1, str+0);
			combi(move(arr, 1), cnt + 1, str+1);
			combi(move(arr, 2), cnt + 1, str+2);
			combi(move(arr, 3), cnt + 1, str+3);
		}
	}

	static int check(int[][] arr) {
		int num = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				num = Math.max(num, arr[i][j]);

		return num;
	}

	static int[][] move(int[][] arr, int flag) {
		int[][] result = new int[n][n];
		boolean[][] visit = new boolean[n][n];
		if (flag <= 1) {
			for (int i = n - 1; i >= 0; i--) {
				for (int j = n - 1; j >= 0; j--) {
					if (visit[i][j])
						continue;
					if ((flag == 0 && i == 0) || (flag == 1 && j == 0))
						result[i][j] = arr[i][j];
					else {
						int nr = i;
						int nc = j;
						while (true) {
							nr += Dr[flag];
							nc += Dc[flag];
							if (flag == 0 && nr < 0) {
								result[0][nc] = arr[i][j];
								break;
							}
							if (flag == 1 && nc < 0) {
								result[nr][0] = arr[i][j];
								break;
							}

							visit[nr][nc] = true;
							if (arr[nr][nc] == 0)
								continue;
							if (arr[nr][nc] == arr[i][j]) {
								result[i][j] = 0;
								result[nr][nc] = arr[i][j] * 2;
								break;
							} else {
								result[nr - Dr[flag]][nc - Dc[flag]] = arr[i][j];
								visit[nr][nc] = false;
								break;
							}

						}
					}

				}
			}
		} else {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (visit[i][j])
						continue;
					if ((flag == 2 && i == n - 1) || (flag == 3 && j == n - 1))
						result[i][j] = arr[i][j];
					else if (arr[i][j] == 0) {
						result[i][j] = 0;
					} else {
						int nr = i;
						int nc = j;
						while (true) {
							nr += Dr[flag];
							nc += Dc[flag];
							if (flag == 2 && nr >= n) {
								result[n - 1][nc] = arr[i][j];
								break;
							}
							if (flag == 3 && nc >= n) {
								result[nr][n - 1] = arr[i][j];
								break;
							}
							visit[nr][nc] = true;
							if (arr[nr][nc] == 0)
								continue;
							if (arr[nr][nc] == arr[i][j]) {
								result[i][j] = 0;
								result[nr][nc] = arr[i][j] * 2;
								break;
							} else {
								result[nr - Dr[flag]][nc - Dc[flag]] = arr[i][j];
								break;
							}
						}
					}

				}
			}
		}		
		return result;
	}

}
