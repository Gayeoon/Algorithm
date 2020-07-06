package WordChange;

import java.util.HashMap;

public class Main {
	static HashMap<String, Integer> hash = new HashMap<>();
	static boolean visit[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String begin = "hit";
		String target = "cog";
		String words[] = { "hot", "dot", "dog", "lot", "log", "cog" };
		visit = new boolean[words.length+1];
		hash.put(begin, 0);
		for (int i = 0; i < words.length; i++) {
			hash.put(words[i], i+1);
		}
		int answer = solve(words, begin, target, 0);
		if(answer == Integer.MAX_VALUE)
			System.out.println(0);
		else
			System.out.println(answer);
	}

	static int solve(String[] words, String now, String target,int idx) {
		if(now == target)
			return idx;
		int cnt = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {
			int count = 0;
			if(visit[hash.get(words[i])]) continue;
			for (int j = 0; j < now.length(); j++) {
				if (now.charAt(j) != words[i].charAt(j))
					count++;
				if (count > 1)
					break;
			}
			if (count == 1) {
				visit[hash.get(words[i])] = true;
				cnt = Math.min(cnt, solve(words, words[i], target, idx+1));
				System.out.println(cnt);
				visit[hash.get(words[i])] = false;
			}
		}
		return cnt;
	}

}
