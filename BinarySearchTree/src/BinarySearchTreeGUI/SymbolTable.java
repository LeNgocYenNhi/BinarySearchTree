package BinarySearchTreeGUI;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SymbolTable {
	OperationButton operButton = new OperationButton();
	Speed SelectionSpeed = new Speed();
	TraversalItem _TraversalItem = new TraversalItem();
	PredecessorSuccessor _PredecessorSuccessor = new PredecessorSuccessor();
	JPanel Panel = new JPanel();
	JTextField Input = new JTextField();
	
	public SymbolTable(){
		creatSymbolTable();
	}
	
	public void creatSymbolTable() {
		Panel.setBackground(Color.WHITE);
		Panel.add(Input);
		
		for(JButton button: operButton.Buttons) {
			Panel.add(button);
		}
		Panel.add(SelectionSpeed._Speed);
		Panel.add(_TraversalItem.SelectTraversal);
		Panel.add(_PredecessorSuccessor._PredecessorSuccessor);
		Input.setBounds(5, 5, 176, 27);
		Input.setBackground(Color.WHITE);
	}

}
