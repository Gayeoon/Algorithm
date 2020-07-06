package Travel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class Country {
	String start;
	String end;
	int idx;

	Country(String s, String e, int i) {
		start = s;
		end = e;
		idx = i;
	}
}

public class Main {
	static ArrayList<String> answer;
	static ArrayList<Country> name;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] tickets = { { "ICN", "COO" }, { "ICN", "BOO" }, { "COO", "ICN" }, { "BOO", "DOO" } };
		name = new ArrayList<>();
		answer = new ArrayList<>();
		for (int i = 0; i < tickets.length; i++) {
			name.add(new Country(tickets[i][0], tickets[i][1], i));
		}
		Comparator<Country> comparator = new Comparator<Country>() {
			@Override
			public int compare(Country a, Country b) {
				if (a.start.equals(b.start)) {
					return a.end.compareTo(b.end);
				} else {
					return a.start.compareTo(b.start);
				}
			}
		};

		Collections.sort(name, comparator);

		for (int i = 0; i < name.size(); i++) {
			if (name.get(i).start.equals("ICN")) {
				answer.clear();
				boolean visited[] = new boolean[name.size()];
				answer.add("ICN");
				int count = dfs(i, 1, visited);
				if (count == tickets.length)
					break;
			}
		}
		String[] ans = new String[answer.size()];
		for (int i = 0; i < answer.size(); i++) {
			ans[i] = answer.get(i);
		}
		System.out.println(answer);
	}

	static int dfs(int i, int count, boolean[] visited) {
		if (!visited[name.get(i).idx]) {
			visited[name.get(i).idx] = true;
			answer.add(count, name.get(i).end);
			System.out.println(name.get(i).end);
			count++;
		}
		if(count > name.size()) return count-1;

		Iterator<Country> it = name.iterator();

		while (it.hasNext()) {
			Country temp = it.next();
			if (!visited[temp.idx] && name.get(i).end.equals(temp.start)) {
				dfs(name.indexOf(temp), count, visited);
			}

		}
		return count;
	}

}