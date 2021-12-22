package BinarySearchTreeGUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
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
    
    //size ve do lon vong tron cua 1 node
    public int size = 35;
    public int timeSleep;
    
    public int X = 0;
    public int Y = 0;
    public static int lastIndex = -1;
    
    public SymbolTable SymTable = new SymbolTable();
    public Traversal Traver = new Traversal();
    public Pseudocode Pseudo = new Pseudocode();
    public OperationButton Button = new OperationButton();
    public Speed _Speed = new Speed();
    public Sort _Sort = new Sort();
    JPanel mainPanel = new JPanel(new GridLayout(1 , 1));
    JPanel treePanel = new JPanel();

    public BinarySearchTreeGUI(){      
        setSize(1400, 800);
        WIDTH = 1400;
        HEIGHT = 800;
        setTitle("Binary Search Tree Visualization");
        add(SymTable.Input);
        add(SymTable._SearchItem.SelectSearch);
		SymTable._SearchItem.SelectSearch.addActionListener(this);
		add(SymTable._Rand.Selected);
		SymTable._Rand.Selected.addActionListener(this);
        for (JButton button : SymTable.operButton.Buttons){
        	add(button);
    		button.addActionListener(this);
        } 
        for(JLabel label: Traver.Labels) {
			add(label);
		}
		for(JTextField textfield: Traver.TextFields) {
			add(textfield);
		}
		for(JLabel label: Pseudo.Labels) {
			add(label);
		}		
		
		add(SymTable.SelectionSpeed._Speed);
		SymTable.SelectionSpeed._Speed.addActionListener(this);
		add(SymTable._TraversalItem.SelectTraversal);
		SymTable._TraversalItem.SelectTraversal.addActionListener(this);
		
        add(mainPanel);
        mainPanel.add(treePanel);
        treePanel.setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        Traver.BST = BST;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    	Graphics g = treePanel.getGraphics();
    	
    	String speed = (String) SymTable.SelectionSpeed._Speed.getSelectedItem();
    	switch(speed) {
    	case "Fast":
    		timeSleep = 500;
    		break;
    	case "Normal":
    		timeSleep = 800;
    		break;
    	case "Slow":
    		timeSleep = 4000;
    	}
    	
    	if(e.getSource() == SymTable._TraversalItem.SelectTraversal){
    		String traver = (String) SymTable._TraversalItem.SelectTraversal.getSelectedItem();
    		switch(traver) {
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
    	String Values = SymTable.Input.getText();
		Values = Values.trim();
		Values = Values.replaceAll("\\s+", " ");
		String[] nodeValue = Values.split(" ");
		int numberNode = nodeValue.length;
    	//Create
    	if(e.getSource() == SymTable.operButton.Create){
 			for (int i = 0; i < numberNode; i++) {
 				try {
 					int newNode = Integer.parseInt(nodeValue[i]);
 					if(newNode > 0 && newNode <= 999) {
 						int rX = WIDTH /2;			
 						int rY = HEIGHT / 12;
 						X = 0;
 						Y = 0;
 						insertNode(1, newNode);
 						drawNode(g , rX + X , rY + 80 * Y , Integer.toString(newNode));
 						sleep(timeSleep);
 					}else {
 						throw new Exception();
 						}
 				}catch(Exception e2){
                 	JOptionPane.showMessageDialog(null,"Please enter values");
 				}
             }
 			update();
        	
        }
    	//Insert
    	if(e.getSource() == SymTable.operButton.Insert){
    		try {
				int newNode = Integer.parseInt(Values);
				if(newNode > 0 && newNode <= 999) {
					int rX = WIDTH /2;
					int rY = HEIGHT / 12;
					X = 0;
					Y = 0;
					insertNode(1, newNode);
					drawNode(g , rX + X , rY + 80 * Y , Integer.toString(newNode));
					sleep(timeSleep);
				}else {
					throw new Exception();
				}
			}catch(Exception e2){
				JOptionPane.showMessageDialog(null,"Please enter value");
			}
    		
 			update();
         }
    	
    	if(e.getSource() == SymTable.operButton.Lecture){
    		new LectureNote();
    	}
        //Delete
        if(e.getSource() == SymTable.operButton.Delete){
        	//bat dau tu nut root xem xet lan luot phan tu voi gia tri can xoa
			for (int i = 0; i < numberNode; i++) {
				int newNode = Integer.parseInt(nodeValue[i]);
				deleteNode(1, newNode);
        	}
			update();
        }
        //Find
        if(e.getSource() ==SymTable._SearchItem.SelectSearch) {
    		String search = (String) SymTable._SearchItem.SelectSearch.getSelectedItem();
    		switch(search) {
    		case "Find":
    			for (int i = 0; i < numberNode; i++) {
    				try {
    					int newNode = Integer.parseInt(nodeValue[i]);
    					search(1, newNode);
    					JOptionPane.showMessageDialog(null,"Found value "+ nodeValue[i]);
    				}catch(Exception e2){
    					JOptionPane.showMessageDialog(null,"Value " + nodeValue[i]+ " is not in the BST!");
    				}
    			}
    			break;
    		case "Max":
    			int Max = findMax(1);
    			if(Max == -1) {
    				JOptionPane.showMessageDialog(null,"Tree is empty!");
    			}
    			else{
    				JOptionPane.showMessageDialog(null,"Max of tree is: " + Max);
    			}
    			break;
    		case "Min":
    			int Min = findMin(1);
    			if(Min == -1) {
    				JOptionPane.showMessageDialog(null,"Tree is empty!");
    			}
    			else{
    				JOptionPane.showMessageDialog(null,"Min of tree is: " + Min);
    			}
    		}
    		update();
    	}
    }
    public int left(int i){
        return 2 * i;
    }
    
    public int right(int i){
        return 2 * i + 1;
    }
    public int parent(int i){
        if(i == 1) {
        	return i;
        }
        return (i / 2);      
    }
    public void insertNode(int Index, int Value){    
        if(Index == 1 && BST[Index].getValue() <= 0){
            n += 1;
            BST[Index].setValue(Value);
            BST[Index].setX(WIDTH / 2 + X);
            BST[Index].setY(HEIGHT / 12 + 80 * Y);
            return;
        }
        
        if( BST[Index].getValue() <= 0 ) {
        	Pseudo.Line5.setBackground(Color.GREEN);
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
            circle(Index, Color.BLUE, Color.BLACK);
            Y += 1;
            X = X + WIDTH / (int) Math.pow(2,  Y + 1);
            insertNode(right(Index) , Value);
        }
        //Chuyen sang cay con trai
        else if(BST[Index].getValue() > Value){
            circle(Index, Color.BLUE, Color.BLACK);
            //move to left
            Y += 1;
            X = X - WIDTH / (int) Math.pow(2,  Y + 1);
            insertNode(left(Index) , Value);
        }
        else if(BST[Index].getValue() == Value){
            circle(Index, Color.BLUE, Color.BLACK);
            return;
        }
    
    }
    /**
	 * Xac dinh nut can xoa
	 * @param index
	 * @param Value
	 */  
	public void deleteNode(int index ,int Value) {
		if(BST[index].getValue() <= 0) {
			return; 
		}
		//step1
		//gia tri xoa lon hon gia tri cua node i => xet cay con phai
		if(BST[index].getValue() < Value) {
			//nut dang duoc duyet co mau xanh
			circle(index, Color.BLUE, Color.BLACK);
			deleteNode(right(index), Value);
		}else if(BST[index].getValue() > Value){ //Neu gia tri xoa be hon gia tri cua node i => xet cay con trai
			circle(index, Color.BLUE, Color.BLACK);
			deleteNode(left(index), Value);
		}
		//step 3
		// nut xet bang gia tri can xoa
		else {
			n -= 1;
			circle(index, Color.BLUE, Color.BLACK);
			//nut co gia tri xoa can tim bao mau cam
			circle(index,Color.ORANGE, Color.BLACK);
			//TH1: Nut khong co con (xoa nut la)
			if(BST[left(index)].getValue() <= 0 && BST[right(index)].getValue() <= 0) {
				nodeLeaf(index);
			}else {
				//TH2: Nut co con
				String insertAgain ;
				int current = left(index);
				// Neu node xoa chi co con phai
				if(BST[(left(index))].getValue() <= 0 && BST[(right(index))].getValue() > 0){
					insertAgain = bfsPath(right(index));
				}
				//Neu node xoa chi co con trai
				else if(BST[(left(index))].getValue() > 0 && BST[(right(index))].getValue() <= 0) {
					insertAgain = bfsPath(left(index));
				}else {
					//Neu node xoa co du hai con trai va phai
					//Tim nut co gia tri lon nhat cua cay con trai (nut cuoi cung ben phai)
					while(BST[(right(current))].getValue() > 0){
						//nut duoc duyet bao mau xanh
						circle(index, Color.BLUE, Color.BLACK);
						current = right(current);
					}
					circle(index, Color.BLUE, Color.BLACK);
					//nut duoc thay the bao mau xanh la cay
					circle(current,Color.GREEN, Color.BLACK);
					//gan lai gia tri cho nut moi
					BST[index].setValue(BST[current].getValue());
					lastIndex = -1;
					drawNode(treePanel.getGraphics(), BST[index].getX(), BST[index].getY(), Integer.toString(BST[index].getValue()));
					if(BST[(left(current))].getValue() > 0)
						insertAgain = bfsPath(left(current));
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
				Graphics g = treePanel.getGraphics();
				while(scan.hasNext()) {
					int rX = WIDTH / 2;
					int rY = HEIGHT / 12;
					int toInsert = scan.nextInt();
					X = 0;
					Y = 0; 
                    insertNode(1, toInsert); 
                    drawLine( parent(lastIndex), lastIndex);
                    lastIndex = -1;
                    drawNode(g, rX + X, rY + 80 * Y, Integer.toString(toInsert));
                    
                }
			}
		}
	}
	
	//Xoa node vi tri i
	//Khi nhap 1 chuoi qua trinh xoa se cac node lan luot theo FIFO
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
		    nodeLeaf(nextNode.peek());
		    nextNode.remove(nextNode.peek());
		}
		        
	}
	//tim kiem nut vi tri i
	//gia tri j
	public void search(int index, int Value) {
		if(BST[index].getValue() == Value) {
			circle(index, Color.BLUE, Color.BLACK);		// nut dang duoc duyet den co mau xanh
			circle(index,Color.ORANGE, Color.BLACK);	////nut co gia tri can tim hien mau cam
			//gia tri dang xet nho hon phan tu can tim => xet cay ben phai
		}else if(BST[index].getValue() < Value) {
			circle(index, Color.BLUE, Color.BLACK);
			search(right(index), Value);
		}
		else{	//xet cay ben trai
			circle(index, Color.BLUE, Color.BLACK);
			search(left(index), Value);
		}
	}
	//Ham tim kiem gia tri max
  	public int findMax(int index) {
  		if(BST[index].getValue() <= 0) {
  			return -1; 
  		}
  		else {
  			while(BST[(right(index))].getValue() > 0) {
  				circle(index, Color.BLUE, Color.BLACK);
  				index = right(index);
  			}
  			circle(index, Color.BLUE, Color.BLACK);
  			
  			circle(index,Color.ORANGE, Color.BLACK);

  		}
  		return BST[index].getValue();
  	}
  	//Ham tim kiem gia tri min
  	public int findMin(int index) {
  		if(BST[index].getValue() <= 0) {
  			return -1;
  		}
  		else {
  			while(BST[(left(index))].getValue() > 0) {
  				circle(index, Color.BLUE, Color.BLACK);
  				index = left(index);
  			}
  			circle(index, Color.BLUE, Color.BLACK);
  			circle(index,Color.ORANGE, Color.BLACK);
  		}
  		return BST[index].getValue();
  	}

	public String bfsPath(int i) {
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
    public void circle(int i, Color beforeColor, Color afterColor){
    	Graphics g1 = treePanel.getGraphics();
        Graphics2D g = (Graphics2D)g1;
        //Duong vien cho hinh tron
        g.setStroke(new BasicStroke(2));
        //Set duong vien cho hinh tron luc dang duyet
        g.setColor(beforeColor);
        g.drawOval(BST[i].getX() - 35, BST[i].getY() , 35, 35);
        sleep(timeSleep);
        //Duong vien cho hinh tron luc da hoan thanh 
        g.setColor(afterColor);
        g.drawOval(BST[i].getX() - 35, BST[i].getY() , 35, 35);    
    } 
    
    //Dung lai khoang thoi gian time
  	public void sleep(int time) {
  		try {
  			Thread.sleep(time);
  		} catch (InterruptedException e) {
  			e.printStackTrace();
  		}	
  	}
  	//Ve node
    public void drawNode(Graphics g1 , int x , int y, String Value){
        Graphics2D g = (Graphics2D)g1;
        g.setStroke(new BasicStroke(2));
        //Set mau cho hinh tron cua node
        g.setColor(Color.WHITE); 
        g.fillOval(x - size, y, size, size);
        g.setColor(Color.BLACK);
        g.drawOval(x - size, y, size, size); //draws a black border on the node
        //Set font cho gia tri cua node
        g.setColor(Color.BLACK);
        //Set font cho text trong hinh tron
        g.setFont(new Font("NewellsHand", Font.PLAIN, 20));
        //Dien so vao trong hinh tron 
      	int nodeValue = Integer.parseInt(Value);
      	if (nodeValue > 0 && nodeValue <= 9) {
      		g.drawString(Value, x - 22, y + 24);
      	} else if (nodeValue >= 10 && nodeValue <= 99) {
      		g.drawString(Value, x - 28, y + 24);
      	} else if (nodeValue >= 100 && nodeValue <= 999) {
      		g.drawString(Value, x - 32, y + 24);
      	}
        if(lastIndex != -1){  
        	//Set do rong cua duong thang
            g.setStroke(new BasicStroke(2));
            g.setColor(Color.BLACK);
            int parPos = parent(lastIndex);
            g.drawLine(BST[parPos].getX() - 36 / 2  , BST[parPos].getY() + 36, 
            		BST[lastIndex].getX() - 36 / 2  , BST[lastIndex].getY());   
            
            circle(lastIndex, Color.ORANGE, Color.BLACK); 
        }   
    }
	public void drawLine(int i, int j) {
		if(i == j) {
			return;
		}
		Graphics2D g = (Graphics2D)treePanel.getGraphics();
		g.setStroke(new BasicStroke(2));
        g.setColor(Color.BLACK);
		//drawLine(x1, y1, x2, y2) ve duong thang noi giua hai diem co toa do (x1, y1) (x2, y2)
		g.drawLine(BST[i].getX() -  36 / 2 , BST[i].getY() + 36 , BST[j].getX() - 36 / 2 , BST[j].getY());
		
	}
    /**
	 * nut la (su dung de xoa)
	 * @param i
	 */
	public void nodeLeaf(int i) {
		Graphics2D g = (Graphics2D)treePanel.getGraphics();
		g.setColor(g.getBackground());
		g.setStroke(new BasicStroke(2));
		g.setColor(Color.WHITE);
		g.fillOval(BST[i].getX() - size, BST[i].getY() , 35, 35);
	    g.drawOval(BST[i].getX() - 35, BST[i].getY() ,35, 35);
	    g.drawLine(BST[parent(i)].getX() - 36 / 2 , BST[parent(i)].getY() + 36, BST[i].getX() - 36 / 2 , BST[i].getY());
	    BST[i].setValue(-1);
	}
  	public void PreorderTraversal(int Index) {
  		if(BST[Index].getValue() <= 0) {
  			return;
  		}
        circle(Index, Color.BLUE, Color.BLACK);
        PreorderTraversal(left(Index));
        PreorderTraversal(right(Index));	
  	}
  	public void InorderTraversal(int Index) {
  		if(BST[Index].getValue() <= 0) {
  			return;
  		}    
  		InorderTraversal(left(Index));
        circle(Index, Color.BLUE, Color.BLACK);  
        InorderTraversal(right(Index));	
  	}
  	public void PostorderTraversal(int Index) {
  		if(BST[Index].getValue() <= 0) {
  			return;
  		}
        PostorderTraversal(left(Index));
        PostorderTraversal(right(Index));	
        circle(Index, Color.BLUE, Color.BLACK);
  	}
	public void update() {
		Traver.setInorder("");
		Traver.Inorder(1);
		Traver.setPreorder("");
		Traver.Preorder(1);
		Traver.setPostorder("");
		Traver.PostOrder(1);
		Traver.PreorderField.setText(Traver.getPreorder());
		Traver.InorderField.setText(Traver.getInorder());
		Traver.PostorderField.setText(Traver.getPostorder());
		SymTable.Input.setText("");
	}  
	public static void main(String[] args) {
		for(int i = 0;i < defaultsize;i++) {
			BST[i] = new Node(-1);
		}
	    new BinarySearchTreeGUI(); 
	}

}
