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
		
		origin = new HashMap<>(); //���� ���ڿ� ���ĺ� ���
		other = new HashMap<>(); //�� ���ڿ� ���ĺ� ���
		
		init(origin); // A ~ Z�� ������ 0���� �ʱ�ȭ
		for(i=0;i<len;i++){
			ch = word.charAt(i);
			origin.replace(ch, origin.get(ch) + 1);
		}
		
		for(i=0;i<n;i++){
			init(other); // A ~ Z�� ������ 0���� �ʱ�ȭ
			len = (word = in.readLine()).length();
			for(j=0;j<len;j++){
				ch = word.charAt(j);
				other.replace(ch, other.get(ch) + 1);
			}
			if(isSimilarTo(other)) cnt++; //�����ϸ� cnt++
		}
		
		out.write(cnt+"");
		out.close();
		in.close();
	}
	
	/* HashMap�� {�빮�� ���ĺ�, 0} ���� ä�� */
	private static void init(HashMap<Character, Integer> hm){
		for(char ch='A';ch<='Z';ch++) hm.put(ch, 0);
	}
	
	/* �� ���ڿ��� ���ĺ� ���̰� 2 ���� && ���� ���̰� 1 �����̸� �����ϴ� */
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