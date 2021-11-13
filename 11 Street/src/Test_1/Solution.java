package Test_1;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] phone_numbers = { "123-456-123", "123-456-123" };
		String[] phone_owners = { "Henry T.", "Wilter" };
		String number = "123-456-123";

		System.out.println(solution(phone_numbers, phone_owners, number));
	}

	static String solution(String[] phone_numbers, String[] phone_owners, String number) {
		int idx = Arrays.asList(phone_numbers).indexOf(number);
		if (idx < 0)
			return number;
		else
			return phone_owners[idx];

	}
}
