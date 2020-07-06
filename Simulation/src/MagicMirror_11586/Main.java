package MagicMirror_11586;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		char[][] mirror = new char[n][n];

		for (int i = 0; i < n; i++) {
			mirror[i] = input.next().toCharArray();
		}
		int state = input.nextInt();

		switch (state) {
			case 1:
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						System.out.print(mirror[i][j]);
					}
					System.out.println();
				}
				break;
			case 2:
				for (int i = 0; i < n; i++) {
					for (int j = n - 1; j >= 0; j--) {
						System.out.print(mirror[i][j]);
					}
					System.out.println();
				}
				break;
			case 3:
				for (int i = n - 1; i >= 0; i--) {
					for (int j = 0; j < n; j++) {
						System.out.print(mirror[i][j]);
					}
					System.out.println();
				}
				break;
			default:
				break;
		}
	}

}
