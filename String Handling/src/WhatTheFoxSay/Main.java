package WhatTheFoxSay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = "";
		try {
			s = br.readLine();
			StringTokenizer test = new StringTokenizer(s, " ");
			int n = Integer.parseInt(test.nextToken());
			String[] result = new String[n];
			for(int i=0; i<n; i++) {
				result[i] = "";
				s = br.readLine();
				String str = s;
				
				HashMap<String, String> animal = new HashMap<>();
				while(true) {
					s=br.readLine();
					if(s.equals("what does the fox say?")) break;
					
					StringTokenizer st = new StringTokenizer(s, " ");
					String ani =  st.nextToken();
					st.nextToken();
					String cry = st.nextToken();
					
					animal.put(cry, ani);
				}
				
				String[] array = str.split(" ");
				
				for(int k=0; k<array.length; k++) {
					if(animal.containsKey(array[k])) continue;
					result[i] += array[k]+" ";
				}
			}

			for(int i=0; i<n; i++) {
				System.out.println(result[i]);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
