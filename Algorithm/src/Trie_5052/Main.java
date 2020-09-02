package Trie_5052;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int T = input.nextInt();

		StringBuilder sb = new StringBuilder();

		boolean flag = true;
		for (int t = 0; t < T; t++) {
			ArrayList<String> list = new ArrayList<>();
			flag = true;
			int n = input.nextInt();
			Trie tries = new Trie();

			for (int i = 0; i < n; i++) {
				String str = input.next();
				if (!flag)
					continue;
				if (tries.search(str.toCharArray(), list) > 0) {
					flag = false;
					break;
				}
				tries.insert(str.toCharArray());
				list.add(str);
			}
			if (flag)
				sb.append("YES\n");
			else
				sb.append("NO\n");
		}

		System.out.print(sb);
	}
}

// Trie Node
class Trie {

	int count;
	Trie[] childList;

	Trie() {
		childList = new Trie[10];
		count = 0;
	}

	void insert(char[] word) {
		Trie current = this;
		for (char no : word) {
			++current.count;
			if (current.childList[no - '0'] != null) {
				current = current.childList[no - '0'];
			} else {
				current.childList[no - '0'] = new Trie();
				current = current.childList[no - '0'];
			}
		}
	}

	int search(char[] query, ArrayList<String> list) {
		Trie current = this;
		String str = "";
		for (char no : query) {

			if (current.childList[no - '0'] != null) {
				str += no;
				current = current.childList[no - '0'];
			} else {
				if (list.contains(str))
					return 1;
				return 0;
			}
		}
		return current.count;
	}
}