package TopologicalSort_Game;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		int[] time = new int[n + 1];
		int[] degree = new int[n + 1];
		int[] result = new int[n+1];
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int i = 1; i < n + 1; i++) {
			int temp = input.nextInt();
			time[i] = temp;

			while (true) {
				temp = input.nextInt();
				if (temp == -1)
					break;
				graph.get(temp).add(i);
				degree[i]++;
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1; i<n+1; i++) {
			if(degree[i] == 0) {
				queue.add(i);
				result[i] = time[i];
			}
		}
		
		while(true) {
			if(queue.isEmpty()) break;
			
			int num = queue.poll();
			
			for (int nextV : graph.get(num)) {
			    degree[nextV]--;
			    result[nextV] = Math.max(result[nextV], result[num]);
			    
			    if(degree[nextV] == 0) {
				    result[nextV] += time[nextV];
				    queue.add(nextV);			    	
			    }
			}
		}
		
		for(int i=1; i<n+1; i++) {
			System.out.println(result[i]);
		}
	}

}


