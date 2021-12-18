package BinarySearchTreeGUI;

import javax.swing.JButton;
import javax.swing.JPanel;


public class OperationButton extends Button {
	JButton Create = new JButton(), Random = new JButton(),  Insert = new JButton(),
			SkewedRight = new JButton(), SkewedLeft = new JButton(), Delete = new JButton();
	
	JButton Buttons[] = {Create, Random, Insert, Delete, SkewedRight, SkewedLeft};
	JPanel ButtonPanel = new JPanel();
	public OperationButton() {
		creatOperationButton();
	}
	public void creatOperationButton() {
		Create.setText("Create");
		Random.setText("Random");
		Insert.setText("Insert");
		Delete.setText("Delete");
		SkewedRight.setText("SkewedRight");
		SkewedLeft.setText("SkwedLeft");
		
		for(JButton button: Buttons) {
			button.setBackground(getBG_COLOR());
			//button.setFont(get_Font());
		}
		
	}

}
