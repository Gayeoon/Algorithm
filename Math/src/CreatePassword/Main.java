package CreatePassword;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Character> pw, cons, vowel, mix;
	static ArrayList<String> list;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int L = input.nextInt();
		int C = input.nextInt();
		pw = new ArrayList<Character>();
		cons = new ArrayList<Character>();
		vowel = new ArrayList<Character>();
		mix = new ArrayList<Character>();
		list = new ArrayList<>();
		for (int i = 0; i < C; i++) {
			pw.add(input.next().charAt(0));
			if (pw.get(i) == 'a' || pw.get(i) == 'e' || pw.get(i) == 'i' || pw.get(i) == 'o' || pw.get(i) == 'u') {
				cons.add(pw.get(i));
				mix.add(pw.get(i));
			} else
				vowel.add(pw.get(i));
		}
		pw.sort(null);
		char[] arr = new char[L];
		combination(0, C, L, 0, arr, 0);

		if (vowel.size() >= L) {
			vowel.sort(null);
			arr = new char[L];
			combination(1, vowel.size(), L, 0, arr, 0);
		}
		if (cons.size() >= L) {
			cons.sort(null);
			arr = new char[L];
			combination(2, cons.size(), L, 0, arr, 0);
		}
		if (cons.size() + 1 >= L) {
			for (int i = 0; i < vowel.size(); i++) {
				mix.add(vowel.get(i));
				mix.sort(null);
				arr = new char[L];
				combination(3, mix.size(), L, 0, arr, 0);
				mix.remove(vowel.get(i));
			}
		}

		list.sort(null);
		for (String s : list) {
			System.out.println(s);
		}
	}

	// flag = 0 : 모든 경우의 수
	// flag = 1 : 자음으로 이루어진 경우의 수
	// flag = 2 : 모음으로 이루어진 경우의 수
	// flag = 3 : 모음과 자음 하나로 이루어진 경우의 수
	static void combination(int flag, int n, int r, int index, char[] arr, int cnt) {
		if (r == 0) {
			String s = "";
			for (int i = 0; i < index; i++) {
				s += arr[i];
			}
			if (flag == 0) {
				list.add(s);
			} else if (flag == 1 || flag == 2 || flag == 3) {
				if (list.contains(s)) {
					list.remove(s);
				}
			}
		} else if (n == cnt){
			return;
		} else {
			if (flag == 0)
				arr[index] = pw.get(cnt);
			else if (flag == 1)
				arr[index] = vowel.get(cnt);
			else if (flag == 2)
				arr[index] = cons.get(cnt);
			else if (flag == 3)
				arr[index] = mix.get(cnt);
			combination(flag, n, r - 1, index + 1, arr, cnt + 1);
			combination(flag, n, r, index, arr, cnt + 1);
		}
	}
}
