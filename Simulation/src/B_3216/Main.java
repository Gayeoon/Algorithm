package B_3216;

import java.util.Scanner;

class Down {
	int start, end;

	Down(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		int music[] = new int[n];
		Down down[] = new Down[n];
		int prev = 0;
		for (int i = 0; i < n; i++) {
			int d = input.nextInt();
			int v = input.nextInt();

			music[i] = d;
			down[i] = new Down(prev, prev + v);
			prev += v;
		}

		if (n == 1) {
			System.out.println(down[0].end);
		} else {
			int idx = n - 2;
			int now = down[n - 1].end;
			while (true) {
				if (idx < 0)
					break;
				if (now - music[idx] >= down[idx].end) {
					now -= music[idx];
					idx--;
				}else {
					now = down[idx].end;
					idx--;
				}
			}

			System.out.println(now);
		}
	}

}
