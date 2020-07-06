package Parking_9280;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] cost = new int[n];
			int[] weight = new int[m + 1];

			HashMap<String, Integer> parking = new HashMap<>();
			Queue<Integer> in = new LinkedList<Integer>();
			PriorityQueue<Integer> out = new PriorityQueue<>();

			for (int i = 0; i < n; i++) {
				cost[i] = sc.nextInt();
				out.add(i);
			}
			for (int i = 1; i <= m; i++) {
				weight[i] = sc.nextInt();
			}
			int sum = 0;
			for (int i = 0; i < 2 * m; i++) {
				String str = sc.next();
				if (str.charAt(0) == '-') {
					str = str.substring(1, str.length());
					int temp = parking.get(str);
					parking.remove(str);
					out.add(temp);
					if (in.isEmpty())
						continue;
					parking.put(in.peek()+"", out.peek());
					sum += weight[in.poll()] * cost[out.poll()];
				} else {
					if (out.isEmpty()) {
						in.add(Integer.parseInt(str));
					} else {
						parking.put(str, out.peek());
						sum += weight[Integer.parseInt(str)] * cost[out.poll()];
						System.out.println(sum);
					}
				}

			}
			System.out.println("#" + test_case + " " + sum);
		}
	}
}