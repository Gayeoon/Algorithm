package Test3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated metHashSet<E>b
		HashMap<Integer, HashSet<Integer>> hash = new HashMap<>();
		HashMap<Integer, Integer> cnt = new HashMap<>();
		
		int[] score = {24,22,20,10,5,3,2,1};
		int k = 3;
		for(int i=1; i<score.length; i++) {
			int tmp = score[i] -score[i-1];
			if(hash.containsKey(tmp)) {
				HashSet<Integer> set = hash.get(tmp);
				set.add(i);
				set.add(i-1);
				hash.put(tmp, set);
				int count = cnt.get(tmp);
				cnt.put(tmp, count+1);
			}else{
				HashSet<Integer> set = new HashSet<>();
				set.add(i);
				set.add(i-1);
				hash.put(tmp, set);
				cnt.put(tmp, 1);
			}
		}
		
		boolean check[] = new boolean[score.length];
		
		for(int i : hash.keySet()) {
			if(cnt.get(i) >= k) {
				Iterator<Integer> it = hash.get(i).iterator();
				while(it.hasNext()) {
					check[it.next()] = true;
				}
			}
		}		
		
		for(int i=0; i<check.length; i++)
			if(!check[i])
				System.out.print(i+" ");
	}

}
