package Olympic_3347;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;


class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		int answer[] = new int[T];
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] event = new int[n];
			int[] count = new int[n];
			int[] committee = new int[m];
			for (int i = 0; i < n; i++) {
				event[i] = sc.nextInt();
			}
			for (int i = 0; i < m; i++) {
				committee[i] = sc.nextInt();
			}

			Arrays.sort(committee);
			int max = 0;
			int start = 0;
			for (int i = m-1; i >= 0; i--) {
				for(int j = start; j<n; j++) {
					if(committee[i] >= event[j]) {
						count[j]++;
						max = Math.max(count[j], max);
						start = j;
						break;
					}
				}
				
			}
			answer[test_case - 1] = max;

		}
		
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.println("#" + test_case + " " + answer[test_case - 1]);
		}

	}
}