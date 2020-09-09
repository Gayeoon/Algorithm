package B_1997;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer> answer = new ArrayList<>();
	static ArrayList<char[][]> list = new ArrayList<>();
	static char box[][];
	static int bottom = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int w = input.nextInt();
		int b = input.nextInt();

		box = new char[b][w];

		int result = 0;
		for (int i = 0; i < n; i++) {
			int h = input.nextInt();
			char tmp[][] = new char[h][w];
			for (int j = 0; j < h; j++)
				tmp[j] = input.next().toCharArray();
			list.add(tmp);
			result = solve(i, b, h, w);
		}

		answer.add(result);
		for(int i=0; i<answer.size(); i++)
			System.out.print(answer.get(i)+" ");
	}

	static int solve(int idx, int b, int h, int w) {
		boolean flag = false;
		int height = 0;
		int prev = bottom;
		while (true) {
			if (bottom + height >= b) {
				flag = true;
				break;
			}
			if (height >= h)
				break;

			for (int i = 0; i < w; i++) {
				if (box[bottom + height][i] == 'X' && list.get(idx)[height][i] == 'X') {
					break;
				}
				box[bottom + height][i] = list.get(idx)[height][i];
			}

			height++;
		}

		if (flag) {
			answer.add(prev);
			box = new char[b][w];
			bottom = 0;
			return solve(idx, b, h, w);
		} else {
			bottom += height;
			return height;
		}
	}
}
