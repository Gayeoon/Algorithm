package abbbb_8840;

import java.util.Scanner;
import java.io.FileInputStream;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */
		long[] answer = new long[T];
		for (int test_case = 1; test_case <= T; test_case++) {
			long n = sc.nextInt();
			int index = 1;
			long sum = 0;

			sum = ((n/2)-1) * (1 + (n/2)-1) + n/2;

			answer[test_case-1] = sum;
		}
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.println("#" + test_case + " " + answer[test_case-1]);
		}
	}
}