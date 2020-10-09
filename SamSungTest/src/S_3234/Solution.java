package S_3234;

import java.util.Scanner;

public class Solution {
	static int arr[];
	static int cnt = 0;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		StringBuffer sb = new StringBuffer();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			arr = new int[N];
			cnt = 0;
			for(int i=0; i<N; i++)
				arr[i] = sc.nextInt();
			
			solve(0,N,0,0);
			sb.append("#"+test_case+" "+cnt+"\n");
		}
		System.out.print(sb);
	}
	
	static void solve(int depth, int N, int left, int right) {
		if(depth == N) {
			cnt++;
			return;
		}
		for(int i=depth; i<N; i++) {
			swap(depth, i);
			solve(depth+1, N, left+arr[depth], right);
			if(left >= right + arr[depth])
				solve(depth+1, N, left, right+arr[depth]);
			swap(depth, i);
		}
	}
	
	static void swap(int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}