package NHN_Test_3;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	static int[] candy;
	static boolean[] visit;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		String tmp = input.nextLine();
		String str[] = input.nextLine().split(" ");

		candy = new int[n];

		for (int i = 0; i < n; i++) {
			list.add(new ArrayList<>());
		}
		
		int cnt = 0;
		for (int i = 0; i < str.length; i++) {
			visit = new boolean[n];			
			int idx = cnt % n;
			switch (str[i]) {
			case "A":
				candy[idx]++;
				follower(idx);
				break;
			case "J":
				int left, right;
				if (idx - 1 < 0)
					left = n - 1;
				else 
					left = idx - 1;
				

				if (idx + 1 >= n) 
					right = 0;
				else 
					right = idx + 1;
				
				candy[left]++;
				candy[right]++;
				
				follower(left);
				follower(right);

				break;
			case "Q":
				for (int c = 0; c < n; c++)
					candy[c]++;
				break;
			case "K":
				i++;
				int temp = Integer.parseInt(str[i]);
				list.get(idx).add(temp);
				break;
			default:
				break;

			}
			cnt++;
		}
		
		for(int i=0; i<n; i++) {
			System.out.print(candy[i]+" ");
		}
	}

	static void follower(int idx) {
		for(int i : list.get(idx)) {
			if(visit[i])
				continue;
			visit[i] = true;
			candy[i]++;
			follower(i);
		}
	}
}
