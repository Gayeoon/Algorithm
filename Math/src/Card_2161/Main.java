package Card_2161;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=1; i<=n; i++)
			list.add(i);
		System.out.println(solve(n, list));
	}
	
	static String solve(int n, ArrayList<Integer> list) {
		if(n == 1) {
			return list.get(0)+"";
		}
		if(n == 2) {
			return list.get(0)+" "+list.get(1);
		}
		String str = "";
		ArrayList<Integer> newlist = new ArrayList<>();
		if(n % 2 != 0) {
			newlist.add(list.get(list.size()-1));
			n--;
		}
		boolean flag = true;
		for(int i=0; i< n; i++) {
			if(flag) {
				str += list.get(i)+" ";
				flag = false;
			}else {
				newlist.add(list.get(i));
				flag = true;
			}
		}
		str += solve(newlist.size(), newlist);
		return str;
	}

}
