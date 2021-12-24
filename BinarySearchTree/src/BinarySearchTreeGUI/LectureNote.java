package BinarySearchTreeGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class LectureNote implements ItemListener{
	JFrame frame;
	String [] items = {"1. Binary search tree", 
			   "2. Insert", "     2-1. Insert time complexity", 
			   "3. Delete", "     3-1. Delete node leaf", "     3-2. Delete node has 1 child", "     3-3. Delete node has 2 child", 
			   "4. Find", "     4-1. Min and Max",
			   "5. Inorder traversal", "     5-1. Inorder traversal time complexity"};
	
	JComboBox<String> ListLecture = new JComboBox();
	
	JTextArea Text = new JTextArea();
	JLabel Image = new JLabel();
	String TextLecture ="";
	ImageIcon Icon = new ImageIcon();
	String PathIcon = "";
	
	public LectureNote() {
		frame = new JFrame("Lecture Note");
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setSize(700, 400);
		
		ListLecture = new JComboBox(items);
		ListLecture.setBounds(200, 5, 300, 40);
		ListLecture.setBackground(new Color(65, 136, 218));
		ListLecture.addItemListener((ItemListener) this);
        frame.add(ListLecture);
        
        Text.setBounds(5, 55, 720, 100);
        
        Image.setBounds(5, 80, 720, 500);
        //Image.setOpaque(true);
        //Image.setBackground(Color.BLUE);
        
        //ImageIcon BST = new ImageIcon("/C:/Users/Asus/eclipse-workspace/BinarySearchTree/images/BST.png");
        //ImageIcon BST = new ImageIcon("images/BST.png");
        //Image.setIcon(BST);
        frame.add(Text);
        
        frame.add(Image);
        Text.setFont(new Font("NewellsHand", Font.PLAIN, 18));
        Text.setBackground(Color.WHITE);
        
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
			InorderTraversal();
			break;
		case "     5-1. Inorder traversal time complexity":
			InorderTraversalTimeComplexity();		
			
			
		
			
			
		}
		
		Text.setLineWrap(true);
        Text.setText(TextLecture);
        Image.setIcon(new ImageIcon(PathIcon));
        
		
		/*
		if (e.getSource() == ListLecture.getSelectedItem()) {
            l1.setText(ListLecture.getSelectedItem() + " duoc chon");
            String content="A Binary Search Tree (BST) is a binary tree in which each vertex has only up to 2 children that satisfies BST property: All vertices in the left subtree of a vertex must hold a value smaller than its own and all vertices in the right subtree of a vertex must hold a value larger than its own (we have assumption that all values are distinct integers in this visualization and small tweak is needed to cater for duplicates/non integer)";
            Text.setLineWrap(true);
            Text.setText(content);
            
        }
        */
	}
	public void IntroductionLecture() {
		TextLecture = "A Binary Search Tree (BST) is a binary tree in"
				+ " which each vertex has only up to 2 children that satisfies BST property: "
				+ "All vertices in the left subtree of a vertex must hold a value smaller than its own and all vertices in the right subtree of a vertex must hold a value larger than its own "
				+ "(we have assumption that all values are distinct integers in this visualization and small tweak is needed to cater for duplicates/non integer)";
		PathIcon = "/C:/Users/Asus/eclipse-workspace/BinarySearchTree/images/BST.png";
	}
	public void InsertLecture() {
		TextLecture = "We can insert a new integer into BST by doing similar operation as Search(v).\r\n"
				+ "But this time, instead of reporting that the new integer is not found, we create a new vertex in the insertion point and put the new integer there";
	}
	public void InsertTimeLecture() {
		TextLecture = "Insert(v) runs in O(h) where h is the height of the BST.\r\n"
				+ "By now you should be aware that this h can be as tall as O(N) in a normal BST as shown in the random 'skewed right' example above. \r\n"
				+ "If we call Insert(FindMax()+1), i.e. we insert a new integer greater than the current max, we will go from root down to the last leaf and then insert \r\n"
				+"the new integer as the right child of that last leaf in O(N) time — not efficient "
				+ "(note that we only allow up to h=9 in this visualization).";
		
	}
	public void DeleteLecture() {
		TextLecture = "We can remove an integer in BST by performing similar operation as Search(v).\r\n"
				+ "If v is not found in the BST, we simply do nothing.\r\n"
				+ "If v is found in the BST, we do not report that the existing integer v is found, but instead, we perform one of the three possible removal cases that will be elaborated in three separate slides (we suggest that you try each of them one by one).";
	}
	public void DeleteLecture1() {
		TextLecture = "The first case is the easiest: Vertex v is currently one of the leaf vertex of the BST.\r\n"
				+ "Deletion of a leaf vertex is very easy: We just remove that leaf vertex — try Remove(5) on the example BST above (second click onwards after the first removal will do nothing — please refresh this page or go to another slide and return to this slide instead).\r\n"
				+ "This part is clearly O(1) — on top of the earlier O(h) search-like effort.";
		
	}
	public void DeleteLecture2() {
		TextLecture = "The second case is also not that hard: Vertex v is an (internal/root) vertex of the BST and it has exactly one child. Removing v without doing anything else will disconnect the BST.\r\n"
				+ "Deletion of a vertex with one child is not that hard: We connect that vertex's only child with that vertex's parent — try Remove(23) on the example BST above (second click onwards after the first removal will do nothing — please refresh this page or go to another slide and return to this slide instead).\r\n"
				+ "This part is also clearly O(1) — on top of the earlier O(h) search-like effort.";
	}
	public void DeleteLecture3() {
		TextLecture = "The third case is the most complex among the three: Vertex v is an (internal/root) vertex of the BST and it has exactly two children. Removing v without doing anything else will disconnect the BST.\r\n"
				+ "Deletion of a vertex with two children is as follow: We replace that vertex with its successor, and then delete its duplicated successor in its right subtree — try Remove(6) on the example BST above (second click onwards after the first removal will do nothing — please refresh this page or go to another slide and return to this slide instead).\r\n"
				+ "This part requires O(h) due to the need to find the successor vertex — on top of the earlier O(h) search-like effort.";
		
	}
	public void FindLecture() {
		TextLecture = "Because of the way data (distinct integers for this visualization) is organised inside a BST, we can binary search for an integer v efficiently (hence the name of Binary Search Tree).\r\n"
				+ "First, we set the current vertex = root and then check if the current vertex is smaller/equal/larger than integer v that we are searching for. We then go to the right subtree/stop/go the left subtree, respectively. We keep doing this until we either find the required vertex or we don't.\r\n";
	}
	public void FindMinAndMax() {
		TextLecture = "Similarly, because of the way data is organised inside a BST, we can find the minimum/maximum element (an integer in this visualization) by starting from root and keep going to the left/right subtree, respectively.\r\n";
				
	}
	public void InorderTraversal() {
		TextLecture = "We can perform an Inorder Traversal of this BST to obtain a list of sorted integers inside this BST (in fact, if we 'flatten' the BST into one line, we will see that the vertices are ordered from smallest/leftmost to largest/rightmost).\r\n"
				+ "Inorder Traversal is a recursive method whereby we visit the left subtree first, exhausts all items in the left subtree, visit the current root, before exploring the right subtree and all items in the right subtree";
	}
	public void InorderTraversalTimeComplexity() {
		TextLecture = "Inorder Traversal runs in O(N), regardless of the height of the BST.\r\n"
				+ "Discussion: Why?\r\n"
				+ "PS: Some people call insertion of N unordered integers into a BST in O(N log N) and then performing the O(N) Inorder Traversal as 'BST sort'. It is rarely used though as there are several easier-to-use (comparison-based) sorting algorithms than this.";
	}
	

}
