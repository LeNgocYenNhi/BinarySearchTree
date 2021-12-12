package BinarySearchTreeGUI;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
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
	public static int defaultsize = 50;		//so luong node toi da
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
    JPanel mainPanel = new JPanel(new GridLayout(1 , 1));
    JPanel treePanel = new JPanel();

    public BinarySearchTreeGUI(){      
        setSize(1080, 760);
        WIDTH = 1080;
        HEIGHT = 760;
        
        setTitle("Binary Search Tree Visualization");
        
        this.getContentPane().add(SymTable.Panel, BorderLayout.NORTH);
        add(SymTable.Input);

        for(JLabel label: Traver.Labels) {
			add(label);
		}
		for(JTextField textfield: Traver.TextFields) {
			add(textfield);
		}
		for(JLabel label: Pseudo.Labels) {
			add(label);
		}

		SymTable.SelectionSpeed._Speed.addActionListener(this);
		SymTable._TraversalItem.SelectTraversal.addActionListener(this);
		//add(SymTable._TraversalItem.Traversal);
        add(mainPanel);
        mainPanel.add(treePanel);
        treePanel.setBackground(Color.WHITE);
    
        for (JButton button : SymTable.operButton.Buttons){
    		button.addActionListener(this);
        } 
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
    		timeSleep = 1000;
    		break;
    	case "Slow":
    		timeSleep = 2000;
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
        
    	//Create
    	if(e.getSource() == SymTable.operButton.Empty){
        	for(int i = 0; i < defaultsize; i++) {
        		BST[i].setValue(0);
        	}
			update();
        }
        //Insert
        if(e.getSource() == SymTable.operButton.Insert){
        	String Values = SymTable.Input.getText();
			String[] nodeValue = Values.split(" ");
			int numberNode = nodeValue.length;
			for (int i = 0; i < numberNode; i++) {
				try {
					int newNode = Integer.parseInt(nodeValue[i]);
					if(newNode > 0 && newNode <= 999) {
						int rX = WIDTH /2;
						int rY = 0;
						X = 0;
						Y = 0;
						insertNode(1, newNode);
						drawNode(g , rX + X , rY + 100 * Y , Integer.toString(newNode));
						sleep(timeSleep);
					}else {
						throw new Exception();
						}
				}catch(Exception e2){
                	JOptionPane.showMessageDialog(null,"Please enter integer");
				}
            }
			update();
        }
        //Delete
        if(e.getSource() == SymTable.operButton.Delete){
        	//bat dau tu nut root xem xet lan luot phan tu voi gia tri can xoa
        	String Values = SymTable.Input.getText();
			String[] nodeValue = Values.split(" ");
			int numberNode = nodeValue.length;
			for (int i = 0; i < numberNode; i++) {
				int newNode = Integer.parseInt(nodeValue[i]);
				deleteNode(1, newNode);
        	}
			update();
        }

        //Find
      	if(e.getSource() ==SymTable.operButton.Find) {
      		String Values = SymTable.Input.getText();
			String[] nodeValue = Values.split(" ");
			int numberNode = nodeValue.length;
			for (int i = 0; i < numberNode; i++) {
				try {
					int newNode = Integer.parseInt(nodeValue[i]);
					searchNode(1, newNode);
					JOptionPane.showMessageDialog(null,"Yes");
				}catch(Exception e2){
                	JOptionPane.showMessageDialog(null,"No");
				}
            }
			update();
				
      	}
      	
    }
    public int left(int i){
        return 2 * i;
    }
    
    public int right(int i){
        return 2 * i+1;
    }
    public int parent(int i){
        if(i == 1) {
        	return i;
        }
        return (i/2);      
    }
    public void insertNode(int Index, int Value){    
        if(Index == 1 && BST[Index].getValue() == 0){
            n += 1;
            BST[Index].setValue(Value);
            BST[Index].setX(WIDTH /2 + X);
            BST[Index].setY(0 + 100 * Y);
            return;
        }
        
        if( BST[Index].getValue() == 0 ) {
            n += 1;
            BST[Index].setValue(Value);
            BST[Index].setX(WIDTH /2 + X);
            BST[Index].setY(0 + 100 * Y);
            if(Index != 1) {
            	  lastIndex = Index;
            }
            return;
        }
        //Chuyen sang cay con phai
        if( BST[Index].getValue() < Value){    	
            blip(Index, Color.BLUE, Color.BLACK);
            Y += 1;
            X = X + WIDTH / (int) Math.pow(2,  Y + 1);
            insertNode(right(Index) , Value);
        }
        //Chuyen sang cay con trai
        else if(BST[Index].getValue() > Value){
            blip(Index, Color.BLUE, Color.BLACK);
            //move to left
            Y += 1;
            X = X - WIDTH / (int) Math.pow(2,  Y + 1);
            insertNode(left(Index) , Value);
        }
        else if(BST[Index].getValue() == Value){
            blip(Index, Color.BLUE, Color.BLACK);
            return;
        }
    
    }
    /**
	 * Xac dinh nut can xoa
	 * @param index
	 * @param Value
	 */
   
	public void deleteNode(int index ,int Value) {
		if(BST[index].getValue() == 0) {
			return; 
		}
		//step1
		//gia tri xoa lon hon gia tri cua node i => xet cay con phai
		if(BST[index].getValue() < Value) {
			//nut dang duoc duyet co mau cam
			blip(index,Color.ORANGE);
			deleteNode(right(index), Value);
		}else if(BST[index].getValue() > Value){ //Neu gia tri xoa be hon gia tri cua node i => xet cay con trai
			blip(index,Color.ORANGE);
			deleteNode(left(index), Value);
		}
		//step 3
		// nut xet bang gia tri can xoa
		else {
			n -= 1;
			blip(index,Color.ORANGE);
			//nut co gia tri xoa can tim bao mau do
			blip(index,Color.RED);
			//TH1: Nut khong co con (xoa nut la)
			if(BST[left(index)].getValue() == 0 & BST[right(index)].getValue() == 0) {
				nodeLeaf(index);
			}else {
				//TH2: Nut co con
				String insertAgain ;
				int current = left(index);
				// Neu node xoa chi co con phai
				if(isNull(left(index)) && !isNull(right(index))){
					insertAgain = bfsPath(right(index));
				}
				//Neu node xoa chi co con trai
				else if(!isNull(left(index)) && isNull(right(index)) ) {
					insertAgain = bfsPath(left(index));
				}else {
					//Neu node xoa co du hai con trai va phai
					//Tim nut co gia tri lon nhat cua cay con trai (nut cuoi cung ben phai)
					while(!isNull(right(current))) {
						//nut duoc duyet bao mau cam
						blip(current,Color.ORANGE);
						current = right(current);
					}
					blip(current,Color.ORANGE);
					//nut duoc thay the bao mau xanh
					blip(current,Color.GREEN);
					//gan lai gia tri cho nut moi
					BST[index].setValue(BST[current].getValue());
					lastIndex = -1;
					drawNode(index);
					if(!isNull(left(current)))
						insertAgain = bfsPath(left(current));
					else
						insertAgain ="";
				}
				Scanner scan = new Scanner(insertAgain);
				if((isNull(left(index)) && !isNull(right(index))|| (!isNull(left(index)) && isNull(right(index))))) {
					deleteTree(index);
				}
				else {
					deleteTree(current);
				}
				Graphics g = treePanel.getGraphics();
				while(scan.hasNext()) {
					int rX = WIDTH / 2;
					int rY = 0;
					int toInsert = scan.nextInt();
					X = 0;
					Y = 0; 
                    insertNode( 1 ,  toInsert); 
                    drawLine( parent(lastIndex), lastIndex);
                    lastIndex = -1;
                    drawNode(g, rX + X, rY + 100 * Y, Integer.toString(toInsert));
                    
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
			if(!isNull(left(nextNode.peek())) ) {
				nextNode.add(left(nextNode.peek()));
			}
		    if(!isNull(right(nextNode.peek())) ) {
		    	nextNode.add(right(nextNode.peek()));
		    }
		    nodeLeaf(nextNode.peek());
		    nextNode.remove(nextNode.peek());
		}
		        
	}
	//tim kiem nut vi tri i
	//gia tri j
	public void searchNode(int index, int Value) {
		//khi vi tri nut bang voi gia tri dang tim kiem cho no noi len mau xanh
		if(BST[index].getValue() == Value) {
			//nut dang duoc duyet den co mau cam
			blip(index,Color.ORANGE);
			//nut co gia tri can tim hien mau do
			blip(index,Color.RED);
			//gia tri dang xet nho hon phan tu can tim
			//xet cay ben phai cac nut duoc duyet lan luot noi len mau cam
		}else if(BST[index].getValue() < Value) {
			blip(index,Color.ORANGE);
			searchNode(right(index), Value);
		}
		//xet cay ben trai
		else{
			blip(index,Color.ORANGE);
			searchNode(left(index), Value);
		}
	}
	public boolean isNull(int i) {
		if(BST[i].getValue() == 0) {
			return true;
		}
		return false;
	}
	public String bfsPath(int i) {
		String s ="";
		Queue<Integer> queue = new LinkedList<>();
		queue.add(i);
		while(!queue.isEmpty()) {
			n += 1;
			s += BST[queue.peek()].getValue() +" ";
			if(!isNull(left(queue.peek()))) {
				queue.add(left(queue.peek()));
			}
			if(!isNull(right(queue.peek()))) {
				queue.add(right(queue.peek()));
			}
			queue.remove(queue.peek());
		}
		return s;
	}
	
    public void blip(int i, Color beforeColor, Color afterColor){
        Graphics g1 = treePanel.getGraphics();
        Graphics2D g = (Graphics2D)g1;
        //Duong vien cho hinh tron
        g.setStroke(new BasicStroke(2));
        //Set duong vien cho hinh tron co mau xanh
        g.setColor(beforeColor);
        g.drawOval(BST[i].getX() - 35, BST[i].getY() , 35, 35);
        sleep(timeSleep);
        //Duong vien cho hinh tron co mau den
        g.setColor(afterColor);
        g.drawOval(BST[i].getX() - size , BST[i].getY() , 35, 35);    
    } 
    
    public void blip(int i , Color r){
        Graphics g1 = treePanel.getGraphics();
        Graphics2D g = (Graphics2D)g1;
        g.setStroke(new BasicStroke(2));
        g.setColor(r);
        g.drawOval(BST[i].getX() - size , BST[i].getY() , 35 , 35);
        sleep(timeSleep);
        g.setColor(Color.black);
        g.drawOval(BST[i].getX() - size , BST[i].getY() , 35, 35);
        
    }
    
    //Dung lai khoang thoi gian time
  	public void sleep(int time) {
  		try {
  			Thread.sleep(time);
  		} catch (InterruptedException e) {
  			e.printStackTrace();
  		}	
  	}
    public void drawNode(Graphics g1 , int x , int y, String Value){
        Graphics2D g = (Graphics2D)g1;
        g.setStroke(new BasicStroke(1));
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
            g.setStroke(new BasicStroke(3));
            int parPos = parent(lastIndex);
            
            g.drawLine(BST[parPos].getX() - size/2  , BST[parPos].getY() + size , 
            		BST[lastIndex].getX() - size/2  , BST[lastIndex].getY());   
            
            blip(lastIndex, Color.YELLOW); 
        }   
    }
    public void drawNode(int i) {
		drawNode(treePanel.getGraphics(), BST[i].getX(), BST[i].getY(), Integer.toString(BST[i].getValue()));
		
	}
	public void drawLine(int i,int j) {
		if(i == j) {
			return;
		}
		Graphics2D g = (Graphics2D)treePanel.getGraphics();
		g.drawLine(BST[i].getX() -  35 / 2 , BST[i].getY() + 35 , BST[j].getX() - 35 / 2 , BST[j].getY());
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
	    g.drawLine(BST[parent(i)].getX() - 35 / 2 , BST[parent(i)].getY() + 35 , BST[i].getX() - 35 / 2 , BST[i].getY());
	    BST[i].setValue(0);
	}
    //Ve doan thang noi giua hai node 
  	public void drawLine(int x1, int y1, int x2, int y2) {
  		Graphics g = this.getGraphics();
  		Graphics2D g2 = (Graphics2D) g;
  		//Set mau cho doan thang noi giua hai node
  		g.setColor(Color.ORANGE);
  		g2.setStroke(new BasicStroke(5));
  		g2.drawLine(x1, y1, x2, y2);
  	}
  	public void PreorderTraversal(int Index) {
  		if(BST[Index].getValue() == 0) {
  			return;
  		}
        blip(Index, Color.BLUE, Color.BLACK);
             
        PreorderTraversal(left(Index));
             
        PreorderTraversal(right(Index));	
  	}
  	public void InorderTraversal(int Index) {
  		if(BST[Index].getValue() == 0) {
  			return;
  		}    
  		InorderTraversal(left(Index));
        blip(Index, Color.BLUE, Color.BLACK);  
        InorderTraversal(right(Index));	
  	}
  	public void PostorderTraversal(int Index) {
  		if(BST[Index].getValue() == 0) {
  			return;
  		}
        PostorderTraversal(left(Index));
        PostorderTraversal(right(Index));	
        blip(Index, Color.BLUE, Color.BLACK);
  	}
  	
	private void update() {
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
			BST[i] = new Node();
		}
	    new BinarySearchTreeGUI(); 
	}

}