package Mingun_Passward;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		HashMap<String, Integer> hash = new HashMap<>();

		for(int i=0; i<n; i++) {
			String temp = input.next();
			hash.put(temp, temp.length());
			String reverse = new StringBuilder(temp).reverse().toString();
			if(hash.containsKey(reverse)) {
				System.out.println(hash.get(reverse)+" "+ temp.charAt(hash.get(reverse)/2));
				break;
			}				
		}
	}

}
