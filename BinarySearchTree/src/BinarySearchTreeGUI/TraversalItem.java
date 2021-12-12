package BinarySearchTreeGUI;

import javax.swing.JComboBox;

public class TraversalItem extends Button {
	JComboBox<String> SelectTraversal;
	
	public TraversalItem() {
		String [] items = {"Preorder", "Inorder", "Postorder"};
		SelectTraversal = new JComboBox<String>(items);
		SelectTraversal.setSelectedIndex(0);
		SelectTraversal.setBackground(getBG_COLOR());
		
		
	}

}