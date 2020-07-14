package Huffman;

public class HeapPriorityQueue {
	private static final int CAPACITY = 100;
	private Comparable[] a;
	private int size;

	public HeapPriorityQueue() {
		this(CAPACITY);
	}

	public HeapPriorityQueue(int capacity) {
		a = new Comparable[capacity];
	}

	public void add(Object object) {
		if (!(object instanceof Comparable))
			throw new IllegalArgumentException();
		Comparable x = (Comparable) object;
		
		if (size == a.length)
			resize();
		int i = size++;
		while (i > 0) {
			int j = i;
			i = (i - 1) / 2;
			if (a[i].compareTo(x) >= 0) {
				a[j] = x;
				return;
			}
			a[j] = a[i];
		}
		a[i] = x;
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

	public String toString() {
		if (size == 0)
			return "{}";
		StringBuffer buf = new StringBuffer("{" + a[0]);
		for (int i = 1; i < size; i++)
			buf.append("," + a[i]);
		return buf + "}";
	}

	private void heapify(int i, int n) {
		Comparable ai = a[i];
		while (i < n / 2) {
			int j = 2 * i + 1;
			if (j + 1 < n && a[j + 1].compareTo(a[j]) > 0)
				++j;
			if (a[j].compareTo(ai) <= 0)
				break;
			a[i] = a[j];
			i = j;
		}
		a[i] = ai;
	}

	private void resize() {
		Comparable[] aa = new Comparable[2 * a.length];
		System.arraycopy(a, 0, aa, 0, a.length);
		a = aa;
	}
}
