package B_17144;

import java.util.Scanner;

class Point {
	int row, col;

	Point(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

public class Main {
	static int R, C;
	static int[][] room;
	static int[][] tmpRoom;
	static int[] Dr = { -1, 1, 0, 0 };
	static int[] Dc = { 0, 0, -1, 1 };
	static Point cleaner[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		R = input.nextInt();
		C = input.nextInt();
		int T = input.nextInt();

		room = new int[R][C];

		cleaner = new Point[2];
		int clean = 0;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				room[i][j] = input.nextInt();

				if (room[i][j] == -1) {
					cleaner[clean] = new Point(i, j);
					clean++;
				}
			}
		}
				
		for (int t = 0; t < T; t++) {

			tmpRoom = new int[R][C];

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {

					if (room[i][j] <= 0)
						continue;

					int dust = room[i][j] / 5;
					int temp = diffusion(dust, i, j);

					room[i][j] -= dust * temp;

					if (room[i][j] > 0) {
						tmpRoom[i][j] += room[i][j];
					}
				}
			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {

					if (room[i][j] < 0)
						continue;
					if(tmpRoom[i][j] == 0) continue;
					
					room[i][j] = tmpRoom[i][j];
				}
			}
			
			cleaning();
		}

		int cnt = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(room[i][j] <= 0) continue;
				cnt += room[i][j];
			}
		}
		
		System.out.println(cnt);

	}

	static int diffusion(int dust, int row, int col) {
		int cnt = 0;

		for (int i = 0; i < 4; i++) {
			int nr = row + Dr[i];
			int nc = col + Dc[i];

			if (nr < 0 || nr >= R || nc < 0 || nc >= C)
				continue;
			if (room[nr][nc] < 0)
				continue;

			tmpRoom[nr][nc] += dust;
			cnt++;
		}

		return cnt;
	}
	
	static void cleaning() {
		
		for(int i=cleaner[0].row-1; i >= 0; i--) {
			if(room[i+1][0] == -1) continue;
			room[i+1][0] = tmpRoom[i][0];
		}
		for(int i=cleaner[0].row; i > 0; i--) {
			room[i-1][C-1] = tmpRoom[i][C-1];
		}
		for(int j=0; j < C-1; j++) {
			room[cleaner[0].row][j+1] = tmpRoom[cleaner[0].row][j];
		}
		for(int j=C-1; j > 0 ; j--) {
			room[0][j-1] = tmpRoom[0][j];
		}
		
		for(int i=R-1; i > cleaner[1].row; i--) {
			if(room[i-1][0] == -1) continue;
			room[i-1][0] = tmpRoom[i][0];
		}
		for(int i=cleaner[1].row; i < R-1; i++) {
			room[i+1][C-1] = tmpRoom[i][C-1];
		}
		
		for(int j=0; j < C-1; j++) {
			room[cleaner[1].row][j+1] = tmpRoom[cleaner[1].row][j];
		}
		for(int j=C-1; j > 0 ; j--) {
			room[R-1][j-1] = tmpRoom[R-1][j];
		}

	}

}
