package Huffman;

import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;

public class Huffman {
	HeapPriorityQueue queue = new HeapPriorityQueue();
	HashMap map = new HashMap();

	int size = 0;
	char[] alpha = new char[30];
	int[] freq = new int[30];
	huffmanTree tree;
	String finalBit = null;

	public void add(char alphabet) {
		if (map.containsKey(alphabet)) {
			int temp = (int) map.get(alphabet);
			temp = temp + 1;
			map.put(alphabet, temp);
		} else {
			map.put(alphabet, 1);
			alpha[size] = alphabet;
			size++;
		}
	}

	public void insertQueue() {
		for (int i = 0; i < size; i++) {
			queue.add(new trecord(alpha[i], (int) map.get(alpha[i])));
		}
	}

	public char[] sort(char alpha[]) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size - i - 1; j++) {
				if (alpha[j] > alpha[j + 1]) {
					char temp = alpha[j];
					alpha[j] = alpha[j + 1];
					alpha[j + 1] = temp;
				}
			}
		}
		return alpha;
	}

	public void makeHuffman() {
	// ������ Ʈ���� ����� �޼ҵ�
		while (queue.size() != 1) {
			trecord first = (trecord) queue.remove();

			if (first.huftree != null) {
				huffmanTree first_tree = first.huftree;
				trecord second = (trecord) queue.remove();
				huffmanTree s;

				if (second.huftree != null) {
					huffmanTree second_tree = second.huftree;
					s = second_tree;
					// �� �� Ʈ���� ���
				} else {
					s = new huffmanTree(second);
					// ù��° ����ġ�� Ʈ������ �ι�° ����ġ�� Ʈ���� �ƴ� ���
				}
				huffmanTree f = first_tree;

				huffmanTree root = new huffmanTree(null, f, s);
				// �ϳ��� Ʈ���� �����ش�.
				int root_value = first.getFreq() + second.getFreq();

				queue.add(new trecord(root, root_value));
			}

			else {
				trecord second = (trecord) queue.remove();
				huffmanTree s;
				if (second.huftree != null) {
					huffmanTree second_tree = second.huftree;
					s = second_tree;
				// ù��° ����ġ�� Ʈ���� �ƴ����� �ι�° ����ġ�� Ʈ���� ���
				} else {
					s = new huffmanTree(second);
				} // �� �� Ʈ���� �ƴ� ���
				huffmanTree f = new huffmanTree(first);

				huffmanTree root = new huffmanTree(null, f, s);
				int root_value = first.getFreq() + second.getFreq();

				queue.add(new trecord(root, root_value));
			}
		}

		trecord temp = (trecord) queue.remove();
		tree = temp.huftree;

	}

	public void frequencyPrint() {
		sort(alpha);
		System.out.println("<<<<< Frequency >>>>>");
		for (int i = 0; i < size; i++) {
			System.out.println(alpha[i] + " : " + map.get(alpha[i]));
		}
	} // �󵵼��� ����Ʈ�Ѵ�.

	public void huffmanPrint() {
		System.out.println("<<<<< Huffman Code >>>>>");
		for (int i = 0; i < size; i++) {
			System.out.print(alpha[i] + " : ");
			find(alpha[i]);
			System.out.println();
		}
	} // ������ �ڵ带 ����Ʈ�Ѵ�.
	
	public void find(char a) {
		String temp = findBit(a, tree, "");
		char[] bit = new char[20];
		if (temp.charAt(0) == '0') {
			for (int i = 1; i < temp.length(); i++) {
				System.out.print(temp.charAt(i));
			}
		} else {
			System.out.print(temp);
		}
	} // ã�� ��Ʈ�� ����Ʈ �ϴ� �޼ҵ�

	public String findBit(char a, huffmanTree tree, String bit) {
		if (tree.left == null && tree.right == null) {
			if (((trecord) tree.root).getAlphabet() == a) {
				finalBit = bit;
				return finalBit;
			} else {
				return "";
			}
		}

		findBit(a, tree.left, bit + "0");
		findBit(a, tree.right, bit + "1");
		if (finalBit != null) {
			return finalBit;
		}
		return bit;
	} // ��Ʈ�� ã�� �޼ҵ�

	public void print() {
		System.out.println(queue);
	}
}

class huffmanTree {
	public Object root;
	public huffmanTree left;
	public huffmanTree right;

	public huffmanTree(Object root) {
		this.root = root;
	}

	public huffmanTree(Object root, huffmanTree left, huffmanTree right) {
		this.root = root;
		this.left = left;
		this.right = right;
	}

	public huffmanTree(huffmanTree that) {
		this.root = that.root;
	}

	public Object getRoot() {
		return root;
	}

}

class trecord implements Comparable {
	private trecord lchild;
	private char alphabet;
	public huffmanTree huftree;
	private int freq;
	private trecord rchild;

	public trecord(char alphabet, int freq) {
		this.setAlphabet(alphabet);
		this.setFreq(freq);
	}

	public trecord(huffmanTree root, int freq) {
		this.huftree = root;
		this.setFreq(freq);
	}

	@Override
	public int compareTo(Object object) {
		// TODO Auto-generated method stub
		if (!(object instanceof trecord)) {
			throw new IllegalArgumentException();
		}
		trecord that = (trecord) object;
		return that.getFreq() - this.getFreq();
	}

	public String toString() {
		return getAlphabet() + " : " + getFreq();
	}

	public char getAlphabet() {
		return alphabet;
	}

	public void setAlphabet(char alphabet) {
		this.alphabet = alphabet;
	}

	public int getFreq() {
		return freq;
	}

	public void setFreq(int freq) {
		this.freq = freq;
	}

}
