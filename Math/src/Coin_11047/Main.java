package Coin_11047;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int k = input.nextInt();
		int[] coin = new int[n];

		for (int i = 0; i < n; i++) {
			coin[i] = input.nextInt();
		}
		int cnt = 0;
		while (k != 0) {
			int idx = Arrays.binarySearch(coin, k);
			if (idx < 0) {
				idx = Math.abs(idx + 1) - 1;
			}
			k -= coin[idx];
			cnt++;
		}
		System.out.println(cnt);
	}

}
