package B_2067;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main{
	public static HashMap<Character, Integer> origin, other;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char ch;
		int i, j, len, cnt = 0, n = Integer.parseInt(in.readLine()) - 1;
		String word = in.readLine();
		len = word.length();
		
		origin = new HashMap<>(); //기준 문자열 알파벳 기록
		other = new HashMap<>(); //비교 문자열 알파벳 기록
		
		init(origin); // A ~ Z의 갯수를 0으로 초기화
		for(i=0;i<len;i++){
			ch = word.charAt(i);
			origin.replace(ch, origin.get(ch) + 1);
		}
		
		for(i=0;i<n;i++){
			init(other); // A ~ Z의 갯수를 0으로 초기화
			len = (word = in.readLine()).length();
			for(j=0;j<len;j++){
				ch = word.charAt(j);
				other.replace(ch, other.get(ch) + 1);
			}
			if(isSimilarTo(other)) cnt++; //유사하면 cnt++
		}
		
		out.write(cnt+"");
		out.close();
		in.close();
	}
	
	/* HashMap을 {대문자 알파벳, 0} 으로 채움 */
	private static void init(HashMap<Character, Integer> hm){
		for(char ch='A';ch<='Z';ch++) hm.put(ch, 0);
	}
	
	/* 두 문자열의 알파벳 차이가 2 이하 && 길이 차이가 1 이하이면 유사하다 */
	private static boolean isSimilarTo(HashMap<Character, Integer> other){
		int a, b, diff = 0, originLen = 0, otherLen = 0;
		for(char ch='A';ch<='Z';ch++){
			originLen += (a = origin.get(ch));
			otherLen += (b = other.get(ch));
			diff += Math.abs(a - b);
		}
		return diff<=2 && Math.abs(originLen-otherLen)<=1;
	}
}