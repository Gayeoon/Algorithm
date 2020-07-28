package B_1309;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();

		int cage[][] = new int[n][3];

		cage[0][0] = cage[0][1] = cage[0][2] = 1;

		for (int i = 1; i < n; i++) {
			cage[i][0] = (cage[i - 1][0] + cage[i - 1][1] + cage[i - 1][2]) % 9901;
			cage[i][1] = (cage[i - 1][0] + cage[i - 1][2]) % 9901;
			cage[i][2] = (cage[i - 1][0] + cage[i - 1][1]) % 9901;
		}

		int result = (cage[n - 1][0] + cage[n - 1][1] + cage[n - 1][2]) % 9901;
		System.out.println(result);
	}
}
