package FloydWarshall;

import java.util.Arrays;
import java.util.Scanner;

// FloydWarshall
// 모든 정점에서 모든 정점으로 가는 최단 거리

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();

		int[][] cost = new int[n + 1][n + 1];

		for (int i = 0; i < n + 1; i++) {
			Arrays.fill(cost[i], Integer.MAX_VALUE);
			cost[i][i] = 0;
		}

		for (int i = 0; i < m; i++) {
			int v1 = input.nextInt();
			int v2 = input.nextInt();
			int val = input.nextInt();

			cost[v1][v2] = Math.min(cost[v1][v2], val);
		}

		for (int k = 1; k < n + 1; k++) {
			for (int i = 1; i < n + 1; i++) {
				if(i == k) continue;
				for (int j = 1; j < n + 1; j++) {
					if(i == j || j == k) continue;
					int result = cost[i][k] + cost[k][j] < 0 ? Integer.MAX_VALUE : cost[i][k] + cost[k][j];					
					cost[i][j] = Math.min(cost[i][j], result);
				}

			}

		}
		
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					if(cost[i][j] == Integer.MAX_VALUE) System.out.print(0 +" ");
					else System.out.print(cost[i][j]+" ");
					}
				System.out.println();

			}

		
	}

}
