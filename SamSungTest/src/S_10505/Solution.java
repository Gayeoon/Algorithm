package S_10505;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			ArrayList<Integer> list = new ArrayList<>();
			int sum = 0;
			for (int i = 0; i < n; i++) {
				int tmp = sc.nextInt();
				list.add(tmp);
				sum += tmp;
			}
			list.add(sum / n + 1);
			list.sort(null);
			int idx = list.indexOf((Object) (sum / n + 1));
			sb.append("#" + test_case + " " + idx + "\n");
		}

		System.out.print(sb);
	}
}