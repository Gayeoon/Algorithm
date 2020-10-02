package B_6443;

import java.util.Scanner;

public class Main {
	static StringBuilder sb;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			String str = input.next();
			char alpha[] = new char[26];
			
			for(int j=0; j<str.length(); j++) {
				alpha[str.charAt(j) - 'a']++;
			}
			
			solution(alpha, "", str.length());
		}
		
		System.out.print(sb);
	}
	
	static void solution(char[] alpha, String str, int n) {
		if(str.length() == n) {
			sb.append(str+"\n");
		}
		
		for(int i=0; i<26; i++) {
			if(alpha[i] > 0) {
				alpha[i]--;
				char tmp = (char) ('a'+ i);
				solution(alpha, str + tmp, n);
				alpha[i]++;
			}
		}
	}
}
