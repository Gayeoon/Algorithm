package FindPrimeNum;

import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
	static SortedSet<Integer> set = new TreeSet<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String numbers = "17";

		char nums[] = numbers.toCharArray();

		boolean check[] = new boolean[nums.length];
		for (int i = 1; i <= nums.length; i++) {
			permutation(nums, i, 0, "", check);
		}
		
		int cnt = 0;
		for (Integer value : set) {
			if(isPrime(value))
				cnt++;
		}
		
		System.out.println(cnt);
	}
	
	static boolean isPrime(int num) {
		if(num <= 1)
			return false;
		for (int i = 2; i <= (int)Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	static void permutation(char nums[], int n, int cnt, String str, boolean check[]) {
		if (n == cnt) {
			set.add(Integer.parseInt(str));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (check[i])
				continue;
			check[i] = true;
			permutation(nums, n, cnt+1, str + nums[i], check);
			check[i] = false;
		}
	}

}
