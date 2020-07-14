package B_1012;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Cabbage{
	int row;
	int col;
	Cabbage(int r, int c){
		row = r;
		col = c;
	}
}
public class Main {
	static int N, M, K;
	static int[][] field;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();

		int[] answer = new int[test];

		for(int t=0; t<test; t++) {
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();

			field = new int[N][M];
			for(int i=0; i<K; i++) {
				int v1 = sc.nextInt();
				int v2 = sc.nextInt();
				field[v2][v1] = 1;
			}
			
			int count = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(field[i][j] == 1) {
						bfs(i, j);
						count++;
					}
				}
			}
			
			answer[t] = count;
		}
		
		for(int i=0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
	
	}
	
	static void bfs(int row, int col) {
		Queue<Cabbage> queue = new LinkedList<>();
		
		queue.add(new Cabbage(row, col));
		field[row][col] = -1;
		int[] Dr = {-1, 1, 0, 0};
		int[] Dc = {0, 0, -1, 1};

		while(true) {
			if(queue.isEmpty()) break;
			else {
				Cabbage temp = queue.poll();
				
				for(int i=0; i<4; i++) {
					int nr = temp.row + Dr[i];
					int nc = temp.col + Dc[i];
					
					if(nr < 0 || nr > N-1 || nc < 0 || nc > M-1) continue;
					if(field[nr][nc] == 1) {
						queue.add(new Cabbage(nr, nc));
						field[nr][nc] = -1;
					}
				}
			}
		}
	}

}