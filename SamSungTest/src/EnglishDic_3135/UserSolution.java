package EnglishDic_3135;

public class UserSolution {
	public static Trie tries;

	public void init() {
		tries = new Trie();
	}

	public void insert(int buffer_size, String buf) {
		tries.insert((buf+"{").toCharArray());
	}

	public int query(int buffer_size, String buf) {
		return tries.search(buf.toCharArray());
	}
}

class Trie {
	int count;
	Trie[] childList;

	Trie() {
		childList = new Trie[27];
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
		for (char no : query) {
			if (current.childList[no - 'a'] != null) {
				current = current.childList[no - 'a'];
			} else {
				return 0;
			}
		}
		return current.count;
	}
}