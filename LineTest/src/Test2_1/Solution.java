package Test2_1;

import java.util.LinkedList;

public class Solution {

	public static void main(String[] args) {

//		int[] ball={1, 2, 3, 4, 5, 6};
//		int[] order = {6, 2, 5, 1, 4, 3};

		int[] ball = { 11, 2, 9, 13, 24 };
		int[] order = { 9, 2, 13, 24, 11 };

		int[] answer = new int[order.length];

		LinkedList<Integer> list = new LinkedList<>();

		for (int i = 0; i < ball.length; i++)
			list.add(ball[i]);

		boolean check[] = new boolean[ball.length];
		int start = 0;
		int end = list.size() - 1;
		int index = 0;

		for (int i = 0; i < order.length; i++) {
			int idx = list.indexOf(order[i]);
			check[idx] = true;

			if (idx == start) {
				answer[index++] = ball[idx];
				start++;
				for (int k = start; k <= end; k++) {
					if (check[k]) {
						answer[index++] = ball[k];
						check[k] = true;
						start++;
						continue;
					}
					break;
				}
			}

			else if (idx == end) {
				answer[index++] = ball[idx];
				end--;
				for (int k = end; k >= start; k--) {
					if (check[k]) {
						answer[index++] = ball[k];
						check[k] = true;
						end--;
						continue;
					}
					break;
				}
			}
		}

		//return answer;
		for(int i=0; i<answer.length; i++)
			System.out.print(answer[i]+" ");
	}
}