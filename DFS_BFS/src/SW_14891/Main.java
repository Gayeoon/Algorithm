package SW_14891;

import java.util.Scanner;

public class Main {
	static int gear[][] = new int[4][8];
	static int index[] = new int[4];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		for (int i = 0; i < 4; i++) {
			String str = input.next();
			for (int j = 0; j < 8; j++)
				gear[i][j] = str.charAt(j) - '0';
			index[i] = 0;
		}

		int q = input.nextInt();

		for (int i = 0; i < q; i++) {
			boolean visit[] = new boolean[4];
			solve(input.nextInt() - 1, input.nextInt(), visit);

		}
		
		int result = 0;
		if(gear[0][index[0]] == 1)
			result += 1;
		if(gear[1][index[1]] == 1)
			result += 2;
		if(gear[2][index[2]] == 1)
			result += 4;
		if(gear[3][index[3]] == 1)
			result += 8;
		
		System.out.println(result);
	}

	static void solve(int idx, int flag, boolean[] visit) {
		int tmp = index[idx] - flag;
		if (tmp < 0)
			tmp = 7;
		if (tmp > 7)
			tmp = 0;

		visit[idx] = true;
		if(idx - 1 >= 0 && !visit[idx-1]) {
			visit[idx-1] = true;
			if(gear[idx][(index[idx]+6)%8] != gear[idx-1][(index[idx-1]+2)%8])
				solve(idx-1, -flag, visit);
		}

		if(idx + 1 < 4 && !visit[idx+1]) {
			visit[idx+1] = true;
			if(gear[idx][(index[idx]+2)%8] != gear[idx+1][(index[idx+1]+6)%8])
				solve(idx+1, -flag, visit);
		}
		
		index[idx] = tmp;

	}
}
