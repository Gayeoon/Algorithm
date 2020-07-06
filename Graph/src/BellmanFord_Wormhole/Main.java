package BellmanFord_Wormhole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Warm {
	int start, end, time;

	Warm(int s, int e, int t) {
		this.start = s;
		this.end = e;
		this.time = t;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		String answer[] = new String[T];
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int w = sc.nextInt();

			ArrayList<Warm> list = new ArrayList<>();

			for (int i = 0; i < m; i++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				int t = sc.nextInt();
				list.add(new Warm(s, e, t));
				list.add(new Warm(e, s, t));
			}
			for (int i = 0; i < w; i++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				int t = sc.nextInt();

				list.add(new Warm(s, e, -1 * t));
			}


			int d[] = new int[n + 1];
			Arrays.fill(d, 1000000000);
			
			d[1] = 0;
			boolean cycle = false;

			outerloop: for (int i = 1; i <= n; i++) {
				cycle = false;
				for (Warm edge : list) {
					if (d[edge.end] > d[edge.start] + edge.time) {
						d[edge.end] = d[edge.start] + edge.time;
						cycle = true;

						if (i == n) {
							cycle = true;
							break outerloop;
						}
					}
				}
				if (!cycle)
					break;
			}
			sb.append((cycle ? "YES" : "NO") + "\n");
		}
		System.out.println(sb);

	}

}
