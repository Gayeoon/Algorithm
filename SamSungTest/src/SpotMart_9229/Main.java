package SpotMart_9229;

import java.util.Scanner;

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
			int weight = sc.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			conv(arr, weight, 0, 0, 0);
			answer[test_case - 1] = max;
		}
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.println("#" + test_case + " " + answer[test_case - 1]);
		}
	}

	static int conv(int[] arr, int weight, int index, int cnt, int now) {
		if (cnt == 2) {
			return now;
		} else if (index == arr.length) {
			return -1;
		} else {
			int result = -1;

			if (weight - arr[index] >= 0) {
				result = conv(arr, weight - arr[index], index + 1, cnt + 1, now + arr[index]);
				if (result != -1)
					max = Math.max(max, result);
			}
			result = conv(arr, weight, index + 1, cnt, now);
			if (result != -1)
				max = Math.max(max, result);
			return max;
		}
	}
}