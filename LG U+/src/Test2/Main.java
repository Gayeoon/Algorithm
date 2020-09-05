package Test2;

import java.util.Arrays;
import java.util.HashMap;

class Sort implements Comparable<Sort>{
	int num;
	String alpha;
	
	Sort(int num, String alpha){
		this.num = num;
		this.alpha = alpha;
	}

	@Override
	public int compareTo(Sort s) {
		return this.alpha.compareTo(s.alpha);
	}
}

public class Main {

	public static void main(String[] args) {
		int[] numbers = {8, 6, 11};
		
		Sort[] arr = new Sort[numbers.length];
		
		HashMap<Character, String> hash = new HashMap<>();
		hash.put('0', "zero");
		hash.put('1', "one");
		hash.put('2', "two");
		hash.put('3', "three");
		hash.put('4', "four");
		hash.put('5', "five");
		hash.put('6', "six");
		hash.put('7', "seven");
		hash.put('8', "eight");
		hash.put('9', "nine");
		
		for(int i=0; i<numbers.length; i++) {
			String str = numbers[i]+"";
			String tmp = "";
			for(int s=0; s<str.length(); s++) {
				tmp += hash.get(str.charAt(s));
			}
			arr[i] = new Sort(numbers[i], tmp);
		}

		Arrays.sort(arr, null);
		
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i].num+" ");
		
	}

}
