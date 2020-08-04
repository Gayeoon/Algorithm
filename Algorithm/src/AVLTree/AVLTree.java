package AVLTree;

public class AVLTree {
	private int key, height;
	private AVLTree left, right;
	public static final AVLTree NIL = new AVLTree();

	public AVLTree(int key) {
		this.key = key;
		left = right = NIL;
	}

	private AVLTree() {
		left = right = this;
		height = -1;
	}

	private AVLTree(int key, AVLTree left, AVLTree right) {
		this.key = key;
		this.left = left;
		this.right = right;
		height = 1 + Math.max(left.height, right.height);
	}

	public int size() {
		if (this == NIL)
			return 0;
		return 1 + left.size() + right.size();
	}

	public String toString() {
		if (this == NIL)
			return "";
		return left + " " + key + " " + right;
	}

	public boolean add(int key) { // �־��� Ű�� �߰��ϴµ�
		int oldSize = size(); // �����ϸ� true ����
		grow(key);
		return size() > oldSize;
	}

	public AVLTree grow(int key) {
		if (this == NIL)
			return new AVLTree(key);
		if (key == this.key)
			return this; // prevent key duplication
		if (key < this.key)
			left = left.grow(key);
		else
			right = right.grow(key);
		rebalance();
		height = 1 + Math.max(left.height, right.height);
		return this;
	}

	public AVLTree find(AVLTree p) {
		while (p.right != NIL) {
			p = p.right;
		}
		return p;
	} // �����ļ��ڸ� ã�� �޼ҵ�

	public AVLTree delete(AVLTree tree, int key) {

		if (tree == NIL) {
			return NIL;
		}

		else if (tree.key > key) {
			tree.left = delete(tree.left, key);
			return tree;
			// ã�� key�� ���� ��Ʈ�� key ������ ���� ���
			// Ʈ���� �������� delete ������ �Ѵ�.
			// ���� ������ ������ tree�� ��ȯ�Ѵ�.

		} else if (tree.key < key) {
			tree.right = delete(tree.right, key);
			return tree;
			// ã�� key�� ���� ��Ʈ�� key ������ Ŭ ���
			// Ʈ���� ���������� delete ������ �Ѵ�.
			// ���� ������ ������ tree�� ��ȯ�Ѵ�.

		}

		if (tree.right == NIL) {
			if (tree.left == NIL) {
				tree = NIL;
				// ���� ����� ���
			} else {
				tree = tree.left;
				// ���� �ڽĸ� ���� ���
				// key�� �ִ� �ڸ��� key�� ���� �ڽ� Ʈ���� �ִ´�.
			}
		} else {
			if (tree.left == NIL) {
				tree = tree.right;
				// ������ �ڽĸ� ���� ���
				// key�� �ִ� �ڸ��� key�� ������ �ڽ� Ʈ���� �ִ´�.

			} else {
				// �ڽ��� �Ѵ� ���� ���

				AVLTree temp = find(tree.left);
				tree.key = temp.key;
				// ���� �ļ��� ã�Ƽ� �� key �ڸ��� �־��ش�.
				tree.left = delete(tree.left, temp.key);
				// ���� �ļ��ڸ� �����ϴ� �������� �ٲ۴�.
				// ���� �ļ��ڴ� Ʈ���� ���� �ڽ��� ���� ������ �ڽ��̹Ƿ� ���� Ʈ���� ���� ���� ���� �ִ´�.
			}
		}
		rebalance();
		// balance�� �ٽ� �����.

		return tree;
	}

	private void rebalance() {
		if (right.height > left.height + 1) {
			if (right.left.height > right.right.height)
				right.rotateRight();
			rotateLeft();
		} else if (left.height > right.height + 1) {
			if (left.right.height > left.left.height)
				left.rotateLeft();
			rotateRight();
		}
	}

	private void rotateLeft() {
		left = new AVLTree(key, left, right.left);
		key = right.key;
		right = right.right;
	}

	private void rotateRight() {
		right = new AVLTree(key, left.right, right);
		key = left.key;
		left = left.left;
	}
}
