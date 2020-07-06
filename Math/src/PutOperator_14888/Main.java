package PutOperator_14888;

import java.util.Scanner;

public class Main {
	static int[] operator = new int[4];
	static int[] num;
	static long min = 1000000001, max = -1000000001;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = input.nextInt();
		}

		for (int i = 0; i < 4; i++) {
			operator[i] = input.nextInt();
		}
		
		solve(n, 1, num[0], 0,0,0,0);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	static void solve(int n, int idx, int sum, int plus, int minus, int mul, int div) {
		if(idx >= n) {
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			return;
		}
		
		if(plus < operator[0]) {
			solve(n, idx+1, sum+num[idx], plus+1, minus, mul, div);
		}
		
		if(minus < operator[1]) {
			solve(n, idx+1, sum-num[idx], plus, minus+1, mul, div);
		}
		
		if(mul < operator[2]) {
			solve(n, idx+1, sum*num[idx], plus, minus, mul+1, div);
		}
		
		if(div < operator[3]) {
			solve(n, idx+1, sum/num[idx], plus, minus, mul, div+1);
		}
	}

}
