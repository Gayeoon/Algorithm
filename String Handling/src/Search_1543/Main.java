package Search_1543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String paper_s = br.readLine();
		String word_s = br.readLine();
		
		char paper[] = paper_s.toCharArray();
		char word[] = word_s.toCharArray();
		boolean flag = false;
		int cnt = 0;
		
		for(int i=0; i<=paper.length-word.length; i++) {
			flag = false;
			if(paper[i] == word[0]) {
				flag = true;
				for(int j=1; j<word.length; j++) {
					if(paper[i+j] != word[j]) {
						flag = false;
						break;
					}
				}
			}
			if(flag) {
				cnt++;
				i += word.length-1;
			}
		}
		
		System.out.println(cnt);
	}

}
