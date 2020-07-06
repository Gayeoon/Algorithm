package MakeNumber_4008;

import java.util.Scanner;
import java.io.FileInputStream;

public class Main {
	static long max, min;
	static int plus, minus, mul, div;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		long answer[] = new long[T];
		for (int test_case = 1; test_case <= T; test_case++) {
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			int n = sc.nextInt();
			char arr[] = new char[n - 1];

			plus = sc.nextInt();
			minus = sc.nextInt() + plus;
			mul = sc.nextInt() + minus;
			div = sc.nextInt() + mul;

			int num[] = new int[n];
			for (int i = 0; i < n; i++)
				num[i] = sc.nextInt();
			solve(n - 1, num, 1, num[0], plus, minus - plus, mul - minus, div - mul, "");
			answer[test_case - 1] = max - min;
		}
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.println("#" + test_case + " " + answer[test_case - 1]);
		}
	}

	static void solve(int n, int[] num, int index, long sum, int p, int m, int mu, int d, String str) {
		if (n + 1 == index) {
			System.out.println(str);
			max = Math.max(max, sum);
			min = Math.min(min, sum);
		}
		boolean flag = false;
		for (int i = 0; i < plus; i++) {
			if (flag)
				break;
			if (p == 0)
				break;
			flag = true;
			solve(n, num, index + 1, sum + num[index], p - 1, m, mu, d, str+"+");
		}
		flag = false;
		for (int i = plus; i < minus; i++) {
			if (flag)
				break;
			if (m == 0)
				break;
			flag = true;
			solve(n, num, index + 1, sum - num[index], p, m - 1, mu, d, str+"-");
		}
		flag = false;
		for (int i = minus; i < mul; i++) {
			if (flag)
				break;
			if (mu == 0)
				break;
			flag = true;
			solve(n, num, index + 1, sum * num[index], p, m, mu - 1, d, str+"*");
		}
		flag = false;
		for (int i = mul; i < div; i++) {
			if (flag)
				break;
			if (d == 0)
				break;
			if (num[index] == 0)
				continue;
			flag = true;
			solve(n, num, index + 1, sum / num[index], p, m, mu, d - 1, str+"/");
		}
	}
}