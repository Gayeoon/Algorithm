package Bad_users;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
	static HashMap<String, Boolean> hash;
	static ArrayList<String> overlap;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
		String[] banned_id = { "fr*d*", "*rodo", "******", "******" };

		int answer = 0;
		ArrayList<ArrayList<String>> list = new ArrayList<>();
		overlap = new ArrayList<>();
		hash = new HashMap<>();
		for (int i = 0; i < user_id.length; i++) {
			hash.put(user_id[i], false);
		}

		for (int i = 0; i < banned_id.length; i++) {
			list.add(new ArrayList<String>());
			for (int j = 0; j < user_id.length; j++) {
				if (user_id[j].length() != banned_id[i].length())
					continue;
				String user = user_id[j];
				String banned = banned_id[i];
				boolean flag = true;

				for (int k = 0; k < user_id[j].length(); k++) {
					if (banned.charAt(k) == '*')
						continue;
					if (user.charAt(k) != banned.charAt(k)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					list.get(i).add(user);
				}
			}
		}
		ArrayList<String> ans = new ArrayList<>();
		int result = solve(list, ans, 0);
		System.out.println(result);
	}

	static int solve(ArrayList<ArrayList<String>> list, ArrayList<String> ans, int idx) {
		if (idx >= list.size()) {
			ArrayList<String> tmp = new ArrayList<>(ans);
			tmp.sort(null);
			String str = "";
			for (int i = 0; i < tmp.size(); i++) {
				str += tmp.get(i);
			}
			if (overlap.contains(str))
				return -1;
			overlap.add(str);

			return 1;
		}

		int result = 0;

		for (int i = 0; i < list.get(idx).size(); i++) {
			if (ans.contains(list.get(idx).get(i)))
				continue;
			ans.add(list.get(idx).get(i));
			int tmp = solve(list, ans, idx + 1);
			if (tmp > 0)
				result += tmp;
			ans.remove(list.get(idx).get(i));
		}
		return result;
	}
}