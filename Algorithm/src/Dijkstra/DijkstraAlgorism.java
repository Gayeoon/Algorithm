package Dijkstra;

class Dijkstra {

	class HeapPriorityQueue {
		private static final int CAPACITY = 20;
		private int[] a;
		private int size;

		public HeapPriorityQueue() {
			this(CAPACITY);
		}

		public HeapPriorityQueue(int capacity) {
			a = new int[capacity];
		}

		public void add(String x) {

			if (size == a.length)
				resize();
			int i = size++;
			while (i > 0) {
				int j = i;
				i = (i - 1) / 2;
				if (d[a[i]] <= d[index(x)]) {
					a[j] = index(x);
					return;
				}
				a[j] = a[i];
			}
			a[i] = index(x);
		}

		public Object best() {
			if (size == 0)
				throw new java.util.NoSuchElementException();
			return a[0];
		}

		public Object remove() {
			Object best = best();
			a[0] = a[--size];
			heapify(0, size);
			return best;
		}

		public int size() {
			return size;
		}

		public int view(int i) {
			return a[i];
		}

		private void heapify(int i, int n) {
			int ai = a[i];
			while (i < n / 2) {
				int j = 2 * i +1;
				if (j + 1 < n && d[a[j + 1]] <= d[a[j]])
					++j;
				if (d[a[j]] >= d[ai])
					break;
				a[i] = a[j];
				i = j;
			}
			a[i] = ai;
		}

		private void resize() {
			int[] aa = new int[2 * a.length];
			System.arraycopy(a, 0, aa, 0, a.length);
			a = aa;
		}
	}

	int inf = (int) Double.POSITIVE_INFINITY;
	int w[][];
	String s[];
	int s_size = 0;
	int d[];
	int size;
	String vertices[];

	HeapPriorityQueue queue = new HeapPriorityQueue();

	public Dijkstra(String[] args) {
		size = args.length;
		vertices = new String[size];
		s = new String[size];
		System.arraycopy(args, 0, vertices, 0, size);

		d = new int[size];
		w = new int[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == j) {
					w[i][j] = 0;
				} else {
					w[i][j] = inf;
				}
			}
			d[i] = inf;
		}

		d[index(vertices[0])] = 0;
	}

	public void add(String v, String m, int e) {
		int i = index(v), j = index(m);
		w[i][j] = e;
	}

	public int index(String v) {
		for (int i = 0; i < size; i++) {
			if (vertices[i].equals(v))
				return i;
		}
		return -size;
	}

	public void dijkstra() {
		int count = 5;
		
		HeapPriorityQueue queue = new HeapPriorityQueue();

		for (int i = 0; i < size; i++) {
			queue.add(vertices[i]);
		}

		while (s_size < 5) {
			String u = s[s_size] = vertices[(int) queue.best()];
			queue.remove();
			System.out.println("========================================");
			System.out.println("S[" + s_size + "] : d[" + u + "] = " + d[index(u)]);
			s_size++;

			System.out.println("----------------------------------------");
			for (int i = 0; i < queue.size; i++) {
				int v = queue.view(i);

				System.out.print("Q[" + i + "] : d[" + vertices[v] + "] = " + d[v]);
				
				if (d[index(u)] + w[index(u)][v] < d[v]) {
					if(d[index(u)] + w[index(u)][v] > 0) {
						d[v] = d[index(u)] + w[index(u)][v];
						System.out.print(" => d[" + vertices[v] + "] = " + d[v]);						
					}
				}
				System.out.println("\n");
			}
			count--;
			queue.heapify(0, count);
			
		}
	}
}

public class DijkstraAlgorism {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Dijkstra d = new Dijkstra(new String[] { "A", "B", "C", "D", "E" });

		d.add("A", "B", 10);
		d.add("A", "C", 3);
		d.add("B", "C", 1);
		d.add("B", "D", 2);
		d.add("C", "B", 4);
		d.add("C", "E", 2);
		d.add("C", "D", 8);
		d.add("D", "E", 7);
		d.add("E", "D", 9);
		
		System.out.println("dijkstra's algorithm\n");
		d.dijkstra();
	}

}
