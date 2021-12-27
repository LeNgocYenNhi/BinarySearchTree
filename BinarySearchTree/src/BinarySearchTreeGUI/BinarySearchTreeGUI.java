package BinarySearchTreeGUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BinarySearchTreeGUI extends JFrame implements ActionListener {
	public static int defaultsize = 1000;	
	public static Node[] BST = new Node[defaultsize];
	public int n = 0;

	public static int WIDTH;
	public static int HEIGHT;
	
	public int size = 35;
	public int timeSleep;

	public int X = 0;
	public int Y = 0;
	public static int lastIndex = -1;
	public String curr_action = "";

	public ActionBar ActionBar = new ActionBar();
	public Traversal Traver = new Traversal();
	public Pseudocode Pseudo = new Pseudocode();
	public OperationButton Button = new OperationButton();
	public Speed _Speed = new Speed();

	JPanel Panel = new JPanel();
	JPanel Tree = new JPanel();

	public BinarySearchTreeGUI() {
		setSize(1400, 800);
        WIDTH = 1400;
        HEIGHT = 800;
        
        Panel.setLayout(null);
		setTitle("Binary Search Tree Visualization");
		add(ActionBar.Input);
		
		for (JButton button : ActionBar.operButton.Buttons) {
			add(button);
			button.addActionListener(this);
		}
		for (JLabel label : Traver.Labels) {
			add(label);
		}

		for (JTextField textfield : Traver.TextFields) {
			add(textfield);
		}
		for (JTextField textfield : Pseudo.InsLines) {
			add(textfield);
		}
		for (JTextField textfield : Pseudo.MinLines) {
			add(textfield);
		}
		for (JTextField textfield : Pseudo.MaxLines) {
			add(textfield);
		}
		for (JTextField textfield : Pseudo.FindLines) {
			add(textfield);
		}
		for (JTextField textfield : Pseudo.DeleteLines) {
			add(textfield);
		}
		add(ActionBar.SelectionSpeed._Speed);
		ActionBar.SelectionSpeed._Speed.addActionListener(this);
		add(ActionBar._TraversalItem.SelectTraversal);
		ActionBar._TraversalItem.SelectTraversal.addActionListener(this);
		add(Panel);
		Panel.add(Tree);
		Tree.setBounds(0, 0, 1400, 800);
		Tree.setBackground(new Color(240, 255, 240));
		Traver.BST = BST;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void start() {
		while (true) {
			sleep(0);
			if (curr_action != "") {
				if (curr_action == "insert") {
					insert_node();
					curr_action = "";
				}else if (curr_action == "min") {
					min_node();
					curr_action = "";
				}else if (curr_action == "max") {
					Pseudo.PseudocodeInsertPanel.setBackground(Color.WHITE);
					max_node();
					curr_action = "";
				}else if (curr_action == "find") {
					Pseudo.PseudocodeInsertPanel.setBackground(Color.WHITE);
					find_node();
					curr_action = "";
				}else if (curr_action == "delete") {
					Pseudo.PseudocodeInsertPanel.setBackground(Color.WHITE);
					delete_node();
					curr_action = "";
				}
			}
		}
		
	}
	
	public void insert_node() {
		Graphics graph = Tree.getGraphics();
		Pseudo.Visible(Pseudo.InsLines);
		String Values = ActionBar.Input.getText();
		Values = Values.replaceAll("\\s+", " ");		// remove double space
		Values = Values.trim();							// remove space at the beginning and endding
		String[] nodeValue = Values.split(" ");
		int numberNode = nodeValue.length;
		for (int i = 0; i < numberNode; i++) {
			int newNode = 0;							// check value is integer
			try {
				newNode = Integer.parseInt(nodeValue[i]);
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Please enter integer value");
			}
			if (newNode > 0 && newNode <= 999) {
				int rX = WIDTH / 2;
				int rY = HEIGHT / 12;
				X = 0;
				Y = 0;
				insert(1, newNode);
				drawNode(graph, rX + X, rY + 80 * Y, Integer.toString(newNode));
				sleep(timeSleep);
				for (JTextField line : Pseudo.InsLines) {
					line.setForeground(Color.BLACK);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Please enter integer value between 1 and 999");
			}
		}

		updateOrderField();
		Pseudo.Invisible(Pseudo.InsLines);

	}
	//Ham tim kiem gia tri min
  	public void min_node() {
		Graphics graph = Tree.getGraphics();
		Pseudo.Visible(Pseudo.MinLines);
		int Min = findMin(1);
		if(Min == -1) {
			JOptionPane.showMessageDialog(null,"Tree is empty!");
		}
		else{
			JOptionPane.showMessageDialog(null,"Min of tree is: " + Min);
		}
		Pseudo.Invisible(Pseudo.MinLines);
  	}
  //Ham tim kiem gia tri min
  	public void max_node() {
		Graphics graph = Tree.getGraphics();
		Pseudo.Visible(Pseudo.MaxLines);
		int Max = findMax(1);
		if(Max == -1) {
			JOptionPane.showMessageDialog(null,"Tree is empty!");
		}
		else{
			JOptionPane.showMessageDialog(null,"Max of tree is: " + Max);
		}
		Pseudo.Invisible(Pseudo.MaxLines);
  	}
  		
  	//Ham tim kiem gia tri min
  	public int findMin(int index) {
  		if(BST[index].getValue() <= 0) {
  			Pseudo.MinLines[0].setForeground(Color.RED);
  			return -1;
  		}
  		else {
  			while(BST[(left(index))].getValue() > 0) {
  				Pseudo.MinLines[1].setForeground(Color.RED);
  				sleep(timeSleep / 2);
  				Pseudo.MinLines[2].setForeground(Color.RED);
  				sleep(timeSleep / 2);
  				Pseudo.MinLines[1].setForeground(Color.BLACK);
  				sleep(timeSleep / 2);
  				Pseudo.MinLines[2].setForeground(Color.BLACK);
  				sleep(timeSleep / 2);
  				circle(index, Color.GREEN, Color.BLACK);
  				index = left(index);
  			}
  			circle(index, Color.GREEN, Color.BLACK);
  			circle(index,Color.ORANGE, Color.BLACK);
  		}
  		Pseudo.MinLines[3].setForeground(Color.RED);
  		sleep(timeSleep / 2);
  		Pseudo.MinLines[3].setForeground(Color.BLACK);
  		
  		return BST[index].getValue();
  		
  	}
  	public int findMax(int index) {
  		if(BST[index].getValue() <= 0) {
  			Pseudo.MaxLines[0].setForeground(Color.RED);
  			return -1;
  		}
  		else {
  			while(BST[(right(index))].getValue() > 0) {
  				Pseudo.MaxLines[1].setForeground(Color.RED);
  				sleep(timeSleep / 2);
  				Pseudo.MaxLines[2].setForeground(Color.RED);
  				sleep(timeSleep / 2);
  				Pseudo.MaxLines[1].setForeground(Color.BLACK);
  				sleep(timeSleep / 2);
  				Pseudo.MaxLines[2].setForeground(Color.BLACK);
  				sleep(timeSleep / 2);
  				circle(index, Color.GREEN, Color.BLACK);
  				index = right(index);
  			}
  			circle(index, Color.GREEN, Color.BLACK);
  			circle(index,Color.ORANGE, Color.BLACK);
  		}
  		Pseudo.MaxLines[3].setForeground(Color.RED);
  		sleep(timeSleep / 2);
  		Pseudo.MaxLines[3].setForeground(Color.BLACK);
  		return BST[index].getValue();
  		
  	}
  	public void find_node() {
		Graphics graph = Tree.getGraphics();
		Pseudo.Visible(Pseudo.FindLines);
		String Values = ActionBar.Input.getText();
		Values = Values.replaceAll("\\s+", " ");		// remove double space
		Values = Values.trim();							// remove space at the beginning and endding
		String[] nodeValue = Values.split(" ");
		int numberNode = nodeValue.length;
		for (int i = 0; i < numberNode; i++) {
			int newNode = 0;							// check value is integer
			try {
				newNode = Integer.parseInt(nodeValue[i]);
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Please enter integer value");
			}
			if (newNode > 0 && newNode <= 999) {
				find(1, newNode);
				JOptionPane.showMessageDialog(null,"Found value "+ nodeValue[i]);
				for (JTextField line : Pseudo.FindLines) {
					line.setForeground(Color.BLACK);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Please enter integer value between 1 and 999");
			}
		}
		updateOrderField();
		Pseudo.Invisible(Pseudo.FindLines);

	}
  	
  	public void delete_node() {
  		Graphics graph = Tree.getGraphics();
		Pseudo.Visible(Pseudo.DeleteLines);
		String Values = ActionBar.Input.getText();
		// remove double space
		Values = Values.replaceAll("\\s+", " ");
		// remove space at the beginning and endding
		Values = Values.trim();
		// render

		String[] nodeValue = Values.split(" ");
		int numberNode = nodeValue.length;
		for (int i = 0; i < numberNode; i++) {
			// check value is integer
			int newNode = 0;
			try {
				newNode = Integer.parseInt(nodeValue[i]);
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Please enter integer value");
			}
			if (newNode > 0 && newNode <= 999) {
				deleteNode(1, newNode);
				for (JTextField line : Pseudo.DeleteLines) {
					line.setForeground(Color.BLACK);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Please enter integer value between 1 and 999");
			}
		}
		updateOrderField();
		Pseudo.Invisible(Pseudo.DeleteLines);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String speed = (String) ActionBar.SelectionSpeed._Speed.getSelectedItem();
		switch (speed) {
			case "Fast":
				timeSleep = 500;
				break;
			case "Normal":
				timeSleep = 1000;
				break;
			case "Slow":
				timeSleep = 2000;
		}
		
		if (e.getSource() == ActionBar._TraversalItem.SelectTraversal) {
			String traver = (String) ActionBar._TraversalItem.SelectTraversal.getSelectedItem();
			switch (traver) {
				case "Preorder":
					PreorderTraversal(1);
					break;
				case "Inorder":
					InorderTraversal(1);
					break;
				case "Postorder":
					PostorderTraversal(1);
			}
		}
		
		// Insert
		if (e.getSource() == ActionBar.operButton.Insert) {
			curr_action = "insert";
		}
		// Delete
		if (e.getSource() == ActionBar.operButton.Delete) {
			curr_action = "delete";
		}
		// Min
		if (e.getSource() == ActionBar.operButton.Min) {
			curr_action = "min";
		}
		// Max
		if (e.getSource() == ActionBar.operButton.Max) {
			curr_action = "max";
		}
		// Find
		if (e.getSource() == ActionBar.operButton.Find) {
			curr_action = "find";
		}
		// LectureNote
		if (e.getSource() == ActionBar.operButton.Lecture) {
			new LectureNote();
		}
		

	}

	public int left(int i) {
		return 2 * i;
	}

	public int right(int i) {
		return 2 * i + 1;
	}

	public int parent(int i) {
		if (i == 1) {
			return i;
		}
		return (i / 2);
	}

	public void insert(int Index, int Value) {
		if (Index == 1 && BST[Index].getValue() <= 0) {
			Pseudo.InsLines[0].setForeground(Color.RED);
			sleep(timeSleep / 2);
			Pseudo.InsLines[1].setForeground(Color.RED);
			n += 1;
			BST[Index].setValue(Value);
			BST[Index].setX(WIDTH / 2 + X);
			BST[Index].setY(HEIGHT / 12  + 80 * Y);
			return;
		}

		if (BST[Index].getValue() <= 0) {
			n += 1;
			BST[Index].setValue(Value);
			BST[Index].setX(WIDTH / 2 + X);
			BST[Index].setY(HEIGHT / 12  + 80 * Y);
			if (Index != 1) {
				lastIndex = Index;
			}
			return;
		}
		Pseudo.InsLines[2].setForeground(Color.RED);
		Pseudo.InsLines[3].setForeground(Color.RED);
		// Chuyen sang cay con phai
		if (BST[Index].getValue() < Value) {
			Pseudo.InsLines[3].setForeground(Color.BLACK);
			Pseudo.InsLines[5].setForeground(Color.BLACK);
			sleep(timeSleep / 2);
			Pseudo.InsLines[6].setForeground(Color.RED);
			sleep(timeSleep);
			Pseudo.InsLines[6].setForeground(Color.BLACK);
			circle(Index, Color.GREEN, Color.BLACK);
			Y += 1;
			X = X + WIDTH / (int) Math.pow(2, Y + 1);
			insert(right(Index), Value);
		}
		// Chuyen sang cay con trai
		else if (BST[Index].getValue() > Value) {
			Pseudo.InsLines[4].setForeground(Color.RED);
			circle(Index, Color.GREEN, Color.BLACK);
			Y += 1;
			X = X - WIDTH / (int) Math.pow(2, Y + 1);
			insert(left(Index), Value);
			Pseudo.InsLines[4].setForeground(Color.BLACK);
		} else if (BST[Index].getValue() == Value) {
			circle(Index, Color.GREEN, Color.BLACK);
			return;
		}

	}
	// insertNode khong co ma gia
	public void insertNode(int Index, int Value){    
        if(Index == 1 && BST[Index].getValue() <= 0){
            n += 1;
            BST[Index].setValue(Value);
            BST[Index].setX(WIDTH / 2 + X);
            BST[Index].setY(HEIGHT / 12 + 80 * Y);
            return;
        }
        
        if( BST[Index].getValue() <= 0 ) {
            n += 1;
            BST[Index].setValue(Value);
            BST[Index].setX(WIDTH / 2 + X);
            BST[Index].setY(HEIGHT / 12 + 80 * Y);
            if(Index != 1) {
            	  lastIndex = Index;
            }
            return;
        }
        //Chuyen sang cay con phai
        if( BST[Index].getValue() < Value){
            circle(Index, Color.GREEN, Color.BLACK);
            Y += 1;
            X = X + WIDTH / (int) Math.pow(2,  Y + 1);
            insertNode(right(Index) , Value);
        }
        //Chuyen sang cay con trai
        else if(BST[Index].getValue() > Value){
            circle(Index, Color.GREEN, Color.BLACK);
            Y += 1;
            X = X - WIDTH / (int) Math.pow(2,  Y + 1);
            insertNode(left(Index) , Value);
        }
        else if(BST[Index].getValue() == Value){
            circle(Index, Color.GREEN, Color.BLACK);
            return;
        }
    
    }
	
	public void deleteNode(int index ,int Value) {
		if(BST[index].getValue() <= 0) {
			return; 
		}
		//gia tri xoa lon hon gia tri cua node i => xet cay con phai
		if(BST[index].getValue() < Value) {
			Pseudo.DeleteLines[0].setForeground(Color.RED);
			sleep(timeSleep / 2);
			Pseudo.DeleteLines[1].setForeground(Color.BLACK);
			circle(index, Color.GREEN, Color.BLACK);		//nut dang duoc duyet co mau xanh
			deleteNode(right(index), Value);
		//Neu gia tri xoa be hon gia tri cua node i => xet cay con trai
		}else if(BST[index].getValue() > Value){
			Pseudo.DeleteLines[0].setForeground(Color.RED);
			sleep(timeSleep / 2);
			Pseudo.DeleteLines[1].setForeground(Color.BLACK);
			circle(index, Color.GREEN, Color.BLACK);
			deleteNode(left(index), Value);
		}
		//nut xet bang gia tri can xoa
		else if(BST[index].getValue() == Value) {
			n -= 1;
			circle(index, Color.GREEN, Color.BLACK);
			circle(index,Color.ORANGE, Color.BLACK);
			//TH1: Nut khong co con (xoa nut la)
			if(BST[left(index)].getValue() <= 0 && BST[right(index)].getValue() <= 0) {
				Pseudo.DeleteLines[0].setForeground(Color.BLACK);
				Pseudo.DeleteLines[1].setForeground(Color.RED);
				sleep(timeSleep / 2);
				Pseudo.DeleteLines[1].setForeground(Color.BLACK);
				Pseudo.DeleteLines[2].setForeground(Color.RED);
				sleep(timeSleep / 2);
				Pseudo.DeleteLines[2].setForeground(Color.BLACK);
				Leaf(index);
			}else {
				//TH2: Nut co con
				String insertAgain = null ;
				int current = left(index);
				// Neu node xoa chi co con phai
				if(BST[(left(index))].getValue() <= 0 && BST[(right(index))].getValue() > 0){
					insertAgain = Path(right(index));
					Pseudo.DeleteLines[0].setForeground(Color.BLACK);
					Pseudo.DeleteLines[3].setForeground(Color.RED);
					sleep(timeSleep / 2);
					Pseudo.DeleteLines[3].setForeground(Color.BLACK);
					Pseudo.DeleteLines[4].setForeground(Color.RED);
					sleep(timeSleep / 2);
					Pseudo.DeleteLines[4].setForeground(Color.BLACK);
				}
				//Neu node xoa chi co con trai
				else if(BST[(left(index))].getValue() > 0 && BST[(right(index))].getValue() <= 0) {
					insertAgain = Path(left(index));
					Pseudo.DeleteLines[0].setForeground(Color.BLACK);
					Pseudo.DeleteLines[3].setForeground(Color.RED);
					sleep(timeSleep / 2);
					Pseudo.DeleteLines[3].setForeground(Color.BLACK);
					Pseudo.DeleteLines[4].setForeground(Color.RED);
					sleep(timeSleep / 2);
					Pseudo.DeleteLines[4].setForeground(Color.BLACK);
					//Neu node xoa co du hai con trai va phai
				}else if(BST[(left(index))].getValue() > 0 && BST[(right(index))].getValue() > 0){
					//Tim nut co gia tri lon nhat cua cay con trai
					Pseudo.DeleteLines[0].setForeground(Color.BLACK);
					Pseudo.DeleteLines[5].setForeground(Color.RED);
					sleep(timeSleep / 2);
					Pseudo.DeleteLines[5].setForeground(Color.BLACK);
					while(BST[(right(current))].getValue() > 0){
						//nut duoc duyet bao mau xanh
						circle(index, Color.GREEN, Color.BLACK);
						current = right(current);
					}
					circle(index, Color.ORANGE, Color.BLACK);
					//nut duoc thay the bao mau xanh la cay
					circle(current,Color.RED, Color.BLACK);
					//gan lai gia tri cho nut moi
					BST[index].setValue(BST[current].getValue());
					lastIndex = -1;
					drawNode(Tree.getGraphics(), BST[index].getX(), BST[index].getY(), Integer.toString(BST[index].getValue()));
					if(BST[(left(current))].getValue() > 0)
						insertAgain = Path(left(current));
					else
						insertAgain ="";
				}
				Scanner scan = new Scanner(insertAgain);
				if((BST[(left(index))].getValue() <= 0 && BST[(right(index))].getValue() > 0|| 
						(BST[(left(index))].getValue() > 0 && BST[(right(index))].getValue() <= 0))){
					deleteTree(index);
				}
				else {
					deleteTree(current);
				}
				Graphics g = Tree.getGraphics();
				while(scan.hasNext()) {
					int rX = WIDTH / 2;
					int rY = HEIGHT / 12;
					int toInsert = scan.nextInt();
					X = 0;
					Y = 0; 
                    insertNode(1, toInsert); 
                    Line( parent(lastIndex), lastIndex);
                    lastIndex = -1;
                    drawNode(g, rX + X, rY + 80 * Y, Integer.toString(toInsert));
				   
                }
			}
		}
	}

	public void deleteTree(int i){
		Queue<Integer> nextNode = new LinkedList<>();
		nextNode.add(i);
		while(!nextNode.isEmpty()){
			if(BST[(left(nextNode.peek()))].getValue() > 0) {
				nextNode.add(left(nextNode.peek()));
			}
			if(BST[(right(nextNode.peek()))].getValue() > 0) {
				nextNode.add(right(nextNode.peek()));
			}
			Leaf(nextNode.peek());
			nextNode.remove(nextNode.peek());
		}

	}
	// tim kiem nut vi tri i
	// gia tri j
	public void find(int index, int Value) {
		if(BST[index].getValue() <= 0) {
			Pseudo.FindLines[0].setForeground(Color.RED);
			Pseudo.FindLines[1].setForeground(Color.RED);
			sleep(timeSleep / 2);
			Pseudo.FindLines[0].setForeground(Color.BLACK);
			Pseudo.FindLines[1].setForeground(Color.BLACK);
			return;
		}
		if(BST[index].getValue() == Value) {
			Pseudo.FindLines[3].setForeground(Color.RED);
			sleep(timeSleep / 2);
			Pseudo.FindLines[3].setForeground(Color.BLACK);
			circle(index, Color.GREEN, Color.BLACK);		// nut dang duoc duyet den co mau xanh
			circle(index,Color.ORANGE, Color.BLACK);		//nut co gia tri can tim hien mau cam
		}
		if(BST[index].getValue() < Value) {	//gia tri dang xet nho hon phan tu can tim => xet cay ben phai
			Pseudo.FindLines[2].setForeground(Color.RED);
			sleep(timeSleep / 2);
			Pseudo.FindLines[2].setForeground(Color.BLACK);
			Pseudo.FindLines[4].setForeground(Color.RED);
			sleep(timeSleep / 2);
			Pseudo.FindLines[4].setForeground(Color.BLACK);
			Pseudo.FindLines[5].setForeground(Color.RED);
			sleep(timeSleep / 2);
			Pseudo.FindLines[5].setForeground(Color.BLACK);
			circle(index, Color.GREEN, Color.BLACK);
			find(right(index), Value);
		}
		if(BST[index].getValue() > Value) {
			Pseudo.FindLines[2].setForeground(Color.RED);
			sleep(timeSleep / 2);
			Pseudo.FindLines[2].setForeground(Color.BLACK);
			sleep(timeSleep / 2);
			Pseudo.FindLines[6].setForeground(Color.RED);
			sleep(timeSleep / 2);
			Pseudo.FindLines[6].setForeground(Color.BLACK);
			circle(index, Color.GREEN, Color.BLACK);
			find(left(index), Value);
		}
	}
  	public String Path(int i) {
		String s ="";
		Queue<Integer> queue = new LinkedList<>();
		queue.add(i);
		while(!queue.isEmpty()) {
			n += 1;
			s += BST[queue.peek()].getValue() +" ";
			if(BST[(left(queue.peek()))].getValue() > 0) {
				queue.add(left(queue.peek()));
			}
			if(BST[(right(queue.peek()))].getValue() > 0) {
				queue.add(right(queue.peek()));
			}
			queue.remove(queue.peek());
		}
		return s;
	}
	public void circle(int i, Color beforeColor, Color afterColor) {
		Graphics graph = Tree.getGraphics();
		Graphics2D _graph = (Graphics2D) graph;
		//Duong vien cho hinh tron
		_graph.setStroke(new BasicStroke(2));
		//Set duong vien cho hinh tron luc dang duyet
		_graph.setColor(beforeColor);
		_graph.drawOval(BST[i].getX() - 35, BST[i].getY(), 35, 35);
		sleep(timeSleep);
		// Duong vien cho hinh tron co mau den
		_graph.setColor(afterColor);
		_graph.drawOval(BST[i].getX() - 35, BST[i].getY(), 35, 35);
	}


	// Dung lai khoang thoi gian time
	public void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void drawNode(Graphics _graph, int x, int y, String Value) {
		Graphics2D graph = (Graphics2D) _graph;
		graph.setStroke(new BasicStroke(2));
		//Set mau cho hinh tron cua node
		graph.setColor(Color.WHITE);					// Set mau cho hinh tron cua node
		graph.fillOval(x - size, y, size, size);
		graph.setColor(Color.BLACK);
		graph.drawOval(x - size, y, size, size);		// draws a black border on the node
		graph.setColor(Color.BLACK);					
		//Set font cho text trong hinh tron	
		graph.setFont(new Font("NewellsHand", Font.PLAIN, 20));		
		// Dien so vao trong hinh tron
		int nodeValue = Integer.parseInt(Value);
		if (nodeValue > 0 && nodeValue <= 9) {
			graph.drawString(Value, x - 22, y + 24);
		} else if (nodeValue >= 10 && nodeValue <= 99) {
			graph.drawString(Value, x - 28, y + 24);
		} else if (nodeValue >= 100 && nodeValue <= 999) {
			graph.drawString(Value, x - 32, y + 24);
		}
		if (lastIndex != -1) {
			// Set do rong cua duong thang
			graph.setStroke(new BasicStroke(2));
			//graph.setColor(Color.ORANGE);
			int parPos = parent(lastIndex);
			graph.drawLine(BST[parPos].getX() - 37 / 2, BST[parPos].getY() + 37,
					BST[lastIndex].getX() - 37 / 2, BST[lastIndex].getY());

			 circle(lastIndex, Color.ORANGE, Color.BLACK); 
		}
	}
	public void Line(int i, int j) {
		if (i == j) {
			return;
		}
		Graphics2D graph = (Graphics2D) Tree.getGraphics();
		graph.setStroke(new BasicStroke(2));
		graph.setColor(Color.BLACK);
        //drawLine(x1, y1, x2, y2) ve duong thang noi giua hai diem co toa do (x1, y1) (x2, y2)
      	graph.drawLine(BST[i].getX() -  37 / 2 , BST[i].getY() + 37 , BST[j].getX() - 37 / 2 , BST[j].getY());
	}

	public void Leaf(int i) {
		Graphics2D graph = (Graphics2D)Tree.getGraphics();
		graph.setColor(graph.getBackground());
		graph.setStroke(new BasicStroke(2));
		graph.setColor(new Color(240, 255, 240));
		graph.fillOval(BST[i].getX() - size, BST[i].getY() , 35, 35);
	    graph.drawOval(BST[i].getX() - 35, BST[i].getY() ,35, 35);
	    graph.drawLine(BST[parent(i)].getX() - 37 / 2 , BST[parent(i)].getY() + 37, BST[i].getX() - 37 / 2 , BST[i].getY());
	    BST[i].setValue(-1);
	}

	public void PreorderTraversal(int Index) {
		if (BST[Index].getValue() <= 0) {
			return;
		}
		circle(Index, Color.GREEN, Color.BLACK);
		PreorderTraversal(left(Index));
		PreorderTraversal(right(Index));
	}

	public void InorderTraversal(int Index) {
		if (BST[Index].getValue() <= 0) {
			return;
		}
		InorderTraversal(left(Index));
		circle(Index, Color.GREEN, Color.BLACK);
		InorderTraversal(right(Index));
	}

	public void PostorderTraversal(int Index) {
		if (BST[Index].getValue() <= 0) {
			return;
		}
		PostorderTraversal(left(Index));
		PostorderTraversal(right(Index));
		circle(Index, Color.GREEN, Color.BLACK);
	}

	private void updateOrderField() {
		Traver.setInorder("");
		Traver.Inorder(1);
		Traver.setPreorder("");
		Traver.Preorder(1);
		Traver.setPostorder("");
		Traver.PostOrder(1);
		Traver.PreorderField.setText(Traver.getPreorder());
		Traver.InorderField.setText(Traver.getInorder());
		Traver.PostorderField.setText(Traver.getPostorder());
		ActionBar.Input.setText("");

	}

	public static void main(String[] args) {
		for (int i = 0; i < defaultsize; i++) {
			BST[i] = new Node(-1);
		}
		BinarySearchTreeGUI bst = new BinarySearchTreeGUI();
		bst.start();
		
		
	}

}