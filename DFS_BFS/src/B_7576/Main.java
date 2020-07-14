package B_7576;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Ripe {
	int row;
	int col;

	Ripe(int r, int c) {
		row = r;
		col = c;
	}
}

public class Main {
	static int M, N;
	static int tomato[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		int count = 0;
		int total = M * N;
		int day = 0;
		int[] Dr = { -1, 1, 0, 0 };
		int[] Dc = { 0, 0, -1, 1 };
		tomato = new int[N][M];

		Queue<Ripe> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tomato[i][j] = sc.nextInt();
				if (tomato[i][j] == 1) {
					queue.add(new Ripe(i, j));
					count++;
				} else if (tomato[i][j] == -1) {
					total--;
				}
			}
		}

		while (true) {
			if (count == total) {
				System.out.println(day);
				break;
			}
			day++;

			int size = queue.size();
			boolean flag = false;
			
			for (int i = 0; i < size; i++) {
				Ripe temp = queue.poll();
				for(int k=0; k<4; k++) {
					int nr = temp.row + Dr[k];
					int nc = temp.col + Dc[k];
					if(nr < 0 || nr > N-1 || nc <0 || nc > M-1) continue;
					if(tomato[nr][nc] == 0) {
						tomato[nr][nc] = 1;
						queue.add(new Ripe(nr, nc));
						count++;
						flag = true;						
					}
				}
			}
			if(!flag) {
				System.out.println(-1);
				break;
			}
		}
	}

}
