package Test3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String answer_sheet = "4132315142";
		String[] sheets = { "3241523133", "4121314445", "3243523133", "4433325251", "2412313253" };
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