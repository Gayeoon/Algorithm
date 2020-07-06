package JewelryThief_1202;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Jewelry implements Comparable<Jewelry> {
	int m, v;

	Jewelry(int m, int v) {
		this.m = m;
		this.v = v;
	}

	@Override
	public int compareTo(Jewelry j) {
		if (this.m < j.m)
			return -1;
		else
			return 1;
	}

}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int K = input.nextInt();
	
		Jewelry[] jewelry = new Jewelry[N];
		for (int i = 0; i < N; i++) {
			int n1 = input.nextInt();
			int n2 = input.nextInt();
			jewelry[i] = new Jewelry(n1, n2);
		}

		int weight[] = new int[K];

		for (int i = 0; i < K; i++) {
			weight[i] = input.nextInt();
		}

		Arrays.sort(jewelry);
		Arrays.sort(weight);

		PriorityQueue<Integer> queue = new PriorityQueue<>();
		long sum = 0;
		int index = 0;
		for (int i = 0; i < K; i++) {
			while (index < N) {
				if (jewelry[index].m > weight[i])
					break;
				queue.add(-(jewelry[index].v));
				index++;
			}
			if (!queue.isEmpty()) {
				sum += Math.abs(queue.poll());
			}
		}

		System.out.println(sum);

	}

}
