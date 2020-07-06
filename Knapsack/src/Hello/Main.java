package Hello;

import java.util.Scanner;

public class Main {
	static int health[], pleasure[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		health = new int[n];
		pleasure = new int[n];
		
		for (int i = 0; i < n; i++) {
			health[i] = input.nextInt();
		}
		for (int i = 0; i < n; i++) {
			pleasure[i] = input.nextInt();
		}
		
		System.out.println(knapsack(n-1, 100));
	}
	
	public static int knapsack(int idx, int hp) {
		if(idx < 0) return 0;
		else if(hp - health[idx] <= 0)
			return knapsack(idx-1, hp);
		else {
			int result = Math.max(knapsack(idx-1, hp), pleasure[idx] + knapsack(idx-1, hp - health[idx]));
			return result;
		}
	}

}
