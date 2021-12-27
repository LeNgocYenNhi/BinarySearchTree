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
			new JTextField("by pass v"),
			new JTextField("else replace v with predecessor")};
	

	public Pseudocode() {
		InsertLines();
		MinLines();
		MaxLines();
		FindLines();
		deleteLines();
		
	}

	public void InsertLines() {
		int X_TextField = 1100, Y_TextField = 500;
		int WIDTH_TextField = 315, HEIGHT_TextField= 30;
		for (int i = 0; i < InsLines.length; i++) {
			InsLines[i].setBorder(border);
			InsLines[i].setBounds(X_TextField, Y_TextField, WIDTH_TextField , HEIGHT_TextField );
			InsLines[i].setFont(new Font("NewellsHand", Font.BOLD, 18));
			InsLines[i].setForeground(new Color(240, 255, 240));
			InsLines[i].setBackground(new Color(240, 255, 240));
			PseudocodeInsertPanel.add(InsLines[i]);
			InsLines[i].setEditable(false);
			Y_TextField  += 35;
		}

	}
	public void MinLines() {
		int X_TextField = 1100, Y_TextField = 600;
		int WIDTH_TextField = 315, HEIGHT_TextField= 30;
		for (int i = 0; i < MinLines.length; i++) {
			MinLines[i].setBounds(X_TextField, Y_TextField, WIDTH_TextField, HEIGHT_TextField);
			MinLines[i].setFont(new Font("NewellsHand", Font.BOLD, 18));
			MinLines[i].setForeground(new Color(240, 255, 240));
			MinLines[i].setBorder(border);
			MinLines[i].setBackground(new Color(240, 255, 240));
			MinLines[i].setEditable(false);
			PseudocodeMinPanel.add(MinLines[i]);
			Y_TextField += 40;
		}
	}
	public void MaxLines() {
		int X_TextField = 1100, Y_TextField = 600;
		int WIDTH_TextField = 315, HEIGHT_TextField= 30;
		for (int i = 0; i < MaxLines.length; i++) {
			MaxLines[i].setBorder(border);
			MaxLines[i].setBounds(X_TextField, Y_TextField, WIDTH_TextField, HEIGHT_TextField);
			MaxLines[i].setFont(new Font("NewellsHand", Font.BOLD, 18));
			MaxLines[i].setForeground(new Color(240, 255, 240));
			MaxLines[i].setBackground(new Color(240, 255, 240));
			MaxLines[i].setEditable(false);
			PseudocodeMinPanel.add(MaxLines[i]);
			Y_TextField += 40;
		}
	}
	public void FindLines() {
		int X_TextField = 1050, Y_TextField = 500;
		int WIDTH_TextField = 315, HEIGHT_TextField= 30;
		for (int i = 0; i < FindLines.length; i++) {
			FindLines[i].setBorder(border);
			FindLines[i].setBounds(X_TextField, Y_TextField, WIDTH_TextField, HEIGHT_TextField);
			FindLines[i].setFont(new Font("NewellsHand", Font.BOLD, 18));
			FindLines[i].setForeground(new Color(240, 255, 240));
			FindLines[i].setBackground(new Color(240, 255, 240));
			FindLines[i].setEditable(false);
			PseudocodeMinPanel.add(FindLines[i]);
			Y_TextField += 35;
		}
	}
	
	public void deleteLines() {
		int X_TextField = 1050, Y_TextField = 540;
		int WIDTH_TextField = 315, HEIGHT_TextField= 30;
		for (int i = 0; i < DeleteLines.length; i++) {
			DeleteLines[i].setBorder(border);
			DeleteLines[i].setBounds(X_TextField, Y_TextField, WIDTH_TextField, HEIGHT_TextField);
			DeleteLines[i].setFont(new Font("NewellsHand", Font.BOLD, 18));
			DeleteLines[i].setForeground(new Color(240, 255, 240));
			DeleteLines[i].setBackground(new Color(240, 255, 240));
			DeleteLines[i].setEditable(false);
			PseudocodeDeletePanel.add(DeleteLines[i]);
			Y_TextField += 35;
		}
		
	}
	
	
	public void Visible(JTextField [] textfield) {
		for (int i = 0; i < textfield.length; i++) {
			textfield[i].setForeground(Color.BLACK);
		}
	}

	public void Invisible(JTextField [] textfield) {
		for (int i = 0; i < textfield.length; i++) {
			textfield[i].setForeground(new Color(240, 255, 240));
		}
		
	}
	
	

}