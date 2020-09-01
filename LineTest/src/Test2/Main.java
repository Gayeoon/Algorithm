package Test2;

public class Main {

	public static void main(String[] args) {
		String answer_sheet = "53241";
		String[] sheets = { "53241", "42133", "53241", "14354"};
		int answer = 0;
		for (int i = 0; i < sheets.length; i++) {
			int total = 0;
			int conti = 0;
			int max = 0;
			int prev = -1;
			for (int j = 0; j < answer_sheet.length(); j++) {
				boolean flag = false;
				if (answer_sheet.charAt(j) != sheets[i].charAt(j)) {
					flag = true;
					total++;
				}
				if (flag) {
					if (prev + 1 == j) {
						conti++;
						prev = j;
					}
				}else {
					conti = 0;
				}
				max = Math.max(max, conti);
			}
			answer = Math.max(answer, (int) (total + Math.pow(max, 2)));
		}

		System.out.println(answer);
	}
}