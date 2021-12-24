package BinarySearchTree;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class LinkedBinarySearchTree <T extends Comparable<T>> implements BinarySearchTreeInterface<T>{
	
	private Node<T> root;
	private int count = 0;
	String File = "";
	
	public LinkedBinarySearchTree() {
		
	}
	
	public Node<T> getRoot() {
		return root;
	}
	public void setRoot(Node<T> root) {
		this.root = root;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public T root() {
		return (T) root;
	}
	@Override
	public int size() {
		return count;
	}
	@Override
	public boolean isEmpty() {
		if(count == 0) {
			return true;
		}
		return false;
	}
	@Override
	public void find(T value) {
		
	}
	@Override
	public void insert(T value) {
		
	}
	@Override
	public void delete(T value) {
		
	}
	@Override
	public T Min() {
		return findMin(root);
	}
	@Override
	public T Max() {
		return findMax(root);
	}
	@Override
	public T parent(T p) {
		if(!(p instanceof Node)) {
			return null;
		}
		Node child = (Node) p;
		if(isEmpty()) {
			return null;
		}
		if(child == null) {
			return null;
		}
		return (T) child.getParent();
	}
	@Override
	public T left(T p) {
		if(!(p instanceof Node)) {
			return null;
		}
		Node<T> parent= (Node<T>) p;
		//Tree is null
		if(isEmpty()) {
			return null;			
		}
		return (T) parent.getLeft();
	}
	@Override
	public T right(T p) {
		if(!(p instanceof Node)) {
			return null;
		}
		Node parent = (Node) p;
		//Tree is null
		if(isEmpty()) {
			return null;
		}
		return (T) parent.getLeft();	
	}
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	public T sibling(T p) {
		if(!(p instanceof Node)) {
			return null;		
		}
		Node<T> Current = (Node<T>) p;
		Node<T> parent = Current.getParent();
		Node<T> left = parent.getLeft();
		Node<T> right = parent.getRight();
		
		//Tree is null
		if(isEmpty() || Current == null) {
			return null;
		}
		
		//If curr is right child, sibling is left child
		if(Current == right)
			return (T) left;
		else {
			return (T) right;
		}
	}
	
	public Node<T> addRoot(T value){
		if(isEmpty() == true) {
			Node<T> node = new Node<T>(value, null, null, null);
			root = node;
			count += 1;
		}
		else {
			root.setValue(value);
		}
		return root;
	}
	public Node<T> addLeft(Node<T> node, T value){
		if(size() == 0 || node == null) {
			return null;
		}
		if(node.getLeft() == null) {
			Node<T> newNode = new Node<T>(value, node, null, null);
			node.setLeft(newNode);
			count += 1;
		}
		else {
			node.getLeft().setValue(value);
		}
		return node.getLeft();
		
	}
	
	public Node<T> addRight(Node<T> node, T value){
		if(isEmpty() == true|| node == null) {
			return null;
		}
		if(node.getRight() == null) {
			Node<T> newNode = new Node<T>(value, node, null, null);
			node.setRight(newNode);
			count += 1;
		}
		else {
			node.getRight().setValue(value);
		}
		return node.getRight();
	}
	public int numChildren(T p) {
		if(isEmpty()) {
			return -1;
		}
		int countChild = 0;
		Node<T> parent = (Node<T>) p;
		if(parent.getLeft() != null) {
			countChild += 1;
			if(parent.getRight() != null) {
				countChild += 1;
			}
		}

		return countChild;
	}
	
	public void set(Node<T> node, T value) {
		if(isEmpty() == true || node == null) {
			return;
		}
		node.setValue(value);
	}
	
	public void add(T value) {
		root = insert(root, value);
		count += 1;
	}

	public Node<T> insert(Node<T> Current, T Value) {
		if(Current == null) {
			return null;
		}
		if(Value.compareTo(Current.getValue()) < 0) {
			if(Current.getLeft() != null) {
				insert(Current.getLeft(), Value);
			}
			else {
				Current.setLeft( new Node<T>(Value, Current, null, null));
			}
		}
		
		if(Value.compareTo(Current.getValue()) > 0) {
			if(Current.getRight() != null) {
				insert(Current.getRight(), Value);
			}
			else {
				Current.setRight( new Node<T>(Value, Current, null, null));
			}
		}
		return Current;
	}
	
	public void deleteNode(T value) {
		root = delete(root, value);
	}
	
	// ham de quy xoa phan tu
	public Node<T> delete(Node<T> node, T Value) {
		if(node.getLeft() == null && node.getRight() == null) {
			if(Value.compareTo(node.getValue()) == 0) {
				node = null;
				count -= 1;
			}else{
				return null;
			}
		}else if (node.getLeft() == null) {
			if(Value.compareTo(node.getValue()) == 0) {
				node = node.getRight();
			}
			else {
				delete(node.getRight(), Value);
			}
		}
		else if(node.getRight() == null) {
			if(Value.compareTo(node.getValue()) == 0) {
				node = node.getLeft();
			}
			else {
				delete(node.getLeft(), Value);
			}
		}
		else if(node.getLeft() != null && node.getRight() != null) {
			if(Value.compareTo(node.getValue()) == 0) {
				findMin(node.getRight());
				delete(node.getRight(), Value);
			}//Nho hon thi de quy xoa cay con trai
			else if (Value.compareTo(node.getValue()) < 0) {
				delete(node.getLeft(), Value);
			}//Lon hon thi de quy xoa cay con phai
			else {
				delete(node.getRight(), Value);
			}
		}
		return node;
	}

	public Node<T> get(Node<T> Current, T element) {
		if (Current.Value == element || Current == null)
            return Current;
		if (element.compareTo(Current.getValue()) > 0) {
            return get(Current.getRight(), element);
        }
        return get(Current.getLeft(), element);
    }
	
	//Tim Node co gia tri value
	//Tra lai False neu ta khong the tim thay gia tri trong cay
	public boolean find(Node<T> Current, T Value) {
		if (Current == null) {
			return false;
		}
		// neu hai gtri bang nhau, chinh xac, tra ve True
        if (Value.compareTo(Current.getValue()) == 0) {
        	
            return true;
        }//Gia tri lon hon thi de quy tim kiem ben cay con phai
        else if (Value.compareTo(Current.getValue()) > 0) {
            return find(Current.getRight(), Value);
        }
        return find(Current.getLeft(), Value);
    }
	
	public boolean containValue(T value) {
		return find(root, value);
	}
	
	//Inorder Traversal
	public void display(Node<T> node) {
		if (node == null) {
			return;
		}
		// goi de quy phuong thuc hien thi cay con ben trai
		display(node.Left);
		// truy cap vao nut hien tai
		System.out.print(node.Value + " ");
		// goi de quy phuong thuc hien thi cho cay con ben phai
		display(node.Right);
	}
	
	// Di theo huong sang ben trai den gtri nho nhat ( di theo mot huong)
	public T findMin(Node<T> node) {
		while (node.Left != null) {
			node = node.Left;
		}
		return node.getValue();
	}

	// di theo mot huong sang ben phai de tim cai lon nhat
	public T findMax(Node<T> node) {
		while (node.Right != null) {
			node =  node.Right;
		}
		return node.Value;
	}
	public int getHeight(Node<T> node) {
		
		int leftHeight = 0;
		int rightHeight = 0;

		if(node == null) {
			return 0;
		}
		if (node.Left != null) {
			leftHeight = getHeight(node.Left);
		}
		if (node.Right != null) {
			rightHeight = getHeight(node.Right);
		}
		return 1 + Math.max(leftHeight, rightHeight);
	}

	public int getSize(Node<T> node) {
		int leftSize = 0, rightSize = 0;

		if (node.Left != null) {
			leftSize = getSize(node.Left);
		}
		if (node.Right != null) {
			rightSize = getSize(node.Right);
		}

		return 1 + leftSize + rightSize;
	}
	
	public String inorder(Node<T> root) {
		if (root == null)
			return "";

		return inorder(root.Left) + " " +root.Value + " " + inorder(root.Right);
	}
	public String preorder(Node<T> root) {
		if (root == null)
			return "";

		return root.Value + " " + preorder(root.Left)+ " "  + preorder(root.Right);
	}
	public String postorder(Node<T> root) {
		if (root == null)
			return "";

		return postorder(root.Left)+ " "  + postorder(root.Right) + " "+ root.Value;
	}
	public void printTree() {
		print(root,0);
	}
	public void print(Node<T> p, int level) {
		if(p == null) {
			return;
		}
		print(p.getRight(), level + 1);
		for(int i = 0; i < level; i++) {
			System.out.print("\t");
		}
		System.out.println(p.getValue());
		print(p.getLeft(), level + 1);
	}
	

	
	public void printText(Node<T> p, int level) {
		if(p == null) {
			return;
		}
		printText(p.getRight(), level + 1);
		for(int i = 0; i < level; i++) {
			File +="\t";
		}
		File += p.getValue()+"\n";
		printText(p.getLeft(), level + 1);
	}
	
	/*
	 *Print tree in file
	 *Change path
	 */
	public void printFile() throws IOException{
		File="";
		String path = "/C://Users//Asus//eclipse-workspace//BinarySearchTree//src//BinarySearchTree//TestLinkedBinarySearchTree.txt";
		printText(root, 0);
		FileWriter writer = new FileWriter(path);
		writer.write(File);
		writer.close();
	}
	

}
