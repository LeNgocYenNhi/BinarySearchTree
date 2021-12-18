package BinarySearchTreeGUI;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SymbolTable {
	OperationButton operButton = new OperationButton();
	Speed SelectionSpeed = new Speed();
	TraversalItem _TraversalItem = new TraversalItem();
	JPanel Panel = new JPanel();
	JTextField Input = new JTextField();
	SearchItem _SearchItem = new SearchItem();
	
	public SymbolTable(){
		creatSymbolTable();
	}
	
	public void creatSymbolTable() {
		Panel.setBackground(Color.WHITE);
		Panel.add(Input);
		
		for(JButton button: operButton.Buttons) {
			Panel.add(button);
		}
		Panel.add(_SearchItem.SelectSearch);
		Panel.add(SelectionSpeed._Speed);
		Panel.add(_TraversalItem.SelectTraversal);
		Input.setBounds(5, 5, 176, 27);
		Input.setBackground(Color.WHITE);
	}

}
