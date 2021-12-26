package BinarySearchTreeGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class LectureNote implements ItemListener{
	JFrame frame;
<<<<<<< HEAD
	String [] items = {"1. Binary search tree", "     1-1. BST Property", "     1-2. BST Node Attributes",
					   "2. Insert", "     2-1. Insert time complexity", 
					   "3. Delete", "     3-1. Delete node leaf", "     3-2. Delete node has 1 child", "     3-3. Delete node has 2 child", 
					   "4. Find", "     4-1. Min and Max",
					   "5. Traversal", "     5-1. Inorder Traversal", "     5-2. Preorder Traversal", "     5-3. Postorder Traversal"};
=======
	String [] items = {"1. Binary search tree", 
			   "2. Insert", "     2-1. Insert time complexity", 
			   "3. Delete", "     3-1. Delete node leaf", "     3-2. Delete node has 1 child", "     3-3. Delete node has 2 child", 
			   "4. Find", "     4-1. Min and Max",
			   "5. Inorder traversal", "     5-1. Inorder traversal time complexity"};
>>>>>>> be8c7062fe0b9e632273482b1ba6f41eaa6d1daf
	
	JComboBox<String> ListLecture = new JComboBox<String>();
	
	JTextArea Text = new JTextArea();
	JLabel Image = new JLabel();
	String TextLecture ="";
	ImageIcon Icon = new ImageIcon();
	String PathIcon = "";
	
	public LectureNote() {
		frame = new JFrame("Lecture Note");
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setSize(800, 620);
		
		ListLecture = new JComboBox<String>(items);
		ListLecture.setBounds(200, 10, 400, 35);
		ListLecture.setBackground(new Color(65, 136, 218));
		ListLecture.setSelectedIndex(0);
		ListLecture.addItemListener((ItemListener) this);
		
		TextLecture = " A Binary Search Tree (BST) is a binary tree in which each node has only up to 2 children that satisfies.\r\n"
				+ "\r\n"
				+ " BST property: \r\n "
				+ "\r\n"
				+ "    + All nodes in the left subtree of a node must hold a value smaller than its own and \r\n "
				+ "\r\n"
				+ "    + All nodes in the right subtree of a node must hold a value larger than its own.";
		
		PathIcon = "images/Introduction.png";
		
		Text.setText(TextLecture);
        Image.setIcon(new ImageIcon(PathIcon));
		
        frame.add(ListLecture);
        
        Text.setBounds(20, 55, 750, 200);
        Image.setBounds(200, 270 , 400, 300);
        
        frame.add(Text);
        frame.add(Image);
        Text.setFont(new Font("NewellsHand", Font.PLAIN, 14));
        
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
		
	}

    // main class
    public static void main(String[] args) {

        new LectureNote();
    }

	@Override
	public void itemStateChanged(ItemEvent e) {
		String ValueLecture = (String) ListLecture.getSelectedItem();
		
		switch(ValueLecture) {
		case "1. Binary search tree":
			IntroductionLecture();
			break;
		case "     1-1. BST Property":
			Property();
			break;
		case "     1-2. BST Node Attributes":
			NodeAttributes() ;
			break;
		case "2. Insert":
			InsertLecture();
			break;
		case "     2-1. Insert time complexity":
			InsertTimeLecture();
			break;
		case "3. Delete":
			DeleteLecture();
			break;
		case "     3-1. Delete node leaf":
			DeleteLecture1();
			break;
		case "     3-2. Delete node has 1 child":
			DeleteLecture2();
			break;
		case "     3-3. Delete node has 2 child":
			DeleteLecture3();
			break;
		case "4. Find":
			FindLecture();
			break;
		case "     4-1. Min and Max":
			FindMinAndMax();
			break;
		case "5. Inorder traversal":
			break;
		case "     5-1. Inorder Traversal":
			InorderTraversal();
			break;
		case "     5-2. Preorder Traversal":
			PreorderTraversal();
			break;
		case "     5-3. Postorder Traversal":
			PostorderTraversal();
		
			
		}
		
		Text.setLineWrap(true);
        Text.setText(TextLecture);
        Image.setIcon(new ImageIcon(PathIcon));
       
	}
	public void IntroductionLecture() {
		TextLecture = " A Binary Search Tree (BST) is a binary tree in which each node has only up to 2 children that satisfies.\r\n"
				+ "\r\n"
				+ " BST property: \r\n "
				+ "\r\n"
				+ "    + All nodes in the left subtree of a node must hold a value smaller than its own and \r\n "
				+ "\r\n"
				+ "    + All nodes in the right subtree of a node must hold a value larger than its own.";
		
		PathIcon = "images/Introduction.png";
	}
	public void Property() {
		TextLecture = " For every node X: \r\n"
				+ "\r\n"
				+ "   + All nodes on the left subtree of X are strictly smaller than X  \r\n"
				+ "\r\n"
				+ "   + All nodes on the right subtree of X are strictly greater than X.";
		PathIcon = null;
	}
	public void NodeAttributes() {
		TextLecture = " Each node has at least 4 attributes: parent, left, right, key/value/data (there are potential other attributes). \r\n"
				+ "\r\n"
				+ " Not all attributes will be used for all nodes, e.g. the node root will have its parent attribute = NULL.\r\n"
				+ "\r\n"
				+ " The left/right child of a node (except leaf) is drawn on the left/right and below of that node, respectively. \r\n"
				+ "\r\n"
				+ " The parent of a node (except root) is drawn above that node.\r\n"
				+ "\r\n"
				+ "The (integer) key of each node is drawn inside the circle that represent that node.";
		PathIcon = null;
	}
	public void InsertLecture() {
		TextLecture = "We can insert a new integer into BST by doing similar operation as Search(v).\r\n"
				+ "\r\n"
				+ "We create a new vertex in the insertion point and put the new integer there";
		PathIcon = "images/Insert.png";
	}
	public void InsertTimeLecture() {
		TextLecture = "Insert(v) runs in O(h) where h is the height of the BST.\r\n"
				+ "\r\n"
				+ "By now you should be aware that this h can be as tall as O(N) in a normal BST as shown in the random 'skewed right'example above. \r\n"
				+ "\r\n"
				+ "If we call Insert(FindMax()+1), we insert a new integer greater than the current max, we will go from root down to the last leaf and then insert \r\n"
				+"the new integer as the right child of that last leaf in O(N) time — not efficient ";
		PathIcon = null;
	}
	public void DeleteLecture() {
		TextLecture = "We can remove an integer in BST by performing similar operation as Find(v).\r\n"
				+ "\r\n"
				+ "If v is not found in the BST, we simply do nothing.\r\n"
				+ "\r\n"
				+ "If v is found in the BST, we do not report that the existing integer v is found, \r\n"
				+ "\r\n"
				+ "But instead, we perform one of the three possible removal cases that will be elaborated in three separate slides.";
		PathIcon = null;
	}
	public void DeleteLecture1() {
		TextLecture = "The first case is the easiest: Node v is currently one of the node leaf of the BST.\r\n"
				+ "\r\n"
				+ "Deletion of a  node leaf is very easy: We just remove that node leaf.\r\n"
				+ "\r\n"
				+ "This part is clearly O(1) — on top of the earlier O(h) search-like effort.";
		PathIcon = "images/Delet1.png";
	}
	public void DeleteLecture2() {
		TextLecture = "Node v is an (internal/root) node of the BST and it has exactly one child. \r\n"
				+ "\r\n"
				+ "Removing v without doing anything else will disconnect the BST.\r\n"
				+ "\r\n"
				+ "Deletion of a node with one child is not that hard: We connect that node's only child with that node's parent.\r\n"
				+ "\r\n"
				+ "This part is also clearly O(1) — on top of the earlier O(h) search-like effort.";
		PathIcon = "images/Delete2.png";
	}
	public void DeleteLecture3() {
		TextLecture = "Vertex v is an (internal/root) vertex of the BST and it has exactly two children. Removing v without doing anything else will disconnect the BST.\r\n"
				+ "\r\n"
				+ "Deletion of a vertex with two children is as follow: We replace that vertex with its successor,\r\n"
				+ "and then delete its duplicated successor in its right subtree — try Remove(6) on the example BST above (second click onwards after the first removal will do nothing — please refresh this page or go to another slide and return to this slide instead).\r\n"
				+ "\r\n"
				+ "This part requires O(h) due to the need to find the successor vertex — on top of the earlier O(h) search-like effort.";
		PathIcon = "images/Delete3.png";
		
	}
	public void FindLecture() {
		TextLecture = "First, we set the current node = root. \r\n"
				+ "\r\n"
				+ "Then check if the current node is smaller/equal/larger than integer v that we are searching for. \r\n"
				+ "\r\n"
				+ "We then go to the right subtree/stop/go the left subtree, respectively. \r\n"
				+ "\r\n"
				+ "We keep doing this until we either find the required node or we don't. \r\n";
		PathIcon = null;
	}
	public void FindMinAndMax() {
		TextLecture = "We can find the minimum/maximum element by starting from root and keep going to the left/right subtree, respectively.";
		PathIcon = null;		
	}
	public void InorderTraversal() {
		TextLecture = "We can perform an Inorder Traversal of this BST to obtain a list of sorted integers inside this BST.\r\n"
				+ "\r\n"
				+ "Inorder Traversal is a recursive method whereby we visit the left subtree first, \r\n"
				+ "\r\n"
				+ "exhausts all items in the left subtree, \r\n"
				+ "\r\n"
				+ "visit the current root, \r\n"
				+ "\r\n"
				+ "before exploring the right subtree and all items in the right subtree.";
		PathIcon = "images/Inorder.png";
	}
	public void PreorderTraversal() {
		TextLecture = "In this traversal method, the root node is visited first, then the left subtree and finally the right subtree.";
		PathIcon = "images/Preorder.png";
	}
	public void PostorderTraversal() {
		TextLecture = "In this traversal method, the root node is visited last, hence the name. \r\n"
				+ "First we traverse the left subtree, then the right subtree and finally the root node.";
		PathIcon = null;
	}
	
	

}
