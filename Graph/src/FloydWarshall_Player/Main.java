package FloydWarshall_Player;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[][] results = { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } };

		int[][] arr = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(arr[i], Integer.MAX_VALUE);
			arr[i][i] = 0;
		}

		for (int i = 0; i < results.length; i++) {
			arr[results[i][0]][results[i][1]] = 1;
		}
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				if (i == k)
					continue;
				for (int j = 1; j <= n; j++) {
					if (i == j || j == k)
						continue;
					int result = arr[i][k] + arr[k][j] < 0 ? Integer.MAX_VALUE : arr[i][k] + arr[k][j];
					if (arr[i][j] > result)
						arr[i][j] = result;
				}
			}
		}
		
		boolean check[] = new boolean[n+1];
		int answer = n;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(check[j]) continue;
				if (arr[i][j] == Integer.MAX_VALUE) {
					if(arr[j][i] == Integer.MAX_VALUE) {
						check[j] = true;
						answer--;
					}
				}
			}
		}
		
		System.out.println(answer);
	}

}
