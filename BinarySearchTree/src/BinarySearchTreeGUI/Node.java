package BinarySearchTreeGUI;

public class Node {
	private int Value;
	private int X = 0;
	private int Y = 0;
	
	Node left;
	Node right;
	
	Node(){
		right = null;
		left = null;
	}
	
	Node(int value) {
		this.Value = value;
		right = null;
		left = null;
	}

	public int getValue() {
		return Value;
	}

	public void setValue(int value) {
		Value = value;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

}
