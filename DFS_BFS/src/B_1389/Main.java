package B_1389;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static boolean user[][];
		static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		int m = sc.nextInt();
		
		user = new boolean[n][n];
		
		for(int i=0; i<m; i++) {
			int temp1 = sc.nextInt();
			int temp2 = sc.nextInt();
			
			user[temp1-1][temp2-1] = true;
			user[temp2-1][temp1-1] = true;
			
		}
		int min = Integer.MAX_VALUE;
		int min_idx = -1;
		for(int i=0; i<n; i++) {
			int temp = solve(i);
			if(min > temp) {
				min = temp;
				min_idx = i;
			}
		}
		System.out.println(min_idx+1);
	}
	
	static int solve(int u) {
		int result[] = new int[n];
		boolean visited[] = new boolean[n];
		Arrays.fill(result, 0);
		Arrays.fill(visited, false);
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(u);
		visited[u] = true;
		
		
		while(true) {
			if(queue.isEmpty())
				break;
			else {
				u = queue.poll();
				for(int i=0; i<result.length; i++) {
					if(user[u][i] == true && visited[i] == false) {
						queue.add(i);
						result[i] = result[u] + 1;
						visited[i] = true;
					}
				}
				
			}
		}
		int sum=0;
		for(int i=0; i<result.length; i++) {
			sum += result[i];
		}
		return sum;
	}
}
