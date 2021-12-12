package BinarySearchTreeGUI;

import javax.swing.JComboBox;

public class Speed extends Button{
	JComboBox<String> _Speed;
	int timeSleep;
	
	public Speed() {
		String [] items = {"Fast", "Normal", "Slow"};
		_Speed = new JComboBox<String>(items);
		_Speed.setSelectedIndex(1);
		_Speed.setBackground(getBG_COLOR());
	}

}
