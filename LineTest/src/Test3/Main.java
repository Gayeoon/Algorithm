package Test3;

class Road {
	int nomal, idx;

	Road(int nomal, int idx) {
		this.nomal = nomal;
		this.idx = idx;
	}
}

public class Main {

	static Road[] damage;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String road = "001100";
		int n = 2;
		int answer = -1;
		damage = new Road[road.length() + 1];
		int cnt = 0;
		int idx = 0;
		for (int i = 0; i < road.length(); i++) {
			if (road.charAt(i) == '0') {
				damage[idx] = new Road(cnt, i);
				cnt = 0;
				idx++;
			} else {
				cnt++;
			}
		}
		if(idx <= n)
			System.out.println(road.length());
		
		damage[idx] = new Road(cnt, road.length());
		
		idx++;
		answer = solve(0, idx, n);
		System.out.println(answer);
	}

	static int solve(int start, int idx, int n) {
		if (start >= idx - n) {
			return 0;
		}
		int count = 0;
		for (int i = start; i < start + n + 1; i++) {
			count += damage[i].nomal + 1;
		}
		count--;
		count = Math.max(count, solve(start + 1, idx, n));
		return count;
	}
}
