package Teaching_1062;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static LinkedList<String> word;
	static LinkedList<Character> candidate;
	static LinkedList<Character> learn;
	static int max = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		word = new LinkedList<>();
		candidate = new LinkedList<>();
		learn = new LinkedList<>();
		learn.add('a');
		learn.add('n');
		learn.add('t');
		learn.add('i');
		learn.add('c');
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			String temp = sc.next();
			if (temp.length() == 8) {
				cnt++;
				continue;
			}
			word.add(temp.substring(4, temp.length() - 4));
			for (int j = 0; j < word.getLast().length(); j++) {
				char tmp = word.getLast().charAt(j);
				if (candidate.contains(tmp) || learn.contains(tmp))
					continue;
				candidate.add(tmp);
			}
		}

		if (k < 5)
			System.out.println(0);
		else if(k - 5 >= candidate.size()) {
			cnt += word.size();
			System.out.println(cnt);
		}
		else {
			find(candidate.size(), k - 5, 0);
			cnt += max;
			System.out.println(cnt);
		}
	}

	static void find(int n, int k, int idx) {
		if (k == 0) {
			max = Math.max(max, check());
			return;
		} else if (idx >= candidate.size()) {
			return;
		} else {
			learn.add(candidate.get(idx));
			find(n, k - 1, idx + 1);
			learn.removeLast();
			find(n, k, idx + 1);
		}
	}

	static int check() {
		int cnt = 0;
		for (int i = 0; i < word.size(); i++) {
			String str = word.get(i);
			boolean flag = true;
			for (int j = 0; j < str.length(); j++) {
				if (learn.contains(str.charAt(j)))
					continue;
				else {
					flag = false;
					break;
				}
			}
			if (flag)
				cnt++;
		}
		return cnt;
	}
}
