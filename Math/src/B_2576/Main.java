package B_2576;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int sum = 0;
		int min = 101;
		for (int i = 0; i < 7; i++) {
			int tmp = input.nextInt();
			if (tmp % 2 != 0) {
				sum += tmp;
				min = Math.min(min, tmp);
			}
		}

		if (sum == 0)
			System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(min);
		}
	}

}
