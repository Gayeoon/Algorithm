package Z;

import java.util.Scanner;

public class Main {
	static int[][] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int r = input.nextInt();
		int c = input.nextInt();
	
		System.out.println(solve(0,0, r, c, 0,N));
	}

	static int solve(int row, int col, int target_r, int target_c, int offset, int n) {		
		if(n == 1) {
			if(row == target_r) {
				if(col == target_c) return offset;
				else return offset+1;
			}else {
				if(col == target_c) return offset+2;
				else return offset+3;
			}
		} else {
			int end = (int)Math.pow(2, n) - 1;
			int r_mid = (row + row+end) / 2;
			int c_mid = (col + col+end) / 2;
			
			if(row <= target_r && target_r <= r_mid) {
				if(col <= target_c && target_c <= c_mid) {
					return solve(row, col, target_r, target_c, offset, n-1);
				} else {
					offset += (int)Math.pow((end+1)/2, 2);
					return solve(row, c_mid+1, target_r, target_c, offset, n-1);
				}
			}else {
				if(col <= target_c && target_c <= c_mid) {
					offset += (int)Math.pow((end+1)/2, 2)*2;
					return solve(r_mid+1, col, target_r, target_c, offset, n-1);
				} else {
					offset += (int)Math.pow((end+1)/2, 2)*3;
					return solve(r_mid+1, c_mid+1, target_r, target_c, offset, n-1);
				}				
			}
		}
	}
}
