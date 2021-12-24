package BinarySearchTreeGUI;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ActionBar extends Button {
	OperationButton operButton = new OperationButton();
	Speed SelectionSpeed = new Speed();
	TraversalItem _TraversalItem = new TraversalItem();
	JPanel Panel = new JPanel();
	JTextField Input = new JTextField();
	
	public ActionBar(){
		creatActionBar();
	}
	
	public void creatActionBar() {
		Input.setBounds(5, 5, 230, 32);
		Panel.setBackground(Color.WHITE);
		Input.setFont(new Font("NewellsHand", Font.PLAIN, 18));
		Panel.add(Input);
		
		for(JButton button: operButton.Buttons) {
			Panel.add(button);
		}
		Panel.add(SelectionSpeed._Speed);
		Panel.add(_TraversalItem.SelectTraversal);
		
		//Panel.add(_Rand.Selected);
		Input.setBackground(Color.WHITE);
	}

}
