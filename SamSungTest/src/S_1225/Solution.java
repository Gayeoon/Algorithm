package S_1225;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = sc.nextInt();
			sb.append("#" + T);
			Queue<Integer> queue = new LinkedList<>();
			for (int i = 0; i < 8; i++) {
				queue.add(sc.nextInt());
			}
			int idx = 1;
			while (true) {
				int tmp = queue.poll();
				tmp -= idx;
				if (tmp <= 0) {
					queue.add(0);
					break;
				}
				queue.add(tmp);
				if(idx == 5)
					idx = 1;
				else
					idx++;
			}
			while (true) {
				if (queue.isEmpty())
					break;

				sb.append(" " + queue.poll());
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}