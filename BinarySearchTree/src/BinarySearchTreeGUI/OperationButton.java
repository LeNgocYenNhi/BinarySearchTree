package BinarySearchTreeGUI;

import javax.swing.JButton;
import javax.swing.JPanel;


public class OperationButton extends Button {
JButton Empty = new JButton(), Random = new JButton(),  Insert = new JButton(), Delete = new JButton(), Find = new JButton(), Save = new JButton();
	
	JButton Buttons[] = {Empty, Random, Insert, Delete, Find, Save};
	JPanel ButtonPanel = new JPanel();
	Speed SelectionSpeed = new Speed();
	TraversalItem traver = new TraversalItem();
	public OperationButton() {
		creatOperationButton();
	}
	public void creatOperationButton() {
		Empty.setText("Empty");
		Random.setText("Random");
		Insert.setText("Insert");
		Delete.setText("Delete");
		Find.setText("Find");
		Save.setText("Save");
		
		for(JButton button: Buttons) {
			button.setBackground(getBG_COLOR());
			//button.setFont(get_Font());
		}
		
	}

}
