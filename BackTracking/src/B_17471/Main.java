package B_17471;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int arr[];
	static boolean visit[];
	static int min = Integer.MAX_VALUE;
	static int n;
	static int ok[];
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		n = input.nextInt();
		arr = new int[n+1];
		ok = new int[n+1];
		visit = new boolean[n+1];
		
		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i=1; i<=n; i++) {
			arr[i] = input.nextInt();
		}
		
		for(int i=1; i<=n; i++) {
			int k = input.nextInt();
			for(int j=0; j<k; j++) {
				list.get(i).add(input.nextInt());
			}
		}
		
		solve(1, 1);
		
		if(min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}
	
	static void solve(int now, int cnt) {		
		for(int i=now; i<=n; i++) {
			visit[i] = true;
			ok[i] = 1;
			int a = check(cnt, 1);
			int b = check(n-cnt, 0);
			if(a != -1 && b != -1)
				min = Math.min(min, Math.abs(a - b));
			solve(i+1, cnt+1);
			ok[i] = 0;
			visit[i] = false;
		}
	}
	
	static int check(int cnt, int flag) {
		if(cnt == 1) {
			for(int i=1; i<=n; i++) {
				if(ok[i] == flag)
					return arr[i];
			}
		}
		
		if(cnt == n || cnt == 0)
			return -1;
			
		boolean tmpvisit[] = new boolean[n+1];
		
		Queue<Integer> queue = new LinkedList<>();
		int sum = 0;

		for(int i=1; i<=n; i++) {
			if(ok[i] == flag) {
				tmpvisit[i] = true;
				queue.add(i);
				cnt--;
				sum += arr[i];
				break;
			}
		}
		
		while(true) {
			if(queue.isEmpty()) break;
			
			int tmp = queue.poll();
			
			for(int i : list.get(tmp)) {
				if(tmpvisit[i]) continue;
				if(ok[i] != flag) continue;
				tmpvisit[i] = true;
				queue.add(i);
				cnt--;
				sum += arr[i];
			}
		}
		
		if(cnt != 0)
			return -1;
		return sum;
		
	}

}
