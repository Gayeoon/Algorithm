package RoomNumber;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		String room = input.next();
		int count = 0;

		HashMap<Character, Integer> hash = new HashMap<>();

		for (int i = 0; i < room.length(); i++) {
			char temp = room.charAt(i);

			if (hash.containsKey(temp)) {
				if (hash.get(temp) == count) {
					if (temp == '6' || temp == '9') {
						char another = '6';
						if (temp == '6')
							another = '9';

						if (hash.containsKey(another)) {
							if (hash.get(another) == count)
								count++;
							int num = hash.get(temp);
							hash.put(temp, num + 1);
						} else {
							hash.put(another, 1);
						}
					} else {
						count++;
						int num = hash.get(temp);
						hash.put(temp, num + 1);
					}
				} else {
					int num = hash.get(temp);
					hash.put(temp, num + 1);
				}
			} else {
				hash.put(temp, 1);
				if(count == 0) count = 1;
			}
		}
		System.out.println(count);
	}
}
