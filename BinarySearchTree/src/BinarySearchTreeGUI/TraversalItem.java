package BinarySearchTreeGUI;

import java.awt.Color;

import javax.swing.JComboBox;

public class TraversalItem extends Button {
	JComboBox<String> SelectTraversal;
	
	public TraversalItem() {
		String [] items = {"Preorder", "Inorder", "Postorder"};
		SelectTraversal = new JComboBox<String>(items);
		SelectTraversal.setSelectedIndex(0);
		SelectTraversal.setBackground(getBG_COLOR());
		SelectTraversal.setForeground(Color.WHITE);
		SelectTraversal.setFont(get_Font());
		SelectTraversal.setBounds(970, 5, 105, 32);

		
	}

}
