package BinarySearchTreeGUI;

import javax.swing.JButton;
import javax.swing.JPanel;


public class OperationButton extends Button {
	JButton Insert = new JButton(), Delete = new JButton(), Find = new JButton(), 
				Max = new JButton(), Min = new JButton(), Lecture = new JButton();
	
	JButton Buttons[] = {Insert, Delete, Find, Max, Min, Lecture};
	JPanel ButtonPanel = new JPanel();
	Speed SelectionSpeed = new Speed();
	TraversalItem traver = new TraversalItem();
	public OperationButton() {
		creatOperationButton();
	}
	public void creatOperationButton() {
		Insert.setText("Insert");
		Delete.setText("Delete");
		Find.setText("Find");
		Max.setText("Max");
		Min.setText("Min");
		Lecture.setText("Lecture");
		
		int X_Label = 280, Y_Label = 5;
		int WIDTH_Label = 105, HEIGHT_Label = 32;
		for(JButton button: Buttons) {
			button.setFont(get_Font());
			//button.setForeground(Color.WHITE);
			button.setBackground(getBG_COLOR());
			button.setBounds(X_Label, Y_Label, WIDTH_Label, HEIGHT_Label);
			X_Label += 115;
		}
		
	}

}