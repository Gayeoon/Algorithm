package S_6719;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;

public class Solution {
	static double skill = 0;
	static ArrayList<Integer> list;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			list = new ArrayList<>();
			skill = 0;
			for (int i = 0; i < N; i++) {
				list.add(sc.nextInt());
			}
			list.sort(null);

			for (int i = N - K; i < N; i++) {
				skill = (skill + list.get(i)) / 2;
			}
			sb.append("#" + test_case + " " + String.format("%.6f", skill) + "\n");

		}
		System.out.print(sb);
	}
}