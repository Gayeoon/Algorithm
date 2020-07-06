package HearSee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		
		HashMap<String, Integer> hash = new HashMap<>();
		
		for(int i=0; i<n; i++) {
			hash.put(input.next(), 1);
		}

		List<String> result = new ArrayList<>();
		for(int i=0; i<m; i++) {
			String temp = input.next();
			if(hash.containsKey(temp)) {
				result.add(temp);
			}
		}
		
		Collections.sort(result);
		
		System.out.println(result.size());
		
		for(String str : result) {
			System.out.println(str);
		}
	}

}
