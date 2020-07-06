package BestSeller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

// Hash 정렬
// Value 내림차순 -> Key 오름차순

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		HashMap<String, Integer> hash = new HashMap<>();
		
		for(int i=0; i<n; i++) {
			String temp = input.next();
			if(hash.containsKey(temp)) {
				int num = hash.get(temp);
				hash.put(temp, num+1);
			}
			else
				hash.put(temp, 1);
		}
		
		List<String> keySetList = new ArrayList<>(hash.keySet());
		// 내림차순 //
		Collections.sort(keySetList, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(hash.get(o1) < hash.get(o2))
					return 1;
				else if(hash.get(o1) == hash.get(o2))
					return o1.compareTo(o2);
				else
					return -1;
			}
		});
		
		System.out.println(keySetList.get(0));
	}

}
