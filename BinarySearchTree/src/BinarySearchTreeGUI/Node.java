package BinarySearchTreeGUI;

public class Node {
	private int Value;
	private int X = 0;
	private int Y = 0;

	Node(int value) {
		this.Value = value;
		
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


}