package MostWord_1371;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int[] alpha = new int[26];
		HashMap<Character, Integer> hash = new HashMap<>();
	
		while (input.hasNextLine()) {
			String str = input.nextLine();
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i) == ' ') continue;
				alpha[str.charAt(i) - 'a']++;
			}
		}

		for (char a = 'a'; a <= 'z'; a++) {
			if(alpha[a - 'a'] != 0)	
				hash.put(a, alpha[a - 'a']);
		}
		
		ArrayList<Character> key = new ArrayList<>(hash.keySet());
		Collections.sort(key, new Comparator<Character>() {

			@Override
			public int compare(Character a, Character b) {
				if(hash.get(a) > hash.get(b))
					return -1;
				else if(hash.get(a) == hash.get(b)) {
					return a.compareTo(b);
				}else
					return 1;
			}
			
		});
		
		int prev = 0;
		for(char tmp : key) {
			if(hash.get(tmp) >= prev) {
				System.out.print(tmp);
				prev = hash.get(tmp);
			}else
				break;
		}
	}

}
