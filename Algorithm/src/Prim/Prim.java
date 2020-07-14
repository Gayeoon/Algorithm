package Prim;

public class Prim {
	int size;
	String[] vertices;
	int[][] edge;
	String first;
	String[] t;
	String[] tv;
	int t_size = 0, tv_size = 0, s_size = 0;
	int[] small;
	int[][] mini;
	int sum = 0;

	public Prim(String[] args) {
		size = args.length;
		vertices = new String[size];
		t = new String[size];
		tv = new String[size];
		System.arraycopy(args, 0, vertices, 0, size);
		first = vertices[0];
		edge = new int[size][size];
		mini = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				edge[i][j] = -1;
				mini[i][j] = -1;
			}
		}
		small = new int[2 * size];
	}

	public void add(String v, String w, int e) {
		int i = index(v), j = index(w);
		edge[i][j] = edge[j][i] = e;
	}

	private int index(String v) {
		for (int i = 0; i < size; i++) {
			if (vertices[i].equals(v))
				return i;
		}
		return -size;
	}

	private int min(int[] small, int s) {
		// 간선 중 최소 가중치를 찾는 메소드
		for (int i = 0; i < s; i++) {
			for (int j = 0; j < s - i - 1; j++) {
				if (small[j] > small[j + 1]) {
					int temp = small[j];
					small[j] = small[j + 1];
					small[j + 1] = temp;
				}
			}
		}
		int temp = small[0];
		if (s != 0) {
			small[0] = small[s - 1];
		} // small[0]의 값을 꺼내고 삭제

		return temp;
	}

	public int union(int v, int w) {
		// 정점들이 사이클을 형성하는지 알아보는 메소드
		int count = 0;
		for (int i = 0; i <= tv_size; i++) {
			if (tv[i].equals(vertices[v])) {
				count++;
			}
			if (tv[i].equals(vertices[w])) {
				count++;
			}
		}
		if (count >= 2) {
			return 1;
			// 사이클을 형성할 경우
		}
		return 0;
	}

	public int[] check(int minimum) {
		// 최소 간선이 조건에 맞는지 확인하는 메소드
		int count = 0;
		int[] v = new int[2];
		v[0] = -1;
		for (int i = 0; i < size; i++) {
			if (count > 0) {
				break;
			}
			for (int j = 0; j < size; j++) {
				if (mini[i][j] == minimum) {
					edge[j][i] = edge[i][j] = mini[j][i] = mini[i][j] = -1;
					if (union(i, j) == 0) {
						v[0] = i;
						v[1] = j;
						count++;
						break;
					}
				}
			}
		}
		return v;
	}

	public void prim() {
		int edges = 0;

		System.out.println("w< , " + vertices[0] + "> = 0");

		while (edges != size - 1) {
			int minimum = 0;
			int[] v = new int[2];
			int count = 0;

			tv[tv_size] = first;
			// 정점을 방문하면 tv 배열에 저장한다.

			for (int i = 0; i < size; i++) {
				if (edge[index(first)][i] >= 0) {
					small[s_size] = edge[index(first)][i];
					s_size++;
					mini[index(first)][i] = edge[index(first)][i];
				}
			}
			minimum = min(small, s_size);
			// 가장 작은 간선을 minimum에 저장한다.
			s_size--;

			v = check(minimum);

			while (count == 0) {
				if (v[0] > -1) {
					// 조건에 해당되는 간선이 있을 경우
					System.out.println("w<" + vertices[v[0]] + ", " + vertices[v[1]] + "> = " + minimum);
					sum += minimum;
					t[t_size] = vertices[v[0]] + "," + vertices[v[1]];
					t_size++;
					tv_size++;
					first = vertices[v[1]];
					edges++;
					count++;
				} else {
					// 조건에 해당되는 간선이 없는 경우
					minimum = min(small, s_size);
					// 두번째로 작은 간선으로 반복한다.
					s_size--;
					v = check(minimum);
				}
			}

		}
		System.out.println("\nw<MST> = " + sum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prim g = new Prim(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I" });

		g.add("A", "B", 4);
		g.add("A", "H", 8);
		g.add("B", "C", 8);
		g.add("B", "H", 11);
		g.add("C", "I", 2);
		g.add("C", "F", 4);
		g.add("C", "D", 7);
		g.add("D", "E", 9);
		g.add("D", "F", 14);
		g.add("F", "G", 2);
		g.add("G", "I", 6);
		g.add("G", "H", 1);
		g.add("H", "I", 7);
		g.add("E", "F", 10);

		g.prim();
	}
}
