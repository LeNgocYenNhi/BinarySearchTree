package BinarySearchTreeGUI;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SymbolTable extends Button{
	JPanel Panel = new JPanel();
	OperationButton operButton = new OperationButton();
	Speed SelectionSpeed = new Speed();
	TraversalItem _TraversalItem = new TraversalItem();
	JTextField Input = new JTextField();
	SearchItem _SearchItem = new SearchItem();
	RandomSelection _Rand = new RandomSelection();
	
	public SymbolTable(){
		creatSymbolTable();
	}
	
	public void creatSymbolTable() {
		Input.setBounds(5, 5, 230, 35);
		Input.setBackground(Color.WHITE);
		Input.setFont(new Font("NewellsHand", Font.PLAIN, 17));
		Panel.add(Input);
		for(JButton button: operButton.Buttons) {
			Panel.add(button);
		}
		Panel.add(SelectionSpeed._Speed);
		Panel.add(_TraversalItem.SelectTraversal);
		Panel.add(_SearchItem.SelectSearch);
		Panel.add(_Rand.Selected);
		
	}

}
