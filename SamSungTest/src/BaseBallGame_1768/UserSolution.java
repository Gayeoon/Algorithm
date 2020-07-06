package BaseBallGame_1768;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class UserSolution {
	public final static int N = 4;
	static List<Integer> yes;
	static List<Integer> no;
	static List<Integer> num;

	public void doUserImplementation(int guess[]) {
		yes = new ArrayList<Integer>();
		no = new ArrayList<Integer>();
		num = new ArrayList<Integer>();
		int ball = 0;
		int strike = 0;
		boolean finish[] = new boolean[guess.length];
		Solution.Result result;
		int idx = 0;
		int index = guess.length;
		for (int i = 0; i < 10; i++) {
			num.add(i);
		}
		while (true) {
			for (int i = 0; i < 4; i++) {
				num.remove((Object) idx);
				guess[i] = idx++;
			}

			result = Solution.query(guess);
			if (result.strike == 0 && result.ball == 0)
				continue;
			else
				break;
		}
		int st = 0;
		idx--;
		boolean flag = true;
		int tmp = 0;
		strike = result.strike;
		ball = result.ball;
		LinkedList<Integer> tmpList = new LinkedList<>();
		while (true) {

			if (result.strike == 4)
				return;
			if (yes.size() + st == 4) {
				LinkedList<Integer> arr = new LinkedList<>();
				boolean[] check = new boolean[yes.size()];
				if (permu(arr, check, 0, yes.size(), guess, finish))
					return;
			}
			

			if (flag) {
				idx = findnum(idx);
				num.remove((Object) idx);
			}

			index = findidx(index - 1, finish, guess);

			tmp = guess[index];
			guess[index] = idx;

			result = Solution.query(guess);

			if (strike == result.strike && ball < result.ball) {
				if (!flag) {
					yes.addAll(tmpList);
					tmpList.clear();
					flag = true;
				}
				no.add(tmp);
				yes.add(guess[index]);

			} else if (strike < result.strike && ball == result.ball) {
				if (!flag) {
					yes.addAll(tmpList);
					tmpList.clear();
					flag = true;
				}
				no.add(tmp);
				finish[index] = true;
				st++;
			} else if (ball > result.ball && strike < result.strike) {
				if (!flag) {
					yes.addAll(tmpList);
					tmpList.clear();
					flag = true;
				}
				yes.add(tmp);
				int newindex = findidx(index - 1, finish, guess);
				if (!no.contains(guess[newindex]))
					num.add(guess[newindex]);
				guess[newindex] = guess[index];
				guess[index] = tmp;
				finish[index] = true;
				st++;
			} else if (ball < result.ball && strike > result.strike) {
				if (!flag) {
					yes.addAll(tmpList);
					tmpList.clear();
					flag = true;
				}
				yes.add(guess[index]);

				int newindex = findidx(index - 1, finish, guess);
				if (!no.contains(guess[newindex]))
					num.add(guess[newindex]);
				guess[newindex] = guess[index];
				guess[index] = tmp;
				finish[index] = true;
				st++;
			} else if (ball > result.ball) {
				if (!flag) {
					no.addAll(tmpList);
					tmpList.clear();
					flag = true;
				}
				yes.add(tmp);
				no.add(guess[index]);
				guess[index] = tmp;
			} else if (strike > result.strike) {

				if (!flag) {
					no.addAll(tmpList);
					tmpList.clear();
					flag = true;
				}
				no.add(guess[index]);

				guess[index] = tmp;
				finish[index] = true;
				st++;
			} else {
				if (no.contains(tmp)) {
					if (!tmpList.isEmpty()) {
						no.addAll(tmpList);
						tmpList.clear();
						flag = true;
					}
					no.add(guess[index]);
				} else if (yes.size() + st >= 3) {
					no.add(tmp);
					no.add(guess[index]);
				} else if (yes.size() + st + tmpList.size() + 1 >= 4) {
					no.addAll(tmpList);
					tmpList.clear();
					flag = true;
					no.add(guess[index]);
				} else {
					flag = false;
					idx = guess[index];
					guess[index] = tmp;
					tmpList.add(tmp);
				}
			}
		}

	}

	static boolean permu(LinkedList<Integer> arr, boolean[] check, int depth, int n, int[] guess, boolean[] finish) {
		if (depth == n) {
			int idx = 0;
			for (int i = 0; i < 4; i++) {
				if (finish[i])
					continue;
				guess[i] = arr.get(idx++);
			}
			Solution.Result result = Solution.query(guess);
			if (result.strike == 4)
				return true;
			else
				return false;
		}
		boolean result = false;
		for (int i = 0; i < n; i++) {
			if (!check[i]) {
				check[i] = true;
				arr.add(yes.get(i));
				result = permu(arr, check, depth + 1, n, guess, finish);
				if (result)
					return true;
				arr.removeLast();
				check[i] = false;
			}
		}
		return false;
	}

	static int findidx(int index, boolean[] finish, int[] guess) {
		while (true) {
			if (index < 0)
				index = finish.length - 1;
			if (finish[index])
				index--;
			else if (yes.contains(guess[index]))
				index--;
			else
				return index;
		}
	}

	static int findnum(int idx) {
		idx++;
		while (true) {
			if (idx > 9)
				idx = 1;
			if (num.contains(idx))
				return idx;
			else
				idx++;
		}

	}
}
