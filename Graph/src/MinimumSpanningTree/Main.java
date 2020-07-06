package MinimumSpanningTree;
import java.util.Scanner;

class MST {
	int size;
	int[][] edge;
	int[] tv;
	Edge[] E;
	int edge_size = 0;

	public class Edge {
		int edge_value;

		public Edge(int edge_value) {
			this.edge_value = edge_value;
		}
	}

	public MST(int s, int e) {
		size = s;
		edge = new int[size][size];
		E = new Edge[e];
		tv = new int[size];
		for (int i = 0; i < size; i++) {
			tv[i] = -1;
		}
	}

	public void add(int v, int w, int e) {
		edge[v - 1][w - 1] = e;
		edge[w - 1][v - 1] = e;
		E[edge_size] = new Edge(e);
		edge_size++;
	}

	public void weightedunion(int i, int j) {
		if (-tv[i] <= -tv[j]) {
			tv[j] = tv[i] + tv[j];
			tv[i] = j;
		} else {
			tv[i] = tv[i] + tv[j];
			tv[j] = i;
		}

	}

	public int collapsingfind(int i) {
		int num = 0;
		int[] child = new int[size];

		for (; tv[i] >= 0; i = tv[i]) {
			child[num] = i;
			num++;
		}

		for (int k = 0; k < num; k++) {
			tv[child[k]] = i;
		}

		return i;
	}

	public void sort(Edge[] e) {
		for (int i = 0; i < edge_size - 1; i++) {
			for (int j = 0; j < edge_size - 1 - i; j++) {
				if (e[j].edge_value > e[j + 1].edge_value) {
					int temp = e[j].edge_value;
					e[j].edge_value = e[j + 1].edge_value;
					e[j + 1].edge_value = temp;
				}
			}
		}
	}

	public void kruskal() {
		int vertice = 0;
		int count = 0;
		int sum = 0;
		int M = 0, N = 0;

		sort(E);
		for (int i = 0; i <= size; i++) {
			if (vertice == size - 1) {
				break;
			}
			count = 0;
			for (int m = 0; m < size; m++) {
				if (count > 0) {
					break;
				}
				for (int n = 0; n < size; n++) {
					if (E[i].edge_value == edge[m][n]) {
						edge[m][n] = -size;
						M = m;
						N = n;
						count++;
						break;
					}
				}
			}
			if (collapsingfind(M) != collapsingfind(N)) {
				weightedunion(collapsingfind(M), collapsingfind(N));
				vertice++;
				sum += (int) E[i].edge_value;
			}
		}
		if (vertice != size - 1) {
			System.out.println("신장트리를 만들 수 없습니다.");
		}
		System.out.println(sum);

	}

}

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int v = input.nextInt();
		int e = input.nextInt();

		int edge[][] = new int[v][v];

		MST g = new MST(v, e);

		for (int i = 0; i < e; i++) {
			int a = input.nextInt();
			int b = input.nextInt();
			int val = input.nextInt();
			g.add(a, b, val);
		}
		g.kruskal();
	}
}
