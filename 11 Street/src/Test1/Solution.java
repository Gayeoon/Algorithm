package Test1;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "doga";
		
		int cnt = 0;
		int a = 0;
		if(S.contains("aaa"))
			System.out.println(-1);
		
		for(int i=0; i<S.length(); i++) {
			if(S.charAt(i) == 'a')
				a++;
			else {
				cnt += (2-a);
				a = 0;
			}
		}
		cnt += (2-a);
		
		System.out.println(cnt);
	}

}
