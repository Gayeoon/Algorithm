package TopologicalSort_2056;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] prev = new int[n+1];
		int[] time = new int[n+1];
		int[] result = new int[n+1];
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i=1; i<=n; i++) {
			int v = input.nextInt();
			int m = input.nextInt();
			time[i] = v;
			for(int j=0; j<m; j++) {
				list.get(input.nextInt()).add(i);
				prev[i]++;
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		int max = 0;
		
		for(int i=1; i<=n; i++) {
			if(prev[i] == 0) {
				queue.add(i);
				result[i] = time[i];
			}
		}
		
		while(true) {
			if(queue.isEmpty()) break;
			int tmp = queue.poll();

			max = Math.max(max, result[tmp]);
			
			for(int i : list.get(tmp)) {
				prev[i]--;
				if(prev[i] == 0) {
					queue.add(i);					
				}
				result[i] = Math.max(result[i], result[tmp] + time[i]);
			}
			
		}
		
		System.out.println(max);
	}

}
