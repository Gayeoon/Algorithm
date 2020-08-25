package B_1076;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		String first = input.next();
		String second = input.next();
		String third = input.next();

		LinkedList<String> list = new LinkedList<>(
				Arrays.asList("black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"));

		long sum  = list.indexOf(first) * 10;
		sum += list.indexOf(second);
		
		sum = (long) (sum * Math.pow(10, list.indexOf(third)));
		
		System.out.println(sum);
	}

}
