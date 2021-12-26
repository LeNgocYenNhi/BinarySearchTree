package BinarySearchTreeGUI;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Pseudocode {
	JPanel PseudocodePanel = new JPanel();
	JPanel PseudocodeInsertPanel = new JPanel();
	JPanel PseudocodeMinPanel = new JPanel();
	JPanel PseudocodeFindPanel = new JPanel();
	JPanel PseudocodeDeletePanel = new JPanel();
	Border border = BorderFactory.createLineBorder(new Color(240, 255, 240));

	JTextField[] InsLines = {
			new JTextField("if node is null"),
			new JTextField("insert node"),
			new JTextField("else"),
			new JTextField("if value is less than node"),
			new JTextField("recurse left"),
			new JTextField("else"),
			new JTextField("recurse right") };
	
	JTextField[] MinLines = {
			new JTextField("if this is null return empty"),
			new JTextField("if left != null"),
			new JTextField("go left"),
			new JTextField("else return this key") };
	
	JTextField[] MaxLines = {
			new JTextField("if this is null return empty"),
			new JTextField("if right != null"),
			new JTextField("go right"),
			new JTextField("else return this key") };
	
	JTextField[] FindLines = {
			new JTextField("if this == null"),
			new JTextField("return null"),
			new JTextField("else if this key == search value"),
			new JTextField("return this"),
			new JTextField("else if this key < search value"),
			new JTextField("search right"),
			new JTextField("esle search left") };

	JTextField [] DeleteLines = {
			new JTextField("search for v"),
			new JTextField("if v is a leaf"),
			new JTextField("delete a leaf"),
			new JTextField("else if v has 1 child"),
			new JTextField("bypass v"),
			new JTextField("else replace v with successor")};
	

	public Pseudocode() {
		initLines();
		MinLines();
		MaxLines();
		FindLines();
		deleteLines();
		
	}

	public void initLines() {
		int X_Label = 1100, Y_Label = 500;
		int WIDTH_Label = 315, HEIGHT_Label = 30;
		for (int i = 0; i < InsLines.length; i++) {
			InsLines[i].setBorder(border);
			InsLines[i].setBounds(X_Label, Y_Label, WIDTH_Label, HEIGHT_Label);
			InsLines[i].setFont(new Font("NewellsHand", Font.BOLD, 15));
			InsLines[i].setForeground(new Color(240, 255, 240));
			InsLines[i].setBackground(new Color(240, 255, 240));
			PseudocodeInsertPanel.add(InsLines[i]);
			Y_Label += 35;
		}

	}
	public void MinLines() {
		int X_Label = 1100, Y_Label = 600;
		int WIDTH_Label = 315, HEIGHT_Label = 30;
		for (int i = 0; i < MinLines.length; i++) {
			MinLines[i].setBounds(X_Label, Y_Label, WIDTH_Label, HEIGHT_Label);
			MinLines[i].setFont(new Font("NewellsHand", Font.BOLD, 15));
			MinLines[i].setForeground(new Color(240, 255, 240));
			MinLines[i].setBorder(border);
			MinLines[i].setBackground(new Color(240, 255, 240));
			PseudocodeMinPanel.add(MinLines[i]);
			Y_Label += 35;
		}
	}
	public void MaxLines() {
		int X_Label = 1100, Y_Label = 600;
		int WIDTH_Label = 315, HEIGHT_Label = 30;
		for (int i = 0; i < MaxLines.length; i++) {
			MaxLines[i].setBorder(border);
			MaxLines[i].setBounds(X_Label, Y_Label, WIDTH_Label, HEIGHT_Label);
			MaxLines[i].setFont(new Font("NewellsHand", Font.BOLD, 15));
			MaxLines[i].setForeground(new Color(240, 255, 240));
			MaxLines[i].setBackground(new Color(240, 255, 240));
			PseudocodeMinPanel.add(MaxLines[i]);
			Y_Label += 35;
		}
	}
	public void FindLines() {
		int X_Label = 1100, Y_Label = 500;
		int WIDTH_Label = 315, HEIGHT_Label = 30;
		for (int i = 0; i < FindLines.length; i++) {
			FindLines[i].setBorder(border);
			FindLines[i].setBounds(X_Label, Y_Label, WIDTH_Label, HEIGHT_Label);
			FindLines[i].setFont(new Font("NewellsHand", Font.BOLD, 15));
			FindLines[i].setForeground(new Color(240, 255, 240));
			FindLines[i].setBackground(new Color(240, 255, 240));
			PseudocodeMinPanel.add(FindLines[i]);
			Y_Label += 35;
		}
	}
	
	public void deleteLines() {
		int X_Label = 1100, Y_Label = 500;
		int WIDTH_Label = 315, HEIGHT_Label = 30;
		for (int i = 0; i < DeleteLines.length; i++) {
			DeleteLines[i].setBorder(border);
			DeleteLines[i].setBounds(X_Label, Y_Label, WIDTH_Label, HEIGHT_Label);
			DeleteLines[i].setFont(new Font("NewellsHand", Font.BOLD, 15));
			DeleteLines[i].setForeground(new Color(240, 255, 240));
			DeleteLines[i].setBackground(new Color(240, 255, 240));
			PseudocodeDeletePanel.add(DeleteLines[i]);
			Y_Label += 35;
		}
		
	}
	

	public void InsVisible() {
		for (int i = 0; i < InsLines.length; i++) {
			InsLines[i].setForeground(Color.BLACK);
		}
	}

	public void InsInvisible() {
		for (int i = 0; i < InsLines.length; i++) {
			InsLines[i].setForeground(Color.WHITE);
		}
		
	}
	
	public void DeleteVisible() {
		for (int i = 0; i < DeleteLines.length; i++) {
			DeleteLines[i].setForeground(Color.BLACK);
		}
	}

	public void DeleteInvisible() {
		for (int i = 0; i < DeleteLines.length; i++) {
			DeleteLines[i].setForeground(Color.WHITE);
		}
		
	}
	
	public void MinVisible() {
		for (int i = 0; i < MinLines.length; i++) {
			MinLines[i].setForeground(Color.BLACK);
		}
	}

	public void MinInvisible() {
		for (int i = 0; i < MinLines.length; i++) {
			MinLines[i].setForeground(Color.WHITE);
		}
	}
	public void MaxVisible() {
		for (int i = 0; i < MaxLines.length; i++) {
			MaxLines[i].setForeground(Color.BLACK);
		}
	}

	public void MaxInvisible() {
		for (int i = 0; i < MaxLines.length; i++) {
			MaxLines[i].setForeground(Color.WHITE);
		}
	}
	public void FindVisible() {
		for (int i = 0; i < FindLines.length; i++) {
			FindLines[i].setForeground(Color.BLACK);
		}
	}

	public void FindInvisible() {
		for (int i = 0; i < FindLines.length; i++) {
			FindLines[i].setForeground(Color.WHITE);
		}
	}
	

}