package S_1251;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Location implements Comparable<Location>{
	int x, y;
	long dist;

	Location(int x, int y, long dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}

	@Override
	public int compareTo(Location l) {
		if(this.dist < l.dist)
			return -1;
		else if(this.dist == l.dist)
			return 0;
		else
			return 1;
	}
}

public class Solution {
	static int[] xArr;
	static int[] yArr;
	static int[] parent;
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			xArr = new int[n];
			yArr = new int[n];
			parent = new int[n];
			
			for (int i = 0; i < n; i++) {
				xArr[i] = sc.nextInt();
			}
			for (int i = 0; i < n; i++) {
				yArr[i] = sc.nextInt();
			}
			
			ArrayList<Location> edge = new ArrayList<>();
		
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(i == j)
						continue;
					edge.add(new Location(i, j, dist(i, j)));
				}
			}
						
			double E = sc.nextDouble();
			edge.sort(null);
			Arrays.fill(parent, -1);
			
			int cnt = 0;
			long dist = 0;
			int idx = 0;
			while(true) {
				if(cnt == n-1)
					break;
				if(union(edge.get(idx).x, edge.get(idx).y)) {
					dist += edge.get(idx).dist;
					cnt++;
				}
				idx++;
			}
			sb.append("#" + test_case + " " + Math.round(dist * E) + "\n");
		}
		System.out.print(sb);
	}
	
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a == b)
			return false;
		parent[a] = b;
		return true;
	}
	
	static int find(int a) {
		if(parent[a] == -1)
			return parent[a] = a;
		if(parent[a] == a)
			return a;
		return parent[a] = find(parent[a]);
	}
	
	static long dist(int a, int b) {
		long x = Math.abs(xArr[a] - xArr[b]);
		long y = Math.abs(yArr[a] - yArr[b]);
		long result = x*x;
		result += y*y;
		return result;
	}
}