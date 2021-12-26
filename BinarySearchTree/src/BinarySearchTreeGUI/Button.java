package BinarySearchTreeGUI;

import java.awt.Color;
import java.awt.Font;

public class Button {
	private int X, Y;
	private int WIDTH, HEIGHT;
	private Color BG_COLOR= new Color(66, 111, 66);
	private Font _Font = new Font("NewellsHand", Font.PLAIN, 18);
	
	public Button() {
		
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
	public int getWIDTH() {
		return WIDTH;
	}
	public void setWIDTH(int wIDTH) {
		WIDTH = wIDTH;
	}
	public int getHEIGHT() {
		return HEIGHT;
	}
	public void setHEIGHT(int hEIGHT) {
		HEIGHT = hEIGHT;
	}
	public Color getBG_COLOR() {
		return BG_COLOR;
	}
	public void setBG_COLOR(Color bG_COLOR) {
		BG_COLOR = bG_COLOR;
	}
	public Font get_Font() {
		return _Font;
	}
	public void set_Font(Font _Font) {
		this._Font = _Font;
	}

}