package BinarySearchTreeGUI;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Traversal extends Button{
	private String Preorder = "";
	private String Inorder = "";
	private String Postorder = "";

	public static int defaultsize = 1000;
	protected Node[] BST = new Node[defaultsize];

	JLabel PreorderLabel = new JLabel("Preorder"),
			InorderLabel = new JLabel("Inorder "),
			PostorderLabel = new JLabel("Postorder ");

	JTextField PreorderField = new JTextField(),
			InorderField = new JTextField(),
			PostorderField = new JTextField();

	JPanel TraversePanel = new JPanel();

	JLabel Labels[] = { PreorderLabel, InorderLabel, PostorderLabel };
	JTextField TextFields[] = { PreorderField, InorderField, PostorderField };

	public Traversal() {
		creatTraversal();
	}

	public void setBST(Node[] BST) {
		this.BST = BST;
	}

	public String getPreorder() {
		return Preorder;
	}

	public void setPreorder(String preorder) {
		Preorder = preorder;
	}

	public String getInorder() {
		return Inorder;
	}

	public void setInorder(String inorder) {
		Inorder = inorder;
	}

	public String getPostorder() {
		return Postorder;
	}

	public void setPostorder(String postorder) {
		Postorder = postorder;
	}

	public void creatTraversal() {
		int X_Label = 5, Y_Label = 620;
		int WIDTH_Label = 120, HEIGHT_Label = 40;
		for(JLabel label: Labels) {
			label.setFont(get_Font());
			label.setForeground(new Color(65, 136, 218));
			label.setBounds(X_Label, Y_Label, WIDTH_Label, HEIGHT_Label);
			//label.setBackground(Color.GREEN);
			//label.setOpaque(true);
			Y_Label += 42;
			TraversePanel.add(label);
			
		}
		
		int X_Field = 120, Y_Field = 620;
		int WIDTH_Field = 340, HEIGHT_Field = 40;
		for(JTextField textfield: TextFields) {
			textfield.setFont(get_Font());
			textfield.setBackground(Color.WHITE);
			textfield.setBounds(X_Field, Y_Field, WIDTH_Field, HEIGHT_Field);
			Y_Field += 42;
			TraversePanel.add(textfield);
			
		}	

	}

	public int height(int i) {
		if (BST[i].getValue() == 0) {
			return -1;
		}
		return Math.max(height(left(i)), height(right(i))) + 1;
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

	public void PostOrder(int i) {
		if (BST[i].getValue() > 0) {
			if (left(i) != 0)
				PostOrder(left(i));
			if (right(i) != 0)
				PostOrder(right(i));
			Postorder = Postorder + " " + Integer.toString(BST[i].getValue());
		}
	}

	public void Preorder(int i) {
		if (BST[i].getValue() > 0) {
			Preorder = Preorder + " " + Integer.toString(BST[i].getValue());
			if (left(i) != 0)
				Preorder(left(i));
			if (right(i) != 0)
				Preorder(right(i));
		}
	}

	public void Inorder(int i) {
		if (BST[i].getValue() > 0) {
			if (left(i) != 0)
				Inorder(left(i));

			Inorder = Inorder + " " + Integer.toString(BST[i].getValue());
			if (right(i) != 0)
				Inorder(right(i));
		}
	}

}