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
		_Speed.setBounds(1085, 5, 105, 32);
		_Speed.setFont(get_Font());
	}
	public int timeSleeping() {
		String speed = (String) _Speed.getSelectedItem();
    	switch(speed) {
    	case "Fast":
    		timeSleep = 500;
    		break;
    	case "Normal":
    		timeSleep = 1000;
    		break;
    	case "Slow":
    		timeSleep = 2000;
    	}
    	return timeSleep;
	}

}