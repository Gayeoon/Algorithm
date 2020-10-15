package SW_17143;

import java.util.Scanner;

class Shark {
	int row, col, speed, dir, size;
	boolean isLive;

	Shark(int row, int col, int speed, int dir, int size) {
		this.row = row;
		this.col = col;
		this.speed = speed;
		this.dir = dir;
		this.size = size;
		this.isLive = true;
	}
}

public class Main {
	static Shark shark[];
	static int n, m;
	static int[] Dr = { 0, -1, 1, 0 };
	static int[] Dc = { -1, 0, 0, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();
		int s = input.nextInt();

		int arr[][] = new int[n][m];
		shark = new Shark[s + 1];

		for (int i = 1; i <= s; i++) {
			int r = input.nextInt() - 1;
			int c = input.nextInt() - 1;
			int speed = input.nextInt();
			int d = input.nextInt();
			int z = input.nextInt();
			

			shark[i] = new Shark(r, c, speed, (d%4), z);
			arr[r][c] = i;
		}

		System.out.println(solve(0, 0, arr));

	}

	static int solve(int idx, int sum, int[][] arr) {
		if (idx >= m) {
			return sum;
		}

		int map[][] = new int[n][m];

		for (int i = 0; i < n; i++) {
			if (arr[i][idx] != 0) {
				sum += shark[arr[i][idx]].size;
				shark[arr[i][idx]].isLive = false;
				map[i][idx] = 0;
				break;
			}
		}

		for(int i=1; i<shark.length; i++) {
			if(!shark[i].isLive)
				continue;
			int nr = shark[i].row + (shark[i].speed * Dr[shark[i].dir]);
			int nc = shark[i].col + (shark[i].speed * Dc[shark[i].dir]);
			
			if(nr < 0) {
				nr *= -1;
				shark[i].dir = 2;
			}
			
			if(nr >= n) {
				int tmp = nr / (n-1);
				if(tmp % 2 == 0) {
					nr = nr % (n-1);
					shark[i].dir = 2;
				}
				else {
					nr = n - (nr%(n-1))-1;
					shark[i].dir = 1;
				}
			}
			
			if(nc < 0) {
				nc *= -1;
				shark[i].dir = 3;
			}
			
			if(nc >= m) {
				int tmp = nc / (m-1);
				if(tmp % 2 == 0) {
					nc = nc % (m-1);
					shark[i].dir = 3;
				}
				else {
					nc = m - (nc%(m-1))-1;
					shark[i].dir = 0;
				}
			}
			
			if(map[nr][nc] != 0) {
				if(shark[map[nr][nc]].size < shark[i].size) {
					shark[map[nr][nc]].isLive = false;
					map[nr][nc] = i;
					shark[i].row = nr;
					shark[i].col = nc;
				}else {
					shark[i].isLive = false;
				}
			}else {
				map[nr][nc] = i;
				shark[i].row = nr;
				shark[i].col = nc;
			}
		}
		
		return solve(idx + 1, sum, map);
	}
}
