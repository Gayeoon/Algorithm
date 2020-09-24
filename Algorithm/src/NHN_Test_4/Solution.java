package NHN_Test_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

class Route implements Comparable<Route>{
	int price, oil;
	String dis;
	Route(int price, int oil, String dis){
		this.price = price;
		this.oil = oil;
		this.dis = dis;
	}
	
	@Override
	public int compareTo(Route r) {
		if(this.price > r.price)
			return -1;
		else if(this.price == r.price) {
			if(this.oil < r.oil)
				return -1;
			else
				return 1;
		}
		return 1;
	}
}

class Trade implements Comparable<Trade> {
	int city, price, oil;
	String dis;

	Trade(int city, int price, int oil, String dis) {
		this.city = city;
		this.price = price;
		this.oil = oil;
		this.dis = dis;
	}

	@Override
	public int compareTo(Trade t) {
		if (this.price < t.price)
			return -1;
		else
			return 1;
	}

}

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int oil = input.nextInt();
		int city[][] = new int[n][n];
		char[] alpha = new char[n];

		HashMap<Character, Integer> hash = new HashMap<>();
		char m = 'A';
		for (int i = 0; i < n; i++) {
			hash.put(m, i);
			alpha[i] = m;
			m++;
		}

		int d = input.nextInt();

		for (int i = 0; i < d; i++) {
			char a = input.next().charAt(0);
			char b = input.next().charAt(0);
			int dis = input.nextInt();

			city[hash.get(a)][hash.get(b)] = dis;
		}

		PriorityQueue<Trade> queue = new PriorityQueue<>();
		boolean visit[] = new boolean[n];

		visit[0] = true;
		queue.add(new Trade(0, 0, oil, "A"));

		ArrayList<Route> result = null;
		ArrayList<Route> max = null;
		while (true) {
			if (queue.isEmpty())
				break;

			Trade tmp = queue.poll();

			if (tmp.city == n - 1) {
				if(result == null) {
					result = new ArrayList<>();
					result.add(new Route(tmp.price, tmp.oil, tmp.dis));
				}
				else if (result.get(0).price < tmp.price) {
					result = new ArrayList<>();
					result.add(new Route(tmp.price, tmp.oil, tmp.dis));
				} else if (result.get(0).price == tmp.price) {
					result.add(new Route(tmp.price, tmp.oil, tmp.dis));
				}
			}
			
			for (int i = 0; i < n; i++) {
				if (city[tmp.city][i] > 0 && !visit[i]) {
					if (tmp.oil >= city[tmp.city][i]) {
						if (i == n - 1) {
							queue.add(new Trade(i, tmp.price + 300, tmp.oil - city[tmp.city][i] + 10,
									tmp.dis + " " + alpha[i]));
						} else {
							queue.add(new Trade(i, tmp.price + 200, tmp.oil - city[tmp.city][i] + 10,
									tmp.dis + " " + alpha[i]));
						}
					} else {
						if (result == null) {
							if(max == null) {
								max = new ArrayList<>();
								max.add(new Route(tmp.price, tmp.oil, tmp.dis));
							}
							else if (max.get(0).price < tmp.price) {
								max = new ArrayList<>();
								max.add(new Route(tmp.price, tmp.oil, tmp.dis));
							} else if (max.get(0).price == tmp.price) {
								max.add(new Route(tmp.price, tmp.oil, tmp.dis));
							}
						}
					}
				}
			}
		}
		
		if(result != null) {
			result.sort(null);
			int pre = result.get(0).oil;
			boolean flag = true;
			for(int i=1; i<result.size(); i++) {
				if(pre == result.get(i).oil) {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				for(Route r : result)
					System.out.println(r.dis+" "+r.price+" "+r.oil);
			}else
				System.out.println(-1);
			
		}else {
			max.sort(null);
			int pre = max.get(0).oil;
			boolean flag = true;
			for(int i=1; i<max.size(); i++) {
				if(pre == max.get(i).oil) {
					flag = false;
					break;
				}
			}
			
			if(flag) {
				for(Route r : max)
					System.out.println(r.dis+" "+r.price+" "+r.oil);
			}else
				System.out.println(-1);
		}
	}

}
