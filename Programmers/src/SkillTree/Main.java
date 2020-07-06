package SkillTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String skill = "ZXN";
		String[] skill_trees = {"ABCDE", "BCDEA", "CDAE"};
		
		int answer = 0;
		int prev[] = new int[26];
		Arrays.fill(prev, -1);
		ArrayList<ArrayList<Character>> list = new ArrayList<>();
		List<Character> alpha = Arrays.asList(new Character[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
				'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' });
		for (int i = 0; i < 26; i++) {
			list.add(new ArrayList<Character>());
		}

		char pre = skill.charAt(0);
		int idx = 0;
		for (int j = 1; j < skill.length(); j++) {
			char next = skill.charAt(j);
			list.get(alpha.indexOf(next)).add(pre);
			prev[alpha.indexOf(pre)] = idx++;
			prev[alpha.indexOf(next)] = idx;
			pre = next;
		}
		boolean flag;
		
		for (int i = 0; i < skill_trees.length; i++) {
			flag = true;
			pre = skill_trees[i].charAt(0);
			if (prev[alpha.indexOf(pre)] > 0)
				continue;
			for (int j = 1; j < skill_trees[i].length(); j++) {
				char next = skill_trees[i].charAt(j);
				if (prev[alpha.indexOf(next)] < 0)
					continue;
				if (prev[alpha.indexOf(next)] == 0)
					pre = next;
				else {
					if (list.get(alpha.indexOf(next)).get(0) == pre)
						pre = next;
					else {
						flag = false;
						break;
					}
				}
			}
			if (flag)
				answer++;
		}

		System.out.println(answer);
	}

}