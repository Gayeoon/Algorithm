package B_1697;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int k = input.nextInt();
		
		int dist[] = new int[100002];
		boolean visit[] = new boolean[100002];
		int min = Integer.MAX_VALUE;
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(n);
		
		while(true) {
			if(queue.isEmpty()) break;
			
			int tmp = queue.poll();
			if(tmp == k) {
				min = Math.min(min, dist[tmp]);
				break;
			}
			
			if(tmp+1 <= 100000 && !visit[tmp+1]) {
				visit[tmp+1] = true;
				queue.add(tmp+1);
				dist[tmp+1] = dist[tmp]+1;
			}
			
			if(tmp*2 <= 100000 && !visit[tmp*2]) {
				visit[tmp*2] = true;
				queue.add(tmp*2);
				dist[tmp*2] = dist[tmp]+1;
			}

			if(tmp-1 >= 0 && !visit[tmp-1]) {
				visit[tmp-1] = true;
				queue.add(tmp-1);
				dist[tmp-1] = dist[tmp]+1;
			}

		}
		
		System.out.println(min);
	}
}
