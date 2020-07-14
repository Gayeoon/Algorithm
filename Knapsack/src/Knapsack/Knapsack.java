package Knapsack;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Knapsack {
	static int[][] item;
	static int value[];
	static int weight[];
	static int index[];
	static int size;

	public static int knapsack(int i, int w) {

		if (i < 0) {
			return 0;
		} else if (w + 1 - weight[i] == 0) {
			return value[i];
		} else if (0 > w + 1 - weight[i]) {
			return knapsack(i - 1, w);
		} else if (w + 1 - weight[i] > 0) {
			int result = max(knapsack(i - 1, w), value[i] + knapsack(i - 1, w - weight[i]));
			return result;
		}
		return 0;
	}

	private static int max(int m, int n) {
		if (m > n) {
			return m;
		} else {
			return n;
		}
	}

	public static void find(int n, int w) {
		for (int i = n; i >= 1; i--) {

			if (w >= 0 && item[i][w] != item[i - 1][w]) {
				index[size] = i;
				size++;
				w = w - weight[i-1];

			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String temp[];

		Scanner input = new Scanner(System.in);

		String t = input.nextLine();

		StringTokenizer parser = new StringTokenizer(t, " ");
		int n = Integer.parseInt(parser.nextToken());
		int w = Integer.parseInt(parser.nextToken());

		value = new int[n];
		weight = new int[n];
		temp = new String[n];
		index = new int[100];

		for (int i = 0; i < n; i++) {
			temp[i] = input.nextLine();
		}

		for (int i = 0; i < n; i++) {
			StringTokenizer parser1 = new StringTokenizer(temp[i], " ");
			value[i] = Integer.parseInt(parser1.nextToken());
			weight[i] = Integer.parseInt(parser1.nextToken());
		}

		item = new int[n + 1][w + 1];

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < w + 1; j++) {
				item[i][j] = 0;
			}
		}

		for (int i = 0; i < w; i++) {
			for (int j = 0; j < n; j++) {
				item[j + 1][i + 1] = knapsack(j, i);
			}
		}
		
		find(n, w);

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < w + 1; j++) {
				System.out.print("\t" + item[i][j]);
			}
			System.out.println();
		}

		System.out.println("Max : " + item[n][w]);

		System.out.print("Item : ");
		for (int k = 0; k < size; k++) {
			System.out.print(index[k] + " ");
		}

	}

}
