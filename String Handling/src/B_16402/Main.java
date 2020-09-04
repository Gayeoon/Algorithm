package B_16402;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Sort implements Comparable<Sort>{
	int idx;
	String key;
	Sort(String key, int idx){
		this.key = key;
		this.idx = idx;
	}
	@Override
	public int compareTo(Sort s) {
		return this.key.compareTo(s.key);
	}
}

public class Main {
	static int kingdom[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int K = input.nextInt();
		int Q = input.nextInt();
		
		kingdom = new int[K];
		
		HashMap<String, Integer> hash = new HashMap<>();
		ArrayList<Sort> list = new ArrayList<>();
		input.nextLine();
		
		for(int i=0; i<K; i++) {
			String tmp = input.nextLine();
			String[] str = tmp.split(" ");
			hash.put(str[2], i);
			list.add(new Sort(str[2], i));
			kingdom[i] = i;
		}
		
		
		for(int i=0; i<Q; i++) {
			String tmp[] = input.nextLine().split(",");
			String str1[] = tmp[0].split(" ");
			String str2[] = tmp[1].split(" ");
			int win, lose;
			if(tmp[2].equals("1")) {
				win = hash.get(str1[2]);
				lose = hash.get(str2[2]);
			}
			else{
				win = hash.get(str2[2]);
				lose = hash.get(str1[2]);
			}

			if(kingdom[win] == lose)
				kingdom[win] = lose;
			
			if(kingdom[win] != win && kingdom[win] != lose)
				win = kingdom[win];
			if(kingdom[lose] != lose && kingdom[lose] != kingdom[win])
				lose = kingdom[lose];


			kingdom[lose] = win;
			
			for(int k=0; k<K; k++) {
				if(kingdom[k] == lose)
					kingdom[k]= win;
			}
		}
		
		list.sort(null);
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for(int i=0; i<K; i++) {
			if(kingdom[list.get(i).idx] == list.get(i).idx) {
				cnt++;
				sb.append("Kingdom of "+list.get(i).key+"\n");
			}
		}
		
		System.out.println(cnt);
		System.out.print(sb);
	}
}

