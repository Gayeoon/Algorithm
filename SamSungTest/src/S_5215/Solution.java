package S_5215;

import java.util.Scanner;

public class Solution {
	 static int[] score;
	    static int[] kcal;
		public static void main(String args[]) throws Exception
		{
			Scanner sc = new Scanner(System.in);
			int T;
			T=sc.nextInt();
			StringBuilder sb = new StringBuilder();
	        
			for(int test_case = 1; test_case <= T; test_case++)
			{
				sb.append("#"+test_case+" ");
	            int n = sc.nextInt();
	            int l = sc.nextInt();
	            score = new int[n];
	            kcal = new int[n];
	            for(int i=0; i<n; i++){
	            	score[i] = sc.nextInt();
	                kcal[i] = sc.nextInt();
	            }
	            
	            sb.append(knapsack(0, l)+"\n");
			}
	        System.out.print(sb);
		}
	    
	    static int knapsack(int idx, int calorie){
	    	if(idx >= score.length)
	            return 0;
	        if(calorie - kcal[idx] < 0)
	            return knapsack(idx+1, calorie);
	        int result = Math.max(knapsack(idx+1, calorie), score[idx] + knapsack(idx+1, calorie-kcal[idx]));
	        return result;
	    }
	}