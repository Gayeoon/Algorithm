package WordMath_1339;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		String[] result = new String[n];
		int[] overlap = new int[30];
		List<Character> alpha = new ArrayList<Character>();
		
		for(char a = 'A'; a <= 'Z'; a++) {
			alpha.add(a);
		}
		
		HashMap<Character, Integer> hash = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String str = input.next();
			for (int j = 0; j < str.length(); j++) {
				char tmp = str.charAt(j);
				int val = str.length() - j;
				if (hash.containsKey(tmp)) {
					int temp = hash.get(tmp);
					hash.put(tmp, Math.max(temp, val));
					overlap[alpha.indexOf(tmp)]++;
					
				} else {
					hash.put(tmp, val);
				}
			}
			result[i] = str;
		}

		List<Character> ks = new ArrayList<Character>(hash.keySet());

		Collections.sort(ks, new Comparator<Character>(){
			@Override
			public int compare(Character a, Character b) {
				if(hash.get(a) > hash.get(b))
					return -1;
				else if(hash.get(a) == hash.get(b)) {
					if(overlap[alpha.indexOf(a)] > overlap[alpha.indexOf(b)])
						return -1;
					else return 1;
				}
				else return 1;
			}

		});

		HashMap<Character, Integer> word = new HashMap<>();
		int idx = 9;
		for (char key : ks) {
			System.out.println(key+"  "+idx);
			word.put(key, idx);
			idx--;
		}
		
		int sum = 0;
		System.out.println(overlap[0]+" "+overlap[1]+" "+overlap[2]+" ");
		for (int i = 0; i < n; i++) {
			String str = result[i];
			String tmp = "";
			for (int j = 0; j < str.length(); j++) {
				tmp += word.get(str.charAt(j));
			}
			System.out.println(tmp);
			sum += Integer.parseInt(tmp);
		}
		
		System.out.println(sum);
	}

}
