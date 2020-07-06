package FloydWarshall_Virus;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


// BSF로 풀엇음

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int t = input.nextInt();
		
		boolean[][] edge = new boolean [n+1][n+1];
		boolean[] visit = new boolean[n+1];
		
		for(int i=0; i<t; i++) {
			int v1 = input.nextInt();
			int v2 = input.nextInt();
			edge[v1][v2] = edge[v2][v1] = true;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(1);
		int count = -1;
		
		while(true) {
			if(queue.isEmpty()) break;
			
			int temp = queue.poll();
			if(visit[temp]) continue;
			visit[temp] =true;
			count++;
			
			for(int i=1; i<n+1; i++) {
				if(edge[temp][i] && !visit[i]) {
					queue.add(i);
				}
			}
		}
		
		System.out.println(count);
	}

}
