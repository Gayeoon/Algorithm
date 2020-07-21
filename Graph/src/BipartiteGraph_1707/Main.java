package BipartiteGraph_1707;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<ArrayList<Integer>> list;
	static int color[];
	static boolean flag = true;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<n; t++) {
			list = new ArrayList<>();
			
			int v = input.nextInt();
			int e = input.nextInt();

			color = new int[v+1];
			
			for(int i=0; i<=v; i++)
				list.add(new ArrayList<Integer>());
			
			for(int i=0; i<e; i++) {
				int a = input.nextInt();
				int b = input.nextInt();
				list.get(a).add(b);
				list.get(b).add(a);
			}
			flag = true;
			for(int i=1; i<=v; i++) {
				if(color[i] == 0)
					solve(i, 1);
				if(!flag)
					break;
			}
			
			if(flag)
				sb.append("YES\n");
			else
				sb.append("NO\n");
		}
		
		System.out.print(sb);
	}

	static void solve(int idx, int c) {
		color[idx] = c;
		for(int i : list.get(idx)) {
			if(color[i] == c) {
				flag = false;
				return;
			}
			else if(color[i] == 0){
				color[i] = -c;
				solve(i, -c);
			}
		}
	}
}
