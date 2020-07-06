package ATM;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(input.nextInt());
		}

		list.sort(null);

		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			for(int j=i; j<list.size(); j++) {
				sum += list.get(i);
			}
		}

		System.out.println(sum);

	}

}
