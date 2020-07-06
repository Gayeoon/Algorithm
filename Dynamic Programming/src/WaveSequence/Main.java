package WaveSequence;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static long p[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int question[] = new int[n];
		
		p = new long[101];
		Arrays.fill(p, 0);
		
		p[1] = p[2] = p[3] = 1;
		p[4] = p[5] = 2;

		for(int i=0; i<n; i++) {
			question[i] = input.nextInt();
		}
		
		for(int i=0; i<n; i++) {
			System.out.println(solve(question[i]));
		}

	}
	
	static long solve(int n) {
		if(p[n] != 0) return p[n];
		
		p[n] = solve(n-1) + solve(n-5);
		return p[n];
	}
}
