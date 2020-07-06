package Friends4Block;

public class Main {

	static boolean visit[][];
	static int M, N;
	static String[][] sboard;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 6;
		int n = 6;
		String[] board = { "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		int answer = 0;
		visit = new boolean[m][n];
		M = m;
		N = n;
		sboard = new String[M][N];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				sboard[i][j] = board[i].charAt(j) + "";
			}
		}
		boolean dir[] = new boolean[4];
		boolean flag = true;
		int count = 0;
		while (flag) {
			for (int i = 0; i < m - 1; i++) {
				for (int j = 0; j < n - 1; j++) {
					if (sboard[i][j].equals(""))
						continue;
					if (check(i, j, sboard[i][j]))
						count++;
				}
			}
			if (count > 0)
				flag = true;
			else
				flag = false;
			count = 0;
			answer += bomb();
		}
		System.out.println(answer);
	}

	static boolean check(int row, int col, String target) {
		int Dr[] = { 0, 1, 1 };
		int Dc[] = { 1, 1, 0 };
		for (int i = 0; i < 3; i++) {
			int nr = row + Dr[i];
			int nc = col + Dc[i];
			if (nr < 0 || nr >= M || nc < 0 || nc >= N)
				continue;
			if (sboard[nr][nc].equals(""))
				return false;
			if (!sboard[nr][nc].equals(target))
				return false;
		}
		visit[row][col] = true;
		for (int i = 0; i < 3; i++) {
			int nr = row + Dr[i];
			int nc = col + Dc[i];
			visit[nr][nc] = true;
		}
		return true;

	}

	static int bomb() {
		int cnt = 0;
		String temp[] = new String[N];
		for (int j = 0; j < N; j++) {
			String tmp = "";
			boolean flag = false;
			for (int i = M - 1; i >= 0; i--) {
				if (sboard[i][j].equals(""))
					continue;
				if (visit[i][j]) {
					cnt++;
					flag = true;
					continue;
				}
				if (flag) {
					tmp += sboard[i][j];
				}
			}
			temp[j] = tmp;
		}
		for (int j = 0; j < N; j++) {
			boolean flag = false;
			int idx = 0;
			for (int i = M - 1; i >= 0; i--) {
				if (sboard[i][j].equals(""))
					continue;
				if(!flag && !visit[i][j]) continue;
				if (visit[i][j]) {
					visit[i][j] = false;
					flag = true;
				}
				if (flag && idx < temp[j].length()) {
					sboard[i][j] = temp[j].charAt(idx) + "";					
					idx++;
				} else if (idx == temp[j].length())
					sboard[i][j] = "";
			}
		}
		return cnt;
	}
}
