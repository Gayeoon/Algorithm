package B_10775;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int gate[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int G = input.nextInt();
		int P = input.nextInt();

		gate = new int[G + 1];
		Arrays.fill(gate, -1);
		int cnt = 0;
		boolean flag = true;
		for (int i = 0; i < P; i++) {
			int n = input.nextInt();

			if (flag) {
				if (find(n) > 0)
					cnt++;
				else
					flag = false;
			}
		}

		System.out.println(cnt);
	}

	static int find(int n) {
		if (n == 0 || gate[n] == 0)
			return 0;
		if (gate[n] == -1) {
			gate[n] = n;
			return n;
		}
		int tmp = gate[n];
		if (gate[n] == n)
			tmp = n - 1;
		return gate[n] = find(tmp);
	}
}
