package B_1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static boolean graph[][];
	static boolean visit[];
	
	static int n = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = "";
		try {
			s = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringTokenizer st = new StringTokenizer(s, " ");
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		graph = new boolean[n][n];
		visit = new boolean[n];
		
		for(int i=0; i<n; i++) {
			Arrays.fill(graph[i], false);			
		}
		Arrays.fill(visit, false);
		
		for(int i=0; i<m; i++) {
			s = "";
			try {
				s = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			StringTokenizer token = new StringTokenizer(s, " ");
			int m1 = Integer.parseInt(token.nextToken())-1;
			int m2 = Integer.parseInt(token.nextToken())-1;
			
			graph[m1][m2] = graph[m2][m1] = true;
		
		}
		
		dfs(v-1);
		System.out.println();
		Arrays.fill(visit, false);
		bfs(v-1);
		
	}
	
	static void dfs(int v) {
		if(!visit[v]) {
			visit[v] = true;
			System.out.print((v+1)+" ");
		}
		
		for(int i=0; i<n; i++) {
			if(!visit[i] && graph[v][i]) {
				dfs(i);
			}
		}
	}
	
	static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visit[v] = true;
		queue.offer(v);
		System.out.print((v+1)+" ");
		
		while(true) {
			if (!queue.isEmpty()) {
				v = queue.poll();
				if(!visit[v]) {
					visit[v] = true;
					System.out.print((v+1)+" ");
				}
			}else {
				break;
			}
			for(int i=0; i<n; i++) {
				if(!visit[i] && graph[v][i]) {
					queue.offer(i);
				}
			}
			
		}

	}
}