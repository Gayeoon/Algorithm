package Test2_3;

public class Solution {
	static int min = Integer.MAX_VALUE;
	static String result = "";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10007;

		solve(n + "", 0);
		int[] answer = { min, Integer.parseInt(result) };
		System.out.println(min + " " + result);
	}

	static void solve(String str, int cnt) {
		if (str.length() == 1) {
			if (min > cnt) {
				min = cnt;
				result = str;
			}
			return;
		}

		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == '0')
				continue;
			int prev = Integer.parseInt(str.substring(0, i));
			int next = Integer.parseInt(str.substring(i, str.length()));
			prev += next;
			solve(prev + "", cnt + 1);
		}
	}
}
