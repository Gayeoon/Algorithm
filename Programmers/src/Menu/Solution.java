package Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };

		Arrays.sort(orders, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				int a_len = a.length();
				int b_len = b.length();
				if (a_len == b_len) {
					return a.compareTo(b);
				}

				else if (a_len > b_len)
					return -1;
				else
					return 1;
			}

		});

		int[] course = { 2, 3, 4 };

		Trie trie = new Trie();
		int max[] = new int[21];
		ArrayList<String> result[] = new ArrayList[21];

		for (int i = 0; i < orders.length; i++) {
			int tmp = trie.insert(orders[i].toCharArray());
			int len = orders[i].length();
			if(max[len] < tmp) {
				max[len] = tmp;
				result[len] = new ArrayList<>();
				result[len].add(orders[i]);
			}else if(max[len] == tmp) {
				result[len].add(orders[i]);
			}
		}
		
		ArrayList<String> ans = new ArrayList<>();
		for(int i=0; i<course.length; i++) {
			for(String str : result[course[i]])
				ans.add(str);
		}
		
		ans.sort(null);
		
		String answer[] = new String[ans.size()];
		
		for(int i=0; i<ans.size(); i++) {
			answer[i] = ans.get(i);
			System.out.println(answer[i]);
		}		
	}
}

class Trie {

	int count;
	Trie[] childList;

	Trie() {
		childList = new Trie[26];
		count = 0;
	}

	int insert(char[] word) {
		Trie current = this;
		for (char no : word) {
			++current.count;
			if (current.childList[no - 'A'] != null) {
				current = current.childList[no - 'A'];
			} else {
				current.childList[no - 'A'] = new Trie();
				current = current.childList[no - 'A'];
			}
		}
		return current.count + 1;
	}

	int search(char[] query, ArrayList<String> list) {
		Trie current = this;
		String str = "";
		for (char no : query) {

			if (current.childList[no - 'A'] != null) {
				str += no;
				current = current.childList[no - 'A'];
			} else {
				if (list.contains(str))
					return 1;
				return 0;
			}
		}
		return current.count;
	}
}