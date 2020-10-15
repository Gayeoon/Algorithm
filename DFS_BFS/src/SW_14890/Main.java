package SW_14890;

import java.util.Scanner;

public class Main {
	static int arr[][];
	static int n, l;
	static int Dr[] = {0, 1};
	static int Dc[] = {1, 0};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		n= input.nextInt();
		l = input.nextInt();
		
		arr = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n;j++) {
				arr[i][j] = input.nextInt();
			}
		}
		
		int cnt = 0;
		for(int i=0; i<n; i++) {
			if(solve(i, 0, 0)) {
				cnt++;
			}
			if(solve(0, i, 1)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	static boolean solve(int row, int col, int dir) {
		int flag = 0;

		int prev = arr[row][col];
		int cnt = 1;
		
		for (int i = 1; i < n; i++) {
			row += Dr[dir];
			col += Dc[dir];
			
			if (prev == arr[row][col]) {
				cnt++;
				continue;
			}
			// 올라가는 경우
			else if (prev + 1 == arr[row][col]) {
				if (flag == 0) {
					if (cnt >= l) {
						prev++;
						cnt = 1;
						continue;
					} else 
						return false;
					
				} else {
					if(cnt >= 2*l) {
						prev++;
						cnt = 1;
						flag = 0;
						continue;
					}
					return false;
				}
			}
			// 내려가는 경우
			else if (prev - 1 == arr[row][col]) {
				if (flag == 0) {
					flag = 1;
					cnt = 1;
					prev--;
					continue;
				}else if(flag == 1) {
					if(cnt >= l) {
						cnt = 1;
						prev--;
						continue;
					}else
						return false;
				}
			}
			else
				return false;
		}
		
		if(flag == 1) {
			if(cnt >= l)
				return true;
			else
				return false;
		}
		return true;
	}
}
