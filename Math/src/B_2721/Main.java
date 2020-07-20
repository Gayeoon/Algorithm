package B_2721;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			sb.append(solve(1, input.nextInt())+"\n");
		}
		
		System.out.print(sb);
	}
	
	static int solve(int num, int target) {
		if(num == target+1)
			return 0;
		
		int sum = 0;
		
		for(int i=1; i<=num+1; i++) {
			sum += i;
		}
		
		sum *= num;
		
		return sum + solve(num+1, target);
	}

}
