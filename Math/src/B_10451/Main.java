package B_10451;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	static boolean visit[];
	static boolean[][] num;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int N = input.nextInt();

		for(int n=0; n<N; n++) {
			int p = input.nextInt();
			
			num = new boolean[p+1][p+1];
			
			for(int i=1; i<=p; i++) {
				num[i][input.nextInt()] = true;
			}
			
			int cnt = 0;
			visit = new boolean[p+1];
			for(int i=1; i<=p; i++) {
				if(visit[i]) continue;
				solve(i);
				cnt++;
			}
			
			System.out.println(cnt);
		}
	}

	static void solve(int idx) {
		Stack<Integer> stack = new Stack<>();
		stack.push(idx);
		
		while(true) {
			if(stack.isEmpty()) break;
			
			int temp = stack.pop();
			visit[temp] = true;
			
			for(int i=1; i< num.length; i++) {
				if(!visit[i] && num[temp][i]) {
					stack.push(i);
					break;
				}
			}
		}
	}
}
