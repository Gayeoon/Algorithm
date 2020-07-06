package MinimumSpanningTree_4195;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static int root[];
	static int rank[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int question = input.nextInt();
		int answer[] = new int[100000];
		int cnt = 0;
		for (int q = 0; q < question; q++) {
			int n = input.nextInt();

			root = new int[100000];
			rank = new int[100000];
			int num = 0;

			Arrays.fill(rank, 1);
			
			HashMap<String, Integer> hash = new HashMap<>();

			for (int k = 0; k < n; k++) {
				String temp1 = input.next();
				String temp2 = input.next();

				if (!hash.containsKey(temp1)) {
					hash.put(temp1, num);
					root[num] = num;
					num++;
				}
				if (!hash.containsKey(temp2)) {
					hash.put(temp2, num);
					root[num] = num;
					num++;
				}

				answer[cnt] = union(hash.get(temp1), hash.get(temp2));
				cnt++;
			}
		}
		for(int i=0; i<cnt; i++) {
			System.out.println(answer[i]);
		}
	}

	static int union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b)
			return rank[a];

		else if (rank[a] > rank[b]) {
			rank[a] += rank[b];
			root[b] = a;
			return rank[a];
		} else {
			rank[b] += rank[a];
			root[a] = b;
			return rank[b];
		}
	}

	static int find(int target) {
		if (target == root[target])
			return target;
		return root[target] = find(root[target]);
	}
}
