package Test2_2;
import java.util.ArrayList;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] cards = { 10, 13, 10, 1, 2, 3, 4, 5, 6, 2};
		ArrayList<Integer> player = new ArrayList<>();
		ArrayList<Integer> dealer = new ArrayList<>();

		player.add(cards[0]);
		dealer.add(cards[1]);
		player.add(cards[2]);
		dealer.add(cards[3]);

		int idx = 4;
		int sum = sum(player);
		if (sum == 21) {
			System.out.println(check(21, dealer, cards, 0));
		}
		// 합이 17 이상이 될 때까지 받는다
		else if (cards[3] == 1 || cards[3] >= 7) {
			while (true) {
				player.add(cards[idx++]);
				if (idx >= cards.length)
					System.out.println(0);
				sum = sum(player);
				if (sum >= 17)
					break;
			}
			System.out.println(check(sum, dealer, cards, idx));
		}

		// 12 이상이 될 때까지 받는다
		else if (cards[3] == 2 && cards[3] == 3) {
			while (true) {
				player.add(cards[idx++]);
				if (idx >= cards.length)
					System.out.println(0);
				sum = sum(player);
				if (sum >= 17)
					break;
			}

			System.out.println(check(sum, dealer, cards, idx));
		}
		else
			System.out.println(check(sum, dealer, cards, idx));
		System.out.println(0);
	}

	static int check(int player_sum, ArrayList<Integer> dealer, int[] cards, int idx) {
		if (sum(dealer) == 21) {
			if (player_sum == 21)
				return 0;
			else
				return -2;
		}
		if (player_sum == 21)
			return 3;
		int sum = 0;
		while (true) {
			if (idx >= cards.length)
				return 0;
			dealer.add(cards[idx++]);
			sum = sum(dealer);
			if (sum >= 21)
				return 2;
			if (sum >= 17)
				break;
		}

		if (Math.abs(21 - player_sum) > Math.abs(21 - (sum)))
			return -2;
		else if (Math.abs(21 - player_sum) < Math.abs(21 - (sum)))
			return 2;
		else
			return 0;
	}

	static int sum(ArrayList<Integer> who) {
		int one_cnt = 0;
		int sum = 0;

		for (int i : who) {
			if (i == 1) {
				one_cnt++;
			}
			sum += i;
		}

		while (true) {
			if (one_cnt <= 0)
				break;

			if (Math.abs(21 - sum) > Math.abs(21 - (sum + 10)))
				sum += 9;
			else
				break;
		}

		return sum;
	}
}