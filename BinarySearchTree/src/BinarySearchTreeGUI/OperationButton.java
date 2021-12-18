package BinarySearchTreeGUI;

import javax.swing.JButton;
import javax.swing.JPanel;


public class OperationButton extends Button {
JButton Create = new JButton(), Random = new JButton(),  Insert = new JButton(), Delete = new JButton();
	
	JButton Buttons[] = {Create, Random, Insert, Delete};
	JPanel ButtonPanel = new JPanel();
	Speed SelectionSpeed = new Speed();
	TraversalItem traver = new TraversalItem();
	SearchItem search = new SearchItem();
	public OperationButton() {
		creatOperationButton();
	}
	public void creatOperationButton() {
		Create.setText("Create");
		Random.setText("Random");
		Insert.setText("Insert");
		Delete.setText("Delete");
		
		for(JButton button: Buttons) {
			button.setBackground(getBG_COLOR());
			//button.setFont(get_Font());
		}
		
	}

}
