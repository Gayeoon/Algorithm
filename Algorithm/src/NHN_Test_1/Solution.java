package NHN_Test_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		HashMap<String, Integer> hash = new HashMap<>();
		int[] card = new int[n];
		Arrays.fill(card, Integer.MAX_VALUE);

		int idx = 0;
		for (int i = 0; i < n; i++) {
			String str = input.next();
			if (hash.containsKey(str)) {
				card[hash.get(str)]++;
			} else {
				hash.put(str, idx);
				card[idx] = 1;
				idx++;
			}
		}

		Arrays.sort(card);
		if (card[1] - card[0] == 1) {
			if (check(card, 1, n))
				System.out.println("Y" + "\n" + (n + 1) + "\n" + hash.size());
			else
				System.out.println("N" + "\n" + n + "\n" + hash.size());
		} else {
			if (check(card, 0, n))
				System.out.println("Y" + "\n" + n + "\n" + hash.size());
			else
				System.out.println("N" + "\n" + n + "\n" + hash.size());
		}
	}

	static boolean check(int card[], int start, int end) {
		int pre = card[start];
		
		for(int i=start+1; i<end; i++) {
			if(card[i] == Integer.MAX_VALUE)
				break;
			if(pre != card[i])
				return false;
		}
		return true;
	}
}
