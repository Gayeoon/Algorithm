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
		 * ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
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