package BinarySearchTreeGUI;

import javax.swing.JComboBox;

public class RandomSelection extends Button {
	JComboBox<String> Selected;
	
	
	public RandomSelection() {
		String [] items = {"Random", "Right", "Left"};
		Selected = new JComboBox<String>(items);
		Selected.setSelectedIndex(0);
		Selected.setBackground(getBG_COLOR());
		Selected.setBounds(395, 5, 105, 32);
		Selected.setFont(get_Font());
	}
	
}
