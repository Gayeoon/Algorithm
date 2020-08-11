package B_3023;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int m = input.nextInt();

		char arr[][] = new char[2 * n][2 * m];

		for (int i = 0; i < n; i++) {
			String str = input.next();
			for (int j = 0; j < m; j++)
				arr[i][j] = str.charAt(j);
		}

		int a = input.nextInt();
		int b = input.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][m + j] = arr[i][m - j - 1];
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2*m; j++) {
				arr[n + i][j] = arr[n - i - 1][j];
			}
		}

		if(arr[a-1][b-1] == '#')
			arr[a-1][b-1] = '.';
		else
			arr[a-1][b-1] = '#';
		
		for (int i = 0; i < 2 * n; i++) {
			for (int j = 0; j < 2 * m; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

}
