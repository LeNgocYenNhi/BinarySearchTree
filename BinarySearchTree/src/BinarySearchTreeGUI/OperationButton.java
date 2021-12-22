package BinarySearchTreeGUI;

import javax.swing.JButton;
import javax.swing.JPanel;


public class OperationButton extends Button {
	JButton Create = new JButton(), Insert = new JButton(),Lecture = new JButton(), Delete = new JButton();
	
	JButton Buttons[] = {Create, Insert, Delete, Lecture};
	JPanel ButtonPanel = new JPanel();
	public OperationButton() {
		creatOperationButton();
	}
	public void creatOperationButton() {
		Create.setText("Create");
		Insert.setText("Insert");
		Delete.setText("Delete");
		Lecture.setText("Lecture");
		
		int X_Label = 510, Y_Label = 5;
		int WIDTH_Label = 105, HEIGHT_Label = 35;
		for(JButton button: Buttons) {
			button.setFont(get_Font());
			//button.setForeground(Color.WHITE);
			button.setBackground(getBG_COLOR());
			button.setBounds(X_Label, Y_Label, WIDTH_Label, HEIGHT_Label);
			X_Label += 115;
		}
		
		
	}

}
