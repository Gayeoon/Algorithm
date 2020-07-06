package Suzi_7699;

/////////////////////////////////////////////////////////////////////////////////////////////
//�⺻ �����ڵ�� ���� �����ص� ���� �����ϴ�. ��, ����� ���� ����
//�Ʒ� ǥ�� ����� ���� �ʿ�� �����ϼ���.
//ǥ�� �Է� ����
//int a;
//double b;
//char g;
//String var;
//long AB;
//a = sc.nextInt();                           // int ���� 1�� �Է¹޴� ����
//b = sc.nextDouble();                        // double ���� 1�� �Է¹޴� ����
//g = sc.nextByte();                          // char ���� 1�� �Է¹޴� ����
//var = sc.next();                            // ���ڿ� 1�� �Է¹޴� ����
//AB = sc.nextLong();                         // long ���� 1�� �Է¹޴� ����
/////////////////////////////////////////////////////////////////////////////////////////////
//ǥ�� ��� ����
//int a = 0;                            
//double b = 1.0;               
//char g = 'b';
//String var = "ABCDEFG";
//long AB = 12345678901234567L;
//System.out.println(a);                       // int ���� 1�� ����ϴ� ����
//System.out.println(b); 		       						 // double ���� 1�� ����ϴ� ����
//System.out.println(g);		       						 // char ���� 1�� ����ϴ� ����
//System.out.println(var);		       				   // ���ڿ� 1�� ����ϴ� ����
//System.out.println(AB);		       				     // long ���� 1�� ����ϴ� ����
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.HashMap;

/*
����ϴ� Ŭ�������� Solution �̾�� �ϹǷ�, ������ Solution.java �� ����� ���� �����մϴ�.
�̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� �����غ� �� �ֽ��ϴ�.
*/
class Solution {
	static char arr[][];
	static int Dr[] = { -1, 1, 0, 0 };
	static int Dc[] = { 0, 0, -1, 1 };
	static boolean visit[][];
	static HashMap<Character, Integer> hash;
	static int max;

	public static void main(String args[]) throws Exception {
		/*
		 * �Ʒ��� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸκ��� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�. �������� �ۼ��� �ڵ带
		 * �׽�Ʈ �� ��, ���Ǹ� ���ؼ� input.txt�� �Է��� ������ ��, �� �ڵ带 ���α׷��� ó�� �κп� �߰��ϸ� ���� �Է��� ������ ��
		 * ǥ�� �Է� ��� ���Ϸκ��� �Է��� �޾ƿ� �� �ֽ��ϴ�. ���� �׽�Ʈ�� ������ ������ �Ʒ� �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �����ϴ�.
		 * ��, ä���� ���� �ڵ带 �����Ͻ� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ� ó�� �ϼž� �մϴ�.
		 */
//System.setIn(new FileInputStream("res/input.txt"));

		/*
		 * ǥ���Է� System.in ���κ��� ��ĳ�ʸ� ����� �����͸� �о�ɴϴ�.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
		 */

		int answer[] = new int[T];
		for (int test_case = 1; test_case <= T; test_case++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			arr = new char[r][c];
			visit = new boolean[r][c];
			hash = new HashMap<>();
			for (int i = 0; i < r; i++) {
				String temp = sc.next();
				for (int j = 0; j < c; j++) {
					arr[i][j] = temp.charAt(j);
				}
			}
			max = 1;
			visit[0][0] = true;
			hash.put(arr[0][0], 1);
			solve(0, 0, 1);
			answer[test_case - 1] = max;
		}
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.println("#" + test_case + " " + answer[test_case - 1]);
		}

	}

	static int solve(int row, int col, int cnt) {
		for (int i = 0; i < 4; i++) {
			int nr = row + Dr[i];
			int nc = col + Dc[i];

			if (nr < 0 || nr >= arr.length || nc < 0 || nc >= arr[0].length)
				continue;
			if (visit[nr][nc])
				continue;
			if (hash.containsKey(arr[nr][nc]))
				continue;
			visit[nr][nc] = true;
			hash.put(arr[nr][nc], 1);
			int result = solve(nr, nc, cnt + 1);
			max = Math.max(max, result);
			visit[nr][nc] = false;
			hash.remove(arr[nr][nc]);

		}
		return cnt;
	}
}