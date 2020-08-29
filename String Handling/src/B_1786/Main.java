package B_1786;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		String parent = input.nextLine();
		String pattern = input.nextLine();
		
		ArrayList<Integer> list = kmp(parent.toCharArray(), pattern.toCharArray());
		
		System.out.println(list.size());
		
		for(int i=0; i<list.size(); i++)
			System.out.print(list.get(i)+" ");
	}
	
	static int[] makePi(char[] pattern) {
		int[] pi = new int[pattern.length];
		
		int j = 0;
		
		for(int i=1; i<pattern.length; i++) {
			while(j>0 && pattern[i] != pattern[j])
				j = pi[j-1];
			if (pattern[i] == pattern[j]) {
				pi[i] = ++j;
			}
		}
		
		return pi;
	}
	
	static ArrayList<Integer> kmp(char[] parent, char[] pattern){
		int[] pi = makePi(pattern);
		ArrayList<Integer> list = new ArrayList<>();
		int j = 0;
		
		for(int i=0; i<parent.length; i++) {
			while(j>0 && parent[i] != pattern[j]) {
				j = pi[j-1];
			}
			if(parent[i] == pattern[j]) {
				if(j == pattern.length-1) {
					list.add(i-pattern.length+2);
					j = pi[j];
				}else
					j++;
			}
		}
		
		return list;
	}

}
