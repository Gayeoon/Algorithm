package Wedding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();

		ArrayList<ArrayList<Integer>> friend = new ArrayList<>();

		for (int i = 0; i < n + 1; i++) {
			friend.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < m; i++) {
			int a = input.nextInt();
			int b = input.nextInt();

			friend.get(a).add(b);
			friend.get(b).add(a);
		}

		int count = 0;
		HashMap<Integer, Boolean> hash = new HashMap<>();
		hash.put(1, true);
		for (int temp : friend.get(1)) {
			if (!hash.containsKey(temp)) {
				count++;
				hash.put(temp, true);
			}
				for (int t : friend.get(temp)) {
					if (!hash.containsKey(t)) {
						count++;
						hash.put(t, true);
					}
				}
			
		}
		
		System.out.println(count);
	}

}
