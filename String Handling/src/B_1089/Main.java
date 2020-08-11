package B_1089;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static char arr[][];
	static char num[][][] = {
			{ { '#', '#', '#' }, { '#', '.', '#' }, { '#', '.', '#' }, { '#', '.', '#' }, { '#', '#', '#' } },
			{ { '.', '.', '#' }, { '.', '.', '#' }, { '.', '.', '#' }, { '.', '.', '#' }, { '.', '.', '#' } },
			{ { '#', '#', '#' }, { '.', '.', '#' }, { '#', '#', '#' }, { '#', '.', '.' }, { '#', '#', '#' } },
			{ { '#', '#', '#' }, { '.', '.', '#' }, { '#', '#', '#' }, { '.', '.', '#' }, { '#', '#', '#' } },
			{ { '#', '.', '#' }, { '#', '.', '#' }, { '#', '#', '#' }, { '.', '.', '#' }, { '.', '.', '#' } },
			{ { '#', '#', '#' }, { '#', '.', '.' }, { '#', '#', '#' }, { '.', '.', '#' }, { '#', '#', '#' } },
			{ { '#', '#', '#' }, { '#', '.', '.' }, { '#', '#', '#' }, { '#', '.', '#' }, { '#', '#', '#' } },
			{ { '#', '#', '#' }, { '.', '.', '#' }, { '.', '.', '#' }, { '.', '.', '#' }, { '.', '.', '#' } },
			{ { '#', '#', '#' }, { '#', '.', '#' }, { '#', '#', '#' }, { '#', '.', '#' }, { '#', '#', '#' } },
			{ { '#', '#', '#' }, { '#', '.', '#' }, { '#', '#', '#' }, { '.', '.', '#' }, { '#', '#', '#' } }, };

	static ArrayList<ArrayList<Integer>> list;
	static double sum = 0;
	static int cnt = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();

		arr = new char[5][3 * n + (n - 1)];

		list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			list.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < 5; i++) {
			arr[i] = input.next().toCharArray();
		}

		boolean flag = true;
		for (int i = 0; i < n; i++) {
			list.get(i).addAll(solve(i * 4));
			if (list.get(i).size() == 0) {
				flag = false;
				break;
			}
		}

		if (flag) {

			for (int i = n - 1; i >= 0; i--) {
				double tmp = 0;
				for (int k : list.get(n - i - 1)) {
					tmp += k;
				}
				tmp *= Math.pow(10, i);
				sum += (tmp / list.get(n - i - 1).size());
			}
			System.out.println(sum);
		} else {
			System.out.println(-1);
		}
	}

	private static ArrayList<Integer> solve(int start) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int k = 0; k <= 9; k++) {
			boolean flag = true;
			loop: for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 3; j++) {

					if (num[k][i][j] == '.' && arr[i][start + j] == '#') {
						flag = false;
						break loop;
					}
				}
			}
			if (flag) {
				list.add(k);
			}
		}
		return list;
	}

}
