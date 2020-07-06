package Alphabet_10808;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Character, Integer> hash = new HashMap<>();
		for (char a = 'a'; a <= 'z'; a++) {
			hash.put(a, 0);
		}
		
		Scanner input = new Scanner(System.in);
		String str = input.next();
		
		for(int i=0; i<str.length(); i++) {
			int tmp = hash.get(str.charAt(i));
			hash.put(str.charAt(i), tmp+1);
		}
		
		Iterator<Character> it = hash.keySet().iterator();
		
		while(it.hasNext()) {
			System.out.print(hash.get(it.next())+" ");
		}
		
	}

}
