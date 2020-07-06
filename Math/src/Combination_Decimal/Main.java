package Combination_Decimal;

import java.util.Stack;
import java.util.Arrays;

// а╤гу nC3

public class Main {
	static boolean[] decimal;
	static Stack<Integer> stack;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = { 1, 2, 7, 6, 4 };
		int answer = -1;
		stack = new Stack<>();

		Arrays.sort(nums);
		int n = nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];
		decimal = new boolean[n + 1];

		Arrays.fill(decimal, true);
		decimal[0] = decimal[1] = false;

		for (int i = 2; i <= n; i++) {
			if (!decimal[i])
				continue;
			for (int j = i + i; j <= n; j += i) {
				decimal[j] = false;
			}
		}

		answer = combination(nums, nums.length, 3, 0);

		System.out.println(answer);
	}

	static int combination(int[] nums, int n, int r, int index) {
		if (r == 0) {
			int result = 0;
			for (int i = 0; i < 3; i++)
					result += stack.get(stack.size()-i-1);
			if (decimal[result])
				return 1;
			else
				return 0;
		} else if (n == r) {
			int result = 0;
			for (int i = 0; i < n; i++)
				result += nums[index + i];
			for (int i = 0; i < 3 - n; i++) {
					result += stack.get(stack.size()-i-1);
			}
			if (decimal[result])
				return 1;
			else
				return 0;
		} else {
			int result = 0;
			stack.push(nums[index]);
			result += combination(nums, n - 1, r - 1, index+1);

				stack.pop();
			result += combination(nums, n - 1, r, index+1);
			return result;
		}
	}
}
