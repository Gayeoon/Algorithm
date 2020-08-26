package B_1107;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static int cnt = 0;
	static HashMap<Integer, Boolean> hash;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int chan = input.nextInt();

		hash = new HashMap<>();

		for (int i = 0; i <= 9; i++) {
			hash.put(i, true);
		}

		int n = input.nextInt();

		for (int i = 0; i < n; i++) {
			hash.put(input.nextInt(), false);
		}

		cnt = Math.abs(chan - 100);

		for(int i=0; i< 1000000; i++) {
			int temp = solve(i);
			
			if(temp < 0) continue;
			
			cnt = Math.min(cnt, Math.abs(chan - i) + temp);
		}
		
		System.out.println(cnt);
	}

	static int solve(int move) {
		if(move == 0) {
			if (hash.get(move))
				return 1;
			else
				return -1;
		}
		
		int len = 0;
		while (move != 0) {
			int tmp = move % 10;
			move /= 10;
			len++;
			if (!hash.get(tmp))
				return -1;
		}
		return len;
	}
}
