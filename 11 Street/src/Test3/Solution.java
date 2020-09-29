package Test3;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static int parent[] = new int[200001];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A = {1,2,1};
		// write your code in Java SE 8
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < A.length; i++) {
			if (parent[A[i]] != 0)
				queue.add(A[i]);
			else
				parent[A[i]] = A[i];
		}

		int cnt = 0;
		while (true) {
			if (queue.isEmpty())
				break;
			if (cnt > 1000000000) {
				//return -1;
				System.out.println(-1);
				break;
			}
			int tmp = queue.poll();
			int result = find(tmp, -1);
			if (result > 0)
				cnt += tmp - result;
			else {
				result = find(tmp+1, 1);
				if (result < 0) {
					//return -1;
					System.out.println(-1);
					break;
				}
				cnt += result - tmp;
			}
		}
		//return cnt;
		System.out.println(cnt);
	}

	static int find(int num, int flag) {
		if (num == 0 || num == 200001)
			return -1;
		if (parent[num] == -1)
			return -1;

		if (parent[num] == 0) {
			return parent[num] = num;
		}

		if (parent[num] != num) {
			return parent[num] = find(parent[num], flag);
		}

		return parent[num] = find(num + flag, flag);
	}
}