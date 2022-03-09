package B_11501;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int TC = input.nextInt();

		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < TC; t++) {
			int n = input.nextInt();
			long arr[] = new long[n];
			for (int i = 0; i < n; i++)
				arr[i] = input.nextLong();

			long ans = 0;
			long max = 0;

			for (int i = n - 1; i >= 0; i--) {
				if (arr[i] > max)
					max = arr[i];
				else
					ans += max - arr[i];
			}

			sb.append(ans + "\n");
		}

		System.out.print(sb);
	}

}
