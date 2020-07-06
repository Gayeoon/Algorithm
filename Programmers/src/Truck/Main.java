package Truck;

import java.util.LinkedList;
import java.util.Queue;

class Truck {
	int weight;
	int time;

	Truck(int w, int t) {
		weight = w;
		time = t;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int bridge_length = 5;
		int weight = 5;
		int[] truck_weights = { 1,1,1};
		int answer = 0;

		Queue<Truck> queue = new LinkedList<Truck>();

		int count = 1;
		int idx = 1;

		queue.add(new Truck(truck_weights[0], 1));

		while (true) {
			int nowWeight = 0;
			for (int i = 0; i < queue.size(); i++) {
				Truck temp = queue.poll();
				if (temp.time < bridge_length) {
					queue.add(new Truck(temp.weight, temp.time + 1));
					nowWeight += temp.weight;
				}
			}

			if (idx < truck_weights.length && nowWeight + truck_weights[idx] < (weight + 1)) {
				nowWeight += truck_weights[idx];
				queue.add(new Truck(truck_weights[idx], 1));
				idx++;
			}
			count++;
			if (queue.isEmpty())
				break;

		}
		System.out.println(count);

	}
}