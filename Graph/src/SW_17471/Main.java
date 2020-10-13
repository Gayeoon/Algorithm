package SW_17471;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static int arr[];
	static boolean color[];
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		arr = new int[n + 1];
		color = new boolean[n + 1];
		for (int i = 0; i <= n; i++)
			list.add(new ArrayList<>());

		for (int i = 1; i <= n; i++)
			arr[i] = input.nextInt();

		for (int i = 1; i <= n; i++) {
			int m = input.nextInt();
			for (int j = 0; j < m; j++) {
				list.get(i).add(input.nextInt());
			}
		}

		coloring(1, 0, 0, 0, 0, n);
		if(result == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(result);
	}

	static void coloring(int idx, int red, int blue, int red_sum, int blue_sum, int n) {
		if (idx > n) {
			if(red == 0 || blue == 0)
				return;
			if (result > Math.abs(red_sum - blue_sum)) {
				if (check(color[1], 1, red, n)) {
					boolean flag = color[1];
					for (int i = 2; i <= n; i++) {
						if (color[i] != flag) {
							if(check(color[i], i, blue, n)) {
								result = Math.abs(red_sum - blue_sum);
							}
							break;
						}
					}
				}
			}
			return;
		}

		color[idx] = true;
		coloring(idx + 1, red + 1, blue, red_sum + arr[idx], blue_sum, n);
		color[idx] = false;
		coloring(idx + 1, red, blue + 1, red_sum, blue_sum + arr[idx], n);
	}

	static boolean check(boolean c, int idx, int cnt, int n) {
		Queue<Integer> queue = new LinkedList<>();
		boolean visit[] = new boolean[n + 1];
		queue.add(idx);
		visit[idx] = true;
		int count = 1;
		while (true) {
			if (queue.isEmpty())
				break;
			int tmp = queue.poll();

			for (int i : list.get(tmp)) {
				if (color[i] == c & !visit[i]) {
					visit[i] = true;
					queue.add(i);
					count++;
				}
			}
		}
		if (count == cnt)
			return true;
		else
			return false;
	}
}
