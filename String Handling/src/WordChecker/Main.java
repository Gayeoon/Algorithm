package WordChecker;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int count = 0;
		
		for(int i=0; i<n; i++) {
			if(solve(input.next())) count++;
		}
		
		System.out.println(count);
	}

	static boolean solve(String str) {
		HashMap<Character, Integer> hash = new HashMap<>();
		
		char prev = str.charAt(0);
		hash.put(prev, 0);
		
		for(int i=1; i<str.length(); i++) {
			if(prev != str.charAt(i)) {
				if(hash.containsKey(str.charAt(i))) return false;
				else {
					prev = str.charAt(i);
					hash.put(str.charAt(i), 0);
				}
			}
		}
		
		return true;
	}

}
