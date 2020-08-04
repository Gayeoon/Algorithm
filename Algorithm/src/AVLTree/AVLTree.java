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

	public boolean add(int key) { // 주어진 키를 추가하는데
		int oldSize = size(); // 성공하면 true 리턴
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
	} // 중위후속자를 찾는 메소드

	public AVLTree delete(AVLTree tree, int key) {

		if (tree == NIL) {
			return NIL;
		}

		else if (tree.key > key) {
			tree.left = delete(tree.left, key);
			return tree;
			// 찾는 key의 값이 루트의 key 값보다 작을 경우
			// 트리의 왼쪽으로 delete 연산을 한다.
			// 삭제 연산이 끝나면 tree를 반환한다.

		} else if (tree.key < key) {
			tree.right = delete(tree.right, key);
			return tree;
			// 찾는 key의 값이 루트의 key 값보다 클 경우
			// 트리의 오른쪽으로 delete 연산을 한다.
			// 삭제 연산이 끝나면 tree를 반환한다.

		}

		if (tree.right == NIL) {
			if (tree.left == NIL) {
				tree = NIL;
				// 리프 노드일 경우
			} else {
				tree = tree.left;
				// 왼쪽 자식만 있을 경우
				// key가 있던 자리에 key의 왼쪽 자식 트리를 넣는다.
			}
		} else {
			if (tree.left == NIL) {
				tree = tree.right;
				// 오른쪽 자식만 있을 경우
				// key가 있던 자리에 key의 오른쪽 자식 트리를 넣는다.

			} else {
				// 자식이 둘다 있을 경우

				AVLTree temp = find(tree.left);
				tree.key = temp.key;
				// 중위 후속자 찾아서 그 key 자리에 넣어준다.
				tree.left = delete(tree.left, temp.key);
				// 중위 후속자를 삭제하는 연산으로 바꾼다.
				// 중위 후속자는 트리의 왼쪽 자식의 가장 오른쪽 자식이므로 왼쪽 트리에 삭제 연산 값을 넣는다.
			}
		}
		rebalance();
		// balance를 다시 맞춘다.

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
