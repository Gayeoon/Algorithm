package Test2_5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] companies = { "A fabdec 2", "B cebdfa 2", "C ecfadb 2" };
		String[] applicants = { "a BAC 1", "b BAC 3", "c BCA 2", "d ABC 3", "e BCA 3", "f ABC 2" };
		
		ArrayList<LinkedList<String>> list = new ArrayList<>();
		ArrayList<Queue<Character>> apply = new ArrayList<>();
		HashMap<String, Integer> hash = new HashMap<>();
		String result[] = new String[companies.length];
		
		for (int i = 0; i < companies.length; i++) {
			list.add(new LinkedList<>());
			String str[] = companies[i].split(" ");
			hash.put(str[0], i);
			result[i] = str[0];
		}
		for (int i = 0; i < applicants.length; i++) {
			String[] str = applicants[i].split(" ");
			Queue<Character> queue = new LinkedList<>();
			for (int s = 0; s < Integer.parseInt(str[2]); s++) {
				queue.add(str[1].charAt(s));
			}
			apply.add(queue);
			hash.put(str[0], apply.size() - 1);
			char tmp = apply.get(apply.size() - 1).poll();

			list.get(hash.get(tmp + "")).add(str[0]);
		}

		boolean flag = true;
		while (flag) {
			flag = false;
			for (int i = 0; i < companies.length; i++) {
				String str[] = companies[i].split(" ");

				list.get(i).sort(new Comparator<String>() {
					@Override
					public int compare(String str1, String str2) {
						if (str[1].indexOf(str1) < str[1].indexOf(str2))
							return -1;
						else
							return 1;
					}
				});
				while (true) {
					if (list.get(i).size() <= Integer.parseInt(str[2])) 
						break;
					else {
						String tmp = list.get(i).removeLast();
						if(apply.get(hash.get(tmp)).isEmpty()) continue;
						char plus = apply.get(hash.get(tmp)).poll();

						list.get(hash.get(plus + "")).add(tmp);
						flag =true;
					}
				}
			}
		}
		
		String[] answer = new String[result.length];
		
		for(int i=0; i<result.length; i++) {
			list.get(i).sort(null);
			answer[i] = result[i]+"_";
			for(String s : list.get(i))
				answer[i] += s;
			
			System.out.println(answer[i]);
		}
		
		Arrays.sort(answer);
		
	}

}
