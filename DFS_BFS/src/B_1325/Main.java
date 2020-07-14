package B_1325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> computer;
	static boolean visit[];
	static int[] deep;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		deep = new int[n + 1];
		
		computer = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			computer.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			computer.get(x).add(y);
		}

		for (int i = 1; i <= n; i++) {
			visit = new boolean[n + 1];
			dfs(i);
		}

		int max = 0;
		for (int i = 1; i <= n; i++) {
			if (max < deep[i]) {
				max = deep[i];
			}
		}
		for (int i = 1; i <= n; i++) {
			if (deep[i] == max) {
				System.out.print(i + " ");
			}
		}

	}

	public static void dfs(int v) {
		visit[v] = true;
		for (int vv : computer.get(v)) {
			if (!visit[vv]) {
				dfs(vv);
				deep[vv]++;
			}
		}
	}

}
