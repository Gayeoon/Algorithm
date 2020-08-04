package AVLTree;

public class TestAVLTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AVLTree tree = new AVLTree(44);
		tree.add(88);
		tree.add(55);
		tree.add(77);
		tree.add(33);
		tree.add(99);
		tree.add(66);
		tree.add(22);
		tree.add(25);
		tree.add(75);
		System.out.println(tree);
		
		tree.delete(tree, 25);
		tree.delete(tree, 55);
		tree.delete(tree, 75);
		tree.delete(tree, 44);
		tree.delete(tree, 88);
		System.out.println(tree);
	}

}
