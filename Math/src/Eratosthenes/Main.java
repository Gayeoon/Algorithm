package Eratosthenes;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	// 에라토스테네스의 체
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		int count = 0;

		for (int i = 0; i < n; i++) {
			int num = input.nextInt();
			if (num == 1)
				continue;
			if (num == 2 || num == 3) {
				count++;
				continue;
			}
			if (find(num))
				count++;
		}
		System.out.println(count);
	}

	static boolean find(int num) {
		for (int i = 2; i <= (int)Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

}
