package IU;

public class Main {
	static int possible = 0;
	static int maxThree = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 24;
		maxThree = (int) (Math.log10(n) / Math.log10(3));
		threeStep(n - 2, 0, 2);
		System.out.println(possible);
	}

	static void threeStep(int num, int cntStar, int cntPlus) {
		if (num < 1)
			return;
		if (num == 1 & cntPlus == 2 * cntStar) {
			possible++;
			return;
		}

		if (2 * maxThree < cntPlus)
			return;
		if (num % 3 == 0) {
			if (2 * (cntStar + 1) <= cntPlus)
				threeStep(num / 3, cntStar + 1, cntPlus);
			threeStep(num - 3, cntStar, cntPlus + 3);
		} else if (num % 3 == 2) {
			threeStep(num - 2, cntStar, cntPlus + 2);
		} else if (num % 3 == 1) {
			threeStep(num - 1, cntStar, cntPlus + 1);
		}
		return;
	}
}
