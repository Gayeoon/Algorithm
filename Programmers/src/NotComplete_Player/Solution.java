package NotComplete_Player;

import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] participant = { "marina", "josipa", "nikola", "vinko", "filipa" };
		String[] completion = { "josipa", "filipa", "marina", "nikola" };

		HashMap<String, Integer> hash = new HashMap<>();

		for (int i = 0; i < completion.length; i++) {
			if (hash.containsKey(completion[i]))
				hash.put(completion[i], hash.get(completion[i]) + 1);
			else
				hash.put(completion[i], 1);
		}

		for (int i = 0; i < participant.length; i++) {
			if (hash.containsKey(participant[i])) {
				int tmp = hash.get(participant[i]);
				if (tmp == 0) {
					System.out.println(participant[i]);
					break;
				}
				hash.put(participant[i], tmp - 1);
			} else
				System.out.println(participant[i]);
		}
	}
}