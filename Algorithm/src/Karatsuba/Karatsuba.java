package Karatsuba;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Karatsuba {

	public static BigInteger combine(int x, int y) {
		BigInteger resultX = BigInteger.valueOf((long) x);
		BigInteger resultY = BigInteger.valueOf((long) y);

		resultX = resultX.multiply(resultY);

		return resultX;
	}

	public static BigInteger divide(int[] a, int[] b, int start, int end) {
		int mid = end / 2;

		int x2 = change(a, start, mid); // 뒷자리
		int x1 = change(a, mid + 1, end); // 앞자리
		int y2 = change(b, start, mid);
		int y1 = change(b, mid + 1, end);

		BigInteger z0;
		BigInteger z2;

		if(mid - start <= 1) {

			z2 = combine(x2, y2); // 앞자리
			z0 = combine(x1, y1); // 뒷자리

			BigInteger z1 = combine((x2 + x1), (y2 + y1));
			z1 = z1.subtract(z2).subtract(z0);

			z1 = z1.multiply(BigInteger.valueOf((long) Math.pow(10, mid+1)));
			z2 = z2.multiply(BigInteger.valueOf((long) Math.pow(10, (mid+1) * 2)));
			BigInteger result = z0.add(z1).add(z2);

			return result;

		}

		z2 = divide(a, b, start, mid);
		z0 = divide(a, b, mid+1, end);

		BigInteger z1 = combine((x2 + x1), (y2 + y1));
		z1 = z1.subtract(z2).subtract(z0);

		z1 = z1.multiply(BigInteger.valueOf((long) Math.pow(10, mid+1)));
		z2 = z2.multiply(BigInteger.valueOf((long) Math.pow(10, (mid+1) * 2)));
		BigInteger result = z0.add(z1).add(z2);

		return result;


	}

	public static int change(int[] array, int start, int end) {
		int n = end - start;
		int ten = 1;
		int result = 0;

		for (int i = end; i >= start; i--) {
			result += array[i] * ten;
			ten *= 10;
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] num1 = new int[30];
		int[] num2 = new int[30];
		int count1 = 0;
		int count2 = 0;

		/* 파일을 읽어오는 코드 */
		try {
			FileReader f = new FileReader("input.txt");

			BufferedReader b = new BufferedReader(f);
			String line = b.readLine();

			StringTokenizer parser1 = new StringTokenizer(line, "");
			String temp = parser1.nextToken();

			for (int i = 0; i < temp.length(); i++) {
				String num = Character.toString(temp.charAt(i));
				num1[count1] = Integer.parseInt(num);
				count1++;
			}

			line = b.readLine();

			StringTokenizer parser2 = new StringTokenizer(line, "");
			String temp2 = parser2.nextToken();

			for (int i = 0; i < temp2.length(); i++) {
				String num = Character.toString(temp2.charAt(i));
				num2[count2] = Integer.parseInt(num);
				count2++;
			}
		} catch (Exception e) {
			System.out.println("파일 읽기 실패");
		}

		System.out.print("Input Data : ");
		for (int i = 0; i < count1; i++) {
			System.out.print(num1[i] + " ");
		}
		System.out.println();
		System.out.print("\t     ");
		for (int i = 0; i < count2; i++) {
			System.out.print(num2[i] + " ");
		}
		System.out.println();

		System.out.println("Output : " + divide(num1, num2, 0, count1 - 1));

	}

}
