package FloydWarshall_17182;

import java.util.Scanner;

public class Main {
	static int arr[][];
	static boolean visit[];
	static int n;
	static int result = Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		int k = input.nextInt();

		arr = new int[n][n];
		visit = new boolean[n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = input.nextInt();
			}
		}

		for (int t = 0; t < n; t++) {
			for (int i = 0; i < n; i++) {
				if (t == i)
					continue;
				for (int j = 0; j < n; j++) {
					if (i == j || t == j)
						continue;
					arr[i][j] = Math.min(arr[i][j], arr[i][t] + arr[t][j]);
				}
			}
		}

		visit[k] = true;
		dfs(k, 1, 0);

		System.out.println(result);
	}

	static void dfs(int idx, int cnt, int time) {
		if(result <= time)
			return;
		
		if (cnt == n) {
			result = Math.min(result, time);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				dfs(i, cnt + 1, time + arr[idx][i]);
				visit[i] = false;
			}
		}
	}
}
