package CleanRoom_9938;

import java.util.Scanner;

public class Main {
	static int drawer[];
	static boolean visit[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int l = input.nextInt();

		drawer = new int[l + 1];
		visit = new boolean[l + 1];
		
		for (int i = 0; i < n; i++) {
			boolean flag = true;
			int a = input.nextInt();
			int b = input.nextInt();

			if (!visit[a]) {
				visit[a] = true;
				drawer[a] = a+1;
				sb.append("LADICA" + "\n");
				continue;
			}
			if (!visit[b]) {
				visit[b] = true;
				drawer[b] = b+1;
				sb.append("LADICA" + "\n");
				continue;
			}
			int result = find(a);
			if (result > 0 && !visit[result-1]) {
				visit[result-1] = true;
				sb.append("LADICA" + "\n");
				continue;
			}
			result = find(b);
			if (result > 0 && !visit[result-1]) {
				visit[result-1] = true;
				sb.append("LADICA" + "\n");
				continue;
			}

			sb.append("SMECE" + "\n");
		}
		System.out.print(sb);
	}

	static int find(int target) {
		if(target < 0) return -1;
		if (target >= drawer.length)
			return -1;
		if (drawer[target] == 0) {
			drawer[target] = target+1;
			return target+1;
		}
		return drawer[target] = find(drawer[target]);
	}

}
