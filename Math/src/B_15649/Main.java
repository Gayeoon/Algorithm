package B_15649;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static LinkedList<Integer> ck = new LinkedList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int m = input.nextInt();

		LinkedList<Integer> list = new LinkedList<>();
		boolean check[] = new boolean[n + 1];
		permutation(n, m, list, check);
	}

	static void permutation(int n, int m, LinkedList<Integer> list, boolean[] check) {
		if (list.size() == m) {
			for (int i : list)
				System.out.print(i + " ");
			System.out.println();
		} else {
			int cnt = 0;
			for (int i = 1; i <= n; i++) {
				if (check[i] || ck.contains(i))
					continue;
				check[i] = true;
				list.add(i);
				permutation(n, m, list, check);
				list.removeLast();
				check[i] = false;
				ck.add(i);
				cnt++;
			}
			for(int j=cnt; j > 0; j--) {
				ck.removeLast();
			}
		}
	}

}
