package BinarySearchTree;

import java.io.FileWriter;
import java.io.IOException;

public class BinarySearchTreeArray<T extends Comparable<T>> {
	T[] tree;
	protected int height;
	protected int maxIndex;
	
	static final int COUNT = 10;
	
	
	public BinarySearchTreeArray(int size) {
		tree = (T[]) new Comparable[size];
		height = 1;
		maxIndex = -1;
	}
	
	public void insert(T value) {
		int i = 0; // Bo dem duyet mang
		while (i < tree.length && tree[i] != null) { // ket thuc mang hoac khi tim thay gtri null
			if (value.compareTo(tree[i]) < 0) { // value nhap vao nho hon gtri hien co trong mang
				// dich chuyen sang trai
				i = (2*i) + 1;
				maxIndex = i*2 + 1;
			}else {
				// dich chyuen sanh phai cua cay
				i = (2*i) + 2;
				maxIndex = i*2+2;
			}
		}
		tree[i] = value;
	}
	
	public void find(T value) {
		int i = 0;// bo dem duyet mang
		boolean found = false;
		while (i < tree.length) { // ket thuc khi duyet het mang hoac tim thay value
			if (value.compareTo(tree[i]) < 0) { // du lieu duoc tim kiem nho hon du lieu co trong mang
				// dich chuyen sang ben trai cua cay
				i = (2 * i) + 1; 
			}else if (value.compareTo(tree[i]) > 0) {
				//dich chuyen sang ben phai cua cay
				i = (2 * i) + 2;
			}else { // value giong voi tree[i]
				found = true;
				break;
			}
		}
		if (found) { //value duoc tim thay
			System.out.println(value + " found at " + i + ".");
		}else { // value khong duoc tim thay
			System.out.println(value + " not found.");
		}
	}
	
	public int[] findDel(T value) {
		int[] indices = new int[2];
		boolean found = false;
		int c = 0; // Child
		int p = 0; // Parent
		while (c < tree.length && tree[c] != null) { //ket thuc khi duyet het mang hoac tim thay vale
			if (value.compareTo(tree[c]) < 0) { //du lieu duoc tim kiem nho hon du lieu co trong mang
				p = c;
				//di chuyen sang phia ben trai cua cay
				c = (2 * c) + 1; 
			}else if (value.compareTo(tree[c]) > 0) {
				p = c;
				// di chuyen sang phia ben phai cua cay
				c = (2 * c) + 2; 
			}else {
				found = true;
				break;
			}
		}
		if (found) {
			indices[0] = p;
			indices[1] = c;
			return indices;
		}else {
			return null;
		}
	}
	
	public void delNoChlid(int child_index) {
		tree[child_index] = null;
	}
	
	public void delOneChild(int child_index, int left, int right) {
		if (tree[right] == null) { // một con ở bên trái
			//Vị trí sẽ bị xóa được thay thế bằng nút bên trái ngay lập tức
			tree[child_index] = tree[left]; 
			//Một biến được sử dụng để lưu trữ phía bên phải của nút bên trái ngay lập tức
			int right_temp = (2*left) + 2;
			//Một biến được sử dụng để lưu trữ phía bên trai của nút bên trái ngay lập tức
			int left_temp = (2*left) + 1;
			while (right_temp < tree.length && left_temp < tree.length) { // vong lap cho toi khi het cay
				// di chuyen len mot bac o phia ben trai
				tree[left] = tree[left_temp]; 
				// cap nhat lai con tro
				left = left_temp;
				// d chuyen len mot bac o phia ben phai
				tree[right] = tree[right_temp];
				right = right_temp;
				
				//cap nhat nut ngoai cung cua ben phai
				right_temp = (2 * right) + 2;
				// cap nhat lai nut ngoai cung ben trai
				left_temp = (2 * left) + 1;
			}
			
			// dat cac nut cuoi cung la null vi tat ca cac nut truoc do da tang len mot bac
			tree[left] = null;
			tree[right] = null;
		}
		 else if (tree[left] == null) { //The one child is at the right
	            tree[child_index] = tree[right]; //The place to be deleted is replaced by the immediate right node
	            int right_temp = (2 * right) + 2; //A variable used to store the right side of the immediate right node
	            int left_temp = (2 * right) + 1; //A variable used to store the left side of the immediate right node
	            while (right_temp < tree.length && left_temp < tree.length) { //Until the end of tree
	                tree[left] = tree[left_temp]; //Moving up one level on the left side
	                left = left_temp; //A sort of pointer being updated for the left side
	                tree[right] = tree[right_temp]; //Moving up one level on the right side
	                right = right_temp; //A sort of pointer being updated for the right side

	                right_temp = (2 * right) + 2; //Right-most node of updated right
	                left_temp = (2 * left) + 1; //Left-most node of updated left
	            }
	            //Setting the last nodes as null as all the preceding nodes have moved up one level
	            tree[left] = null;
	            tree[right] = null;
	        }
	}
	
	public void delete(T value) {
		if (findDel(value) == null) {
			System.out.printf("\nKhong tim thay value, khong the xoa. \nDanh sach khong doi\n");
			int temp = maxIndex;
			maxIndex = -1;
			for (int i = 0; i <= temp; i++) {
				if (tree[i] != null) {
					maxIndex = i;
				}
			}
			height = (int)(Math.log(maxIndex+1) / Math.log(2)) + 1;
			return;
		}else {
			int[] ref = findDel(value);
			int c = ref[1];
			int right = (2*c) + 2;
			int left = (2 * c) + 1;
			System.out.printf("\nDeleting " + tree[c] + "\n");
			// TH khong con
			if ((right > tree.length || left > tree.length) || (tree[left] == null && tree[right] == null)) {
				delNoChlid(c);
			}// TH 1 con
			else if ((tree[right] == null && tree[left] != null) || (tree[right] != null && tree[left] == null)) {
				delOneChild(c, left, right);
			}else { // TH 2 con
				// dich chuyen sang ben phai cua nut se bi xoa
				int temp = right; 
				int temp2 = 0;
				while (tree[temp] != null) { // Cho toi khi ben phai rong
					temp2 = temp; // Vi tam thoi null se o cuoi vong lap, su dung mot bien de luu tru gia tri truoc do
					temp = (2 * temp) + 1;
				}
				// gia tri cua temp2 duoc sao chep tai nut se bi xoa
				tree[c] = tree[temp2]; 
				c = temp2; // cap nhat con de thuc hien xoa no chlid
				//phai va trai dc cap nhat de thuc hien xoa temp2
				right = (2* c) + 2;
				left = (2 * c) + 1;
				if ((right > tree.length || left > tree.length) || (tree[left] == null && tree[right] == null))  {
					delNoChlid(c);
				}else if ((tree[right] == null && tree[left] != null) || (tree[right] != null && tree[left] == null)) {
					delOneChild(c, left, right);
				}
			}
		}
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getMaxIndex() {
		return maxIndex;
	}
	
	//In-order implementation
	public void traverse(int i) {
		if (i < tree.length && tree[i] != null) {
			traverse((2 * i) + 1);
			System.out.print(tree[i] + " ");
			traverse((2*i) + 2); 
		}
	}

	
	public void preOrder(int i) {
		if (i < tree.length && tree[i] != null) {
			System.out.print(tree[i] + " ");
			preOrder((2*i) + 1);
			preOrder((2*i) + 2);
		}
	}
	
	public void postOrder(int i) {
		if (i < tree.length && tree[i] != null) {
			preOrder((2*i) + 1);
			preOrder((2*i) + 2);
			System.out.print(tree[i] + " ");
		}
	}
	public T findMin() {
		T result = null;
		int currentIndex = 0;
		while ((currentIndex*2 + 2 <= maxIndex) && (tree[currentIndex*2 + 1] != null)) {
			currentIndex = currentIndex*2 + 1;
		}
		result = tree[currentIndex];
		return result;
	}
	
	public T findMax() {
		T result = null;
		int currentIndex = 0;
		while ((currentIndex*2 + 2 <= maxIndex) && (tree[currentIndex*2+2] != null) ) {
			currentIndex = currentIndex*2 +2;
		}
		result = tree[currentIndex];
		return result;
	}
	
	public T root() {
		// TODO Auto-generated method stub
		return tree[0];
	}
	
	public int size() {
		// TODO Auto-generated method stub
		return tree.length;
	}
	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return tree.length == 0;
	}


	public T parent(T p) {
		// TODO Auto-generated method stub
		int parentIndex = (int) p;
		if (parentIndex == 1) {
			return (T) Integer.valueOf(parentIndex);
		}
		return (T) Integer.valueOf(parentIndex/2);
	}

	public T left(T p) {
		// TODO Auto-generated method stub
		int left = (int) p;
		return (T) Integer.valueOf(left*2);
	}

	public T right(T p) {
		// TODO Auto-generated method stub
		int right = (int) p;
		return (T) Integer.valueOf(right*2 +1) ;
	}
	
	 public void writeFile(T value, int space, FileWriter write) throws IOException{
		if (value == null) {
			return;
		}
		space+=COUNT;
		writeFile(right(value), space, write);
		write.write(" ");
		for (int i = COUNT; i < space; i++) {
			write.write(" ");
		}
		write.write(value + "\n");
		
		writeFile(left(value), space, write);
	}
	 
	 public void writef (int space, FileWriter write) throws IOException {
		 writeFile(root(), space, write);
	 }

}
