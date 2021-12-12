package BinarySearchTreeGUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Pseudocode {
JPanel PseudocodePanel = new JPanel();
	
	JPanel PseudocodeInsertPanel = new JPanel();
	
	JLabel Line1 = new JLabel(), Line2 = new JLabel(), Line3 = new JLabel(),
				Line4 = new JLabel(), Line5 = new JLabel();

	JLabel [] Labels = {Line1, Line2, Line3, Line4, Line5};
	
	public Pseudocode() {
		creatPseudocodePanelInsert();
	}
	public void creatPseudocodePanelInsert() {
		Line1.setText("if insertion point is found");
		Line2.setText("create new vertex");
		Line3.setText("if value to be insert < this key");
		Line4.setText("go left");
		Line5.setText("else go right");
		
		/*
		 * Line1.setBounds(750, 500, 315, 40);
		 * Line2.setBounds(750, 540, 315, 40);
		 * Line3.setBounds(750, 580, 315, 40);
		 * Line4.setBounds(750, 620, 315, 40);
		 * Line5.setBounds(750, 660, 315, 40);
		 */
		
		int X_Label = 750, Y_Label = 500;
		int WIDTH_Label = 315, HEIGHT_Label = 40;
		for(JLabel label: Labels) {
			label.setFont(new Font("NewellsHand", Font.PLAIN, 17));
			label.setForeground(new Color(65, 136, 218));
			label.setBounds(X_Label, Y_Label, WIDTH_Label, HEIGHT_Label);
			label.setBackground(Color.WHITE);
			label.setOpaque(true);
			Y_Label += 40;
			PseudocodeInsertPanel.add(label);
			
		}
		
	}


}
