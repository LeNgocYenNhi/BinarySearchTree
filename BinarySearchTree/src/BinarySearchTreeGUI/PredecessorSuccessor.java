package BinarySearchTreeGUI;

import javax.swing.JComboBox;

public class PredecessorSuccessor extends Button {
	JComboBox<String> _PredecessorSuccessor;
	
	public PredecessorSuccessor() {
		String [] items = {"Pred", "Succ"};
		_PredecessorSuccessor = new JComboBox<String>(items);
		_PredecessorSuccessor.setSelectedIndex(0);
		_PredecessorSuccessor.setBackground(getBG_COLOR());
		
		
	}

}
