package B_6603;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static int num[];
	static LinkedList<String> list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		while(true) {
			int n = input.nextInt();
			if(n == 0) break;
			if(cnt != 0)
				sb.append("\n");
			num = new int[n];
			for(int i=0; i<n; i++) {
				num[i] = input.nextInt();
			}			
			list = new LinkedList<>();
			solve(0, n, "", 0);
			for(String str : list) {
				sb.append(str+"\n");
			}
			cnt++;
		}
		
		System.out.print(sb);
	}

	static void solve(int idx, int n, String str, int cnt) {
		if(idx >= n) {
			if(cnt == 6)
				list.add(str);
		}
		else {
			solve(idx+1, n, str+num[idx]+" ", cnt+1);
			solve(idx+1, n, str, cnt);
		}
	}
}
