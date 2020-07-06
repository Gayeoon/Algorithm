package Compression;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg = "THATTHATISISTHAT";
		HashMap<String, Integer> hash = new HashMap<>();
		List<Integer> ans = new ArrayList<>();
		String[] alpha = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
				"S", "T", "U", "V", "W",  "X", "Y", "Z" };
		for (int i = 0; i < 26; i++) {
			hash.put(alpha[i], i + 1);
		}
		int idx = 27;
		for (int i = 0; i < msg.length();) {
			String now = msg.charAt(i) + "";
			String wc = now;
			int index = i;
			while (true) {
				if (hash.containsKey(wc)) {
					index++;
					if(index == msg.length()) {
						ans.add(hash.get(wc));
						i = msg.length();
						break;
					}
					wc += msg.charAt(index);
					continue;
				} else {
					String temp = "";
					for (int k = i; k < index; k++)
						temp += msg.charAt(k);
					ans.add(hash.get(temp));
					hash.put(wc, idx);
					System.out.println(wc +" "+idx);
					idx++;
					i = index;
					break;
				}
			}
		}

		int[] answer = new int[ans.size()];
		for (int i = 0; i < ans.size(); i++) {
			answer[i] = ans.get(i);
			System.out.print(answer[i]+" ");
		}
	}
}