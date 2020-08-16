package Test_One;

public class Main_One {

	public static void main(String[] args) {
		int prices[] = {1, 10, 5, 11, 7};
		int[] stock = new int[2];
		int result = solve(prices, 0, stock, 0, 0, 0);
		
		if(result == 0) System.out.println(-1);
		else System.out.println(result);
	}

	static int solve(int[] prices, int index, int[] stock, int idx, int sell, int buy) {
		int result = 0;
		if (index >= prices.length) {
			return 0;
		}
		if (sell + buy >= 4){
			return 0;
		}
		// 주식 사기
		if (buy < 2) {
			stock[idx] = prices[index];
			result = Math.max(result,
					- prices[index] + solve(prices, index + 1, stock, idx + 1, sell, buy + 1));
		}

		// 주식 팔기
		if (sell < 2 && idx > 0) {
			result = Math.max(result, prices[index] + solve(prices, index + 1, stock, idx - 1, sell + 1, buy));
		}
		
		// 아무것도 안하기
		result = Math.max(result, solve(prices, index + 1, stock, idx, sell, buy));

		return result;
	}

}
