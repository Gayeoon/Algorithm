package B_15652;

import java.util.Scanner;

public class Main {
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m =input.nextInt();
		
		solve(0, 1, n, m, "");
		System.out.print(sb);
	}
	
	static void solve(int depth, int idx, int n, int m, String str) {
		if(depth >= m) {
			sb.append(str+"\n");
			return;
		}
		for(int i=idx; i<=n; i++) {
			solve(depth+1, i, n, m, str+i+" ");
		}
	}

}
