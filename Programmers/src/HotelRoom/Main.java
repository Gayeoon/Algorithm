package HotelRoom;

import java.util.HashMap;

public class Main {
	static HashMap<Long, Long> hash;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long k = 10;
		long[] room_number = {1,3,4,1,3,1};
		hash = new HashMap<>();
		long[] answer = new long[room_number.length];
		for (int i = 0; i < room_number.length; i++) {
			answer[i] = find(room_number[i]) - 1;
		}
		System.out.println(answer);
	}

	static long find(long number) {
		if (!hash.containsKey(number)) {
			hash.put(number, number + 1);
			return number + 1;
		} else {
			long temp = find(hash.get(number));
			hash.put(number, temp);
			return temp;
		}
	}
}