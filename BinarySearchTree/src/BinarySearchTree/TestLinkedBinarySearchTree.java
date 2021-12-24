package BinarySearchTree;

import java.io.IOException;

public class TestLinkedBinarySearchTree {
	public static void main(String[] args) throws IOException {
		LinkedBinarySearchTree<Integer> binarySearchTree = new LinkedBinarySearchTree<Integer>();
		binarySearchTree.addRoot(12);
		binarySearchTree.add(4);
		binarySearchTree.add(15);
		binarySearchTree.add(7);
		binarySearchTree.add(28);
		binarySearchTree.add(72);
		binarySearchTree.add(1);
		System.out.println("Address of root is: " + binarySearchTree.getRoot());
		System.out.println("Value of root is: " + binarySearchTree.getRoot().getValue());
		System.out.println("Address of left child root is: " + binarySearchTree.getRoot().getLeft());
		System.out.println("Value of left child root is: " + binarySearchTree.getRoot().getLeft().getValue());
		System.out.println("Value of left child of left root is: " + binarySearchTree.getRoot().getLeft().getLeft().getValue());
		System.out.println("Address of right child root is: " + binarySearchTree.getRoot().getRight());
		System.out.println("Value of right child root is: " + binarySearchTree.getRoot().getRight().getValue());
		System.out.println("Max is: " + binarySearchTree.Max());
		System.out.println("Min is: " + binarySearchTree.Min());
		System.out.println("Size is: " + binarySearchTree.getCount());
		System.out.println("Height tree is: " + binarySearchTree.getHeight(binarySearchTree.getRoot()));
		System.out.println("Preorder traversal: " + binarySearchTree.preorder(binarySearchTree.getRoot()));
		System.out.println("Inorder traversal: " + binarySearchTree.inorder(binarySearchTree.getRoot()));
		System.out.println("Postorder traversal: " + binarySearchTree.postorder(binarySearchTree.getRoot()));
		binarySearchTree.printFile();
	}
}
