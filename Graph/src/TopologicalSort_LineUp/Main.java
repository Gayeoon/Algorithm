package TopologicalSort_LineUp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 위상 정렬

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		
		int prev[] = new int[n+1];
		Arrays.fill(prev, 0);
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		
		for(int i=0; i<n+1; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<m; i++) {
			int first = input.nextInt();
			int second = input.nextInt();
			list.get(first).add(second);
	
			prev[second]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1; i<n+1; i++) {
			if(prev[i] == 0) queue.add(i);
		}
		
		while(true) {
			if(queue.isEmpty()) break;
			
			int temp = queue.poll();
			
			for(int t : list.get(temp)) {
				prev[t]--;
				if(prev[t] == 0) {
					queue.add(t);
				}
			}
			
			System.out.print(temp+" ");
		}
	}

}
