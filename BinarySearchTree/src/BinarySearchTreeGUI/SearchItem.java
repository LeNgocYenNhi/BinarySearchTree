package BinarySearchTreeGUI;

import javax.swing.JComboBox;

public class SearchItem extends Button {
	JComboBox<String> SelectSearch;
	
	public SearchItem() {
		String [] items = {"Find","Max", "Min"};
		SelectSearch = new JComboBox<String>(items);
		SelectSearch.setSelectedIndex(0);
		SelectSearch.setBackground(getBG_COLOR());
		SelectSearch.setBounds(280, 5, 105, 35);
		SelectSearch.setFont(get_Font());
		
	}

}
