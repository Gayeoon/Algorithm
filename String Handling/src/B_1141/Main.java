package B_1141;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		Trie tries = new Trie();
		
		LinkedList<String> list = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			list.add(input.next());
		}
		
		list.sort(new Comparator<String>(){
			@Override
			public int compare(String a, String b) {
				if(a.length() > b.length())
					return -1;
				else if(a.length() == b.length())
					return a.compareTo(b);
				else
					return 1;
			}
		});
		
		int cnt = 0;
		for(int i=0; i<list.size(); i++) {
			if(tries.search(list.get(i).toCharArray()) == 0) {
				tries.insert(list.get(i).toCharArray());
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}

//Trie Node
class Trie {

	int count;
	Trie[] childList;

	Trie() {
		childList = new Trie[26];
		count = 0;
	}

	void insert(char[] word) {
		Trie current = this;
		for (char no : word) {
			++current.count;
			if (current.childList[no - 'a'] != null) {
				current = current.childList[no - 'a'];
			} else {
				current.childList[no - 'a'] = new Trie();
				current = current.childList[no - 'a'];
			}
		}
	}

	int search(char[] query) {
		Trie current = this;
		int cnt = 0;
		for (char no : query) {
			if (current.childList[no - 'a'] != null) {
				current = current.childList[no - 'a'];
				cnt++;
			} else {
				return 0;
			}
		}
		return cnt;
	}

}