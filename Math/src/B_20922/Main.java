package B_20922;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int K = input.nextInt();

		int arr[] = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = input.nextInt();
		}

		int num[] = new int[100001];
		int start = 0;
		int end = 0;
		int cnt = 0, max = 0;

		while (true) {
			if (end == N)
				break;

			while (num[arr[end]] >= K) {
				num[arr[start]]--;
				start++;
				cnt--;
			}

			num[arr[end]]++;
			end++;
			cnt++;
			max = Math.max(max, cnt);

		}

		System.out.println(max);
	}
}
