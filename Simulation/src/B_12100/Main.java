package B_12100;

import java.util.Scanner;

class Board {
	int map[][] = new int[20][20];
	
	void rotate(int n) {
		int temp[][] = new int[20][20];
		
		for(int y=0; y <n; y++) {
			for(int x=0; x<n; x++) {
				temp[y][x] = map[n-x-1][y];
			}
		}
		
		for(int x=0; x<n; x++) {
			for(int y=0; y<n; y++) {
				map[x][y] = temp[x][y];
			}
		}
	}
	
	int getMax(int n) {
		int result = 0;
		for(int x=0; x<n; x++) {
			for(int y=0; y<n; y++) {
				result = Math.max(result, map[x][y]);
			}
		}
		
		return result;
	}
	
	void up(int n) {
		int temp[][] = new int[20][20];
		
		for(int j=0; j<n; j++) {
			boolean flag = false;
			int target = -1;
			for(int i=0; i<n; i++) {
				if(map[i][j] == 0)
					continue;
				if(flag && map[i][j] == temp[target][j]) {
					temp[target][j] *= 2;
					flag = false;
				}else {
					temp[++target][j] = map[i][j];
					flag = true;
				}
			}
		}
		
		for(int x=0; x<n; x++) {
			for(int y=0; y<n; y++) {
				map[x][y] = temp[x][y];
			}
		}		
	}
}

public class Main {
	static int max = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		Board board = new Board();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				board.map[i][j] = input.nextInt();
			}
		}
		
		dfs(board, 0, n);
		System.out.println(max);
		
	}

	static void dfs(Board now, int cnt, int n) {
		if(cnt == 5) {
			int result = now.getMax(n);
			max = Math.max(result, max);
			return;
		}
		
		for(int i=0; i<4; i++) {
			Board tmp = new Board();
			
			for(int x=0; x<n; x++) {
				for(int y=0; y<n; y++) {
					tmp.map[x][y] = now.map[x][y];
				}
			}
			
			tmp.up(n);
			
			dfs(tmp, cnt+1, n);
			now.rotate(n);	
		}
	}
}