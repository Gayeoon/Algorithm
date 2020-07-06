package SortByAge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Member implements Comparable<Member> {
	int age;
	String name;

	Member(int age, String name) {
		this.age = age;
		this.name = name;
	}

	@Override
	public int compareTo(Member m) {
		if (this.age < m.age) {
			return -1;
		} else if (this.age == m.age)
			return 0;
		else
			return 1;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		List<Member> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int age = input.nextInt();
			String name = input.next();
			list.add(new Member(age, name));
		}

		list.sort(null);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).age + " " + list.get(i).name);
		}
	}
}
