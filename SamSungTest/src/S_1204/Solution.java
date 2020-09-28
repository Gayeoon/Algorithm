package S_1204;

import java.util.Scanner;

public class Solution {

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int max = 0;
			int idx = 0;
			int arr[] = new int[101];

			for (int i = 0; i < 1000; i++) {
				int num = sc.nextInt();
				arr[num]++;
				if (max < arr[num]) {
					idx = num;
					max = arr[num];
				} else if (max == arr[num])
					if (idx < num)
						idx = num;
			}
			sb.append("#" + test_case + " " + idx + "\n");
		}
		System.out.print(sb);
	}
}