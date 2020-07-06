package RGB;

import java.util.Scanner;

public class Main {
	static int house[][];
	static int money[][];
	static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		
		house = new int[n][3];
		money = new int[n][3];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<3; j++) {
				money[i][j] = input.nextInt();
			}
		}
		
		int result = solve(0, -1);
		System.out.println(result);
		
	}
	
	static int solve(int idx, int pre){
		if(idx == n) return 0;
		
		for(int i=0; i<3; i++) {			
			if(pre == i) continue;
			if(house[idx][i] != 0) continue;
			house[idx][i] = money[idx][i] + solve(idx+1, i);
			
		}
		
		switch(pre){
			case 0: return Math.min(house[idx][1], house[idx][2]);
			case 1: return Math.min(house[idx][0], house[idx][2]);
			case 2: return Math.min(house[idx][0], house[idx][1]);
			default : 
				int min = Math.min(house[idx][0], house[idx][1]);
				min = Math.min(min, house[idx][2]);
				return min;
		}
	}

}
