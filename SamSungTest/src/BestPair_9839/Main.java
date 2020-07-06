package BestPair_9839;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;
import java.util.Arrays;

public class Main {

	static int max = -1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */
		int answer[] = new int[T];
		for (int test_case = 1; test_case <= T; test_case++) {
			max = -1;
			int n = sc.nextInt();
			if (n == 1) {
				int t = sc.nextInt();
				answer[test_case - 1] = -1;
			} else {
				int arr[] = new int[n];
				for (int i = 0; i < n; i++) {
					arr[i] = sc.nextInt();
				}
				for (int i = 0; i < n; i++) {
					for (int j = i + 1; j < n; j++) {
						int mul = arr[i] * arr[j];
						if (mul > max)
							check(mul);
					}
				}
				answer[test_case - 1] = max;
			}
		}
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.println("#" + test_case + " " + answer[test_case - 1]);
		}
	}

	static boolean check(int mul) {
		int temp = mul;
		int prev = temp % 10;
		temp /= 10;
		System.out.print(mul + " : " + prev + " ");
		if (Math.log10(max) == Math.log10(mul) && prev <= max % 10)
			return false;
		while (temp >= 1) {
			System.out.print(temp % 10 + " ");
			if (prev - 1 == temp % 10) {
				System.out.print(prev - 1 + " ");
				prev--;
				temp /= 10;
			} else
				return false;
		}
		System.out.println();
		max = Math.max(max, mul);
		return true;
	}
}