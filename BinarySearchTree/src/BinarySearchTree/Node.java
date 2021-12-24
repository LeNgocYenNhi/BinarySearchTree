package BinarySearchTree;

public class Node<T> {
	Node<T> Parent;
	Node<T> Left;
	Node<T> Right;
	T Value;
	
	public Node(){
		Right = null;
		Left = null;
	}
	
	public Node(T Value) {
		this.Value = Value;
		Right = null;
		Left = null;
	}
	public Node(T e, Node<T> above, Node<T> leftChild, Node<T> rightChild) {	
		Value = e;
		Parent = above;
		Left = leftChild;
		Right = rightChild;
	}
	

	public Node<T> getParent() {
		return Parent;
	}

	public void setParent(Node<T> parent) {
		Parent = parent;
	}

	public Node<T> getLeft() {
		return Left;
	}

	public void setLeft(Node<T> left) {
		Left = left;
	}

	public Node<T> getRight() {
		return Right;
	}

	public void setRight(Node<T> right) {
		Right = right;
	}
	
	public T getValue() {
		return Value;
	}

	public void setValue(T value) {
		Value = value;
	}

	public int getHeight() {
		int leftHeight = 0;
		int rightHeight = 0;

		if (this.Left != null) {
			leftHeight = this.Left.getHeight();
		}
		if (this.Right != null) {
			rightHeight = this.Right.getHeight();
		}
		return 1 + Math.max(leftHeight, rightHeight);
	}

	public int getSize() {
		int leftSize = 0;
		int rightSize = 0;

		if (this.Left != null) {
			leftSize = this.Left.getSize();
		}
		if (this.Right != null) {
			rightSize = this.Right.getSize();
		}

		return 1 + leftSize + rightSize;
	}
	
}