package BinarySearchTree;

import java.io.IOException;

public class TestArrayBinarySearchTree {
	public static void main(String[] args) throws IOException  {
		ArrayBinarySearchTree<Integer> binarySearchTree = new ArrayBinarySearchTree<Integer>();
		binarySearchTree.insert(12);
		binarySearchTree.insert(4);
		binarySearchTree.insert(15);
		binarySearchTree.insert(28);
		binarySearchTree.insert(1);
		System.out.println("Root is: " + binarySearchTree.root());
		System.out.println("Index left child root is: " + binarySearchTree.left(1));
		System.out.println("Value left child root is: " + binarySearchTree.getValue(binarySearchTree.left(1)));
		binarySearchTree.find(12);
		System.out.print("Preorder Traversal: ");
		binarySearchTree.Preorder(1);
		System.out.println();
		System.out.print("Inorder Traversal: ");
		binarySearchTree.Inorder(1);
		System.out.println();
		binarySearchTree.delete(4);
		System.out.println("Max is: " + binarySearchTree.findMax(1));
		System.out.println("Min is: " + binarySearchTree.Min());
		
		/*System.out.println("Left child of root is: " + binarySearchTree.getValue(binarySearchTree.left(1)));
		System.out.println("Index right child of index 2 in tree is: " + binarySearchTree.right(2));
		*/System.out.println("Value of right child of index 2 in tree is: " + binarySearchTree.getValue(binarySearchTree.right(2)));
		System.out.println("Size of tree is: " + binarySearchTree.size());
		System.out.println("Last index of tree is: " + binarySearchTree.lastIndex);
		for(int i = 1; i <= 7; i++) {
			System.out.println("Index " + i + " value " + binarySearchTree.getValue(i));
		}
		
		
		
		
			
		
	}
	

}
