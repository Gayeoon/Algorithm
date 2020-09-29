package Test2;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] S = { "bdafg", "ceagi" };
		// write your code in Java SE 8
		int[] result = new int[3];

		for (int i = 0; i < S[0].length(); i++) {
			for (int n = 0; n < S.length - 1; n++) {
				for (int m = n + 1; m < S.length; m++) {
					if (S[n].charAt(i) == S[m].charAt(i)) {
						result[0] = n;
						result[1] = m;
						result[2] = i;
						System.out.println(n + " " + m + " " + i);
						break;
					}
				}
			}
		}
		int ans[] = new int[0];
//		        return ans;
	}

}
