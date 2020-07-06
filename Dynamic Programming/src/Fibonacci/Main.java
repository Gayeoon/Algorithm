package Fibonacci;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int[] one;
	static int[] zero;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int cnt = input.nextInt();
		int[] inputValue = new int[cnt];

		for (int i = 0; i < cnt; i++) {
			inputValue[i] = input.nextInt();
		}

		one = new int[42];
		zero = new int[42];

		Arrays.fill(one, -1);
		Arrays.fill(zero, -1);

		one[0] = zero[1] = 0;
		zero[0] = one[1] = 1;
		
		for (int i = 0; i < cnt; i++) {
			if (inputValue[i] == 0 || inputValue[i] == 1)
				System.out.println(zero[inputValue[i]] + " " + one[inputValue[i]]);
			else {
				solve(inputValue[i]);
				System.out.println(zero[inputValue[i]] + " " + one[inputValue[i]]);				
			}
		}

	}

	static void solve(int target) {
		if (zero[target - 1] == -1)
			solve(target - 1);
		if (zero[target - 2] == -1)
			solve(target - 2);

		zero[target] = zero[target - 1] + zero[target - 2];
		one[target] = one[target - 1] + one[target - 2];

	}

}
