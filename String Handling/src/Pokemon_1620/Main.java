package Pokemon_1620;


import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int q = input.nextInt();
		
		HashMap<String, Integer> hash = new HashMap<>();
		HashMap<String, String> index = new HashMap<>();
		for(int i=1; i<=n; i++) {
			String str = input.next();
			hash.put(str, i);
			index.put(i+"", str);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=q; i++) {
			String temp = input.next();
			if(!Character.isDigit(temp.charAt(0)))
				sb.append(hash.get(temp)+"\n");
			else
				sb.append(index.get(temp)+"\n");
		}
		System.out.print(sb);
	}

}
