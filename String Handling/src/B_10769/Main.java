package B_10769;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		String str = input.nextLine();
		
		System.out.println(kmp(str.toCharArray()));
	}
	
	static String kmp(char[] str) {
		char[] happy = ":-)".toCharArray();
		char[] sad = ":-(".toCharArray();
		
		int j = 0;
		int h=0, s=0;
		
		for(int i=0; i<str.length; i++) {
			while(j>0 && (str[i] != happy[j] && str[i] != sad[j]))
				j = 0;
			if(str[i] == happy[j]) {
				if(j == 2) {
					h++;
					j = 0;
				}else
					j++;
			}else if(str[i] == sad[j]) {
				if(j == 2) {
					s++;
					j = 0;
				}else
					j++;
			}
		}
		
		if(h == 0 && s == 0)
			return "none";
		
		if(h > s)
			return "happy";
		else if(h < s)
			return "sad";
		else
			return "unsure";
	}

}
