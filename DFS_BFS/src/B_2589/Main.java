package B_2589;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Island{
	int row;
	int col;
	int dist;
	
	Island(int r, int c, int d){
		row = r;
		col = c;
		dist = d;
	}
}
public class Main {
	static char[][] treasure;
	static int n, m;
	static boolean visit[][];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int max = Integer.MIN_VALUE;
		
		treasure = new char[n][m];

		for (int i = 0; i < n; i++) {
			String temp = sc.next();
			for (int j = 0; j < m; j++) {
				treasure[i][j] = temp.charAt(j);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(treasure[i][j] == 'L') {
					visit = new boolean[n][m];
					max = Math.max(max, bfs(i, j));
				}
			}
		}
		if(max == Integer.MIN_VALUE) System.out.println(0);
		else System.out.println(max);

	}

	static int bfs(int row, int col) {
		Queue<Island> queue = new LinkedList<>();
		queue.add(new Island(row, col, 0));
		int[] Dr = {-1, 1, 0, 0};
		int[] Dc = {0, 0, -1, 1};
		int max = Integer.MIN_VALUE;

		visit[row][col] = true;
		
		while(true) {
			if(queue.isEmpty()) break;
			else {
				Island temp = queue.poll();
				
				for(int i=0; i<4; i++) {
					int nr = temp.row + Dr[i];
					int nc = temp.col + Dc[i];
					
					if(nr < 0 || nr > n-1 || nc < 0 || nc > m-1) continue; 
					if(treasure[nr][nc] == 'L' && !visit[nr][nc]) {
						queue.add(new Island(nr, nc, temp.dist+1));
						max = Math.max(max, temp.dist+1);
						visit[nr][nc] = true;
					}
				}
			}
		}
		return max;
	}
}
