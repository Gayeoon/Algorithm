package GuitarStrings;

import java.util.Scanner;

// Greedy Algorithm

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();

		int[][] brand = new int[m][2];

		for (int i = 0; i < m; i++) {
			brand[i][0] = input.nextInt();
			brand[i][1] = input.nextInt();
		}

		int min = Integer.MAX_VALUE;
		int result = 0;
		
		while(n > 0) {
			for (int i = 0; i < m; i++) {
				if(n>=6) {
					min = Math.min(brand[i][0] * (n / 6), min);
					min = Math.min(brand[i][1] * (n - (n%6)), min);
				}
				else {
					min = Math.min(brand[i][0], min);
					min = Math.min(brand[i][1] * n, min);
				}
			}
			result += min;
			if(n < 6) break;
			else n = n%6;
			min = Integer.MAX_VALUE;
		}
		
		System.out.println(result);

	}
}