package BinarySearchTree;

import java.util.Iterator;

public class ArrayBinarySearchTree<T extends Comparable<T>> implements BinarySearchTreeInterface<T> {
	T[] tree;
	int n = 0;
	int defaultsize = 1000;
	int lastIndex = -1;
	String file = "";
	
	public ArrayBinarySearchTree()  {
		tree = (T[]) new Comparable[defaultsize];
		n = 0;
	}
	
	public ArrayBinarySearchTree(int newSize) {
		tree = (T[]) new Comparable[newSize];
		this.defaultsize = newSize;
		n = 0;
	}
	// Set element to root of an empty tree (at index 1)
	public void setRoot(T Value) {
		if(n == 0) {
			n += 1;
		}
		tree[1] = Value;
	}
	
	// Set left child of p (at index 2p)
	public void setLeft(int p, T Value) {
		int leftIndex = 2 * p;
		//Array is full
		if(leftIndex >= defaultsize) {
			return;
		}
		//Root p is null
		if(tree[p] == null) {
				return;
		}else {
			if(tree[leftIndex] == null) {
					n += 1;
				}
				tree[leftIndex] = Value;
			}	
		}
		
	// Set right child of p (at index 2p+1)
	public void setRight(int p, T Value) {
		int rightIndex = 2 * p + 1;
		//Array is full
		if(rightIndex >= defaultsize) {
			return;
		}
		//Root p is null
		if(tree[p] == null) {
			return;
		}else {
			if(tree[rightIndex] == null) {
					n += 1;
			}
			tree[rightIndex] = Value;
		}
	}
	/*
	 *p is index of node
	 *Return index sibling of p
	 */
	public T sibling(T p) {
		int index = (int) p;
		
		//_Index is not valid
		if(index < 1 || index >= defaultsize) {
			return null;
		}
		//p is index of Right Node, sibling of p is Left Node 
		if(index % 2 == 1) {
			if(tree[index - 1] != null) {
				return (T) Integer.valueOf(index - 1);
			}
		}
		//p is index of Left Node, sibling of p is Right Node
		if(index % 2 == 0) {
			if(index + 1 < defaultsize && tree[index + 1] != null) {
					return (T) Integer.valueOf(index + 1);
				}
			}
		return null;
	}
	
	/*
	 * Return value of Node T (index in array is p)
	 */
	public T getValue(int index) {
		if(index > defaultsize || tree[index] == null) {
			return null;
		}
		return tree[index];
	}
		
	
	public void insert(int index, T Value) {
		if(index == 1 && tree[index] == null) {
			n += 1;
			tree[index] = Value;
			return;
		}
		if(tree[index] == null) {
			n += 1;
			tree[index] = Value;
			if(index != 1) {
				lastIndex = index;
			}
			return;
		}//de quy sang cay con phai
		if(Value.compareTo(tree[index]) > 0) {
			insert(right(index), Value);
		//de quy sang cay con trai
		}else if(Value.compareTo(tree[index]) < 0) {
			insert(left(index), Value);
		}else {
			return;
		}
		
	}
	/*
	public void deleteNode(int index ,T Value) {
		if(getValue(index) == null) {
			return;
		}
		//step1
		//gia tri xoa lon hon gia tri cua node i => xet cay con phai
		if(Value.compareTo(getValue(index)) > 0) {
			deleteNode(right(index), Value);
		}else if(Value.compareTo(getValue(index)) < 0){ //Neu gia tri xoa be hon gia tri cua node i => xet cay con trai
			deleteNode(left(index), Value);
		}
		//step 3
		// nut xet bang gia tri can xoa
		else {
			n -= 1;
			if(getValue(left(index)) == null && getValue(right(index)) == null) {
				tree[index] = null;
			}else {
				//TH2: Nut co con
				String insertAgain;
				int current = left(index);
				// Neu node xoa chi co con phai
				if(getValue(left(index)) == null && getValue(right(index)) != null){
					insertAgain = bfsPath(right(index));
				}
				//Neu node xoa chi co con trai
				else if(getValue(left(index)) != null && getValue(right(index)) == null ) {
					insertAgain = bfsPath(left(index));
				}else {
					//Neu node xoa co du hai con trai va phai
					//Tim nut co gia tri lon nhat cua cay con trai (nut cuoi cung ben phai)
					while(getValue(right(current)) != null) {
						//nut duoc duyet bao mau cam
						current = right(current);
					}

					//gan lai gia tri cho nut moi
					tree[index] = tree[current];
					lastIndex = -1;
					
					if(getValue(left(current)) != null)
						insertAgain = bfsPath(left(current));
					else
						insertAgain ="";
				}
				Scanner scan = new Scanner(insertAgain);
				if((getValue(left(index)) == null && getValue(right(index)) != null|| 
						(getValue(left(index))  != null && getValue(right(index)) == null))) {
					deleteTree(index);
				}
				else {
					deleteTree(current);
				}
				
			}
		}
	}
	public void deleteTree(int i){
		Queue<Integer> nextNode = new LinkedList<>();
		nextNode.add(i);
		while(!nextNode.isEmpty()){
			if(getValue(left(nextNode.peek())) != null) {
				nextNode.add(left(nextNode.peek()));
			}
		    if(getValue(right(nextNode.peek())) != null ) {
		    	nextNode.add(right(nextNode.peek()));
		    }
		    tree[nextNode.peek()] = null;
		    nextNode.remove(nextNode.peek());
		}
		        
	}
	public String bfsPath(int i) {
		String s ="";
		Queue<Integer> queue = new LinkedList<>();
		queue.add(i);
		while(!queue.isEmpty()) {
			n += 1;
			s += getValue(queue.peek()) +" ";
			if(getValue(left(queue.peek())) != null) {
				queue.add(left(queue.peek()));
			}
			if(getValue(right(queue.peek())) != null) {
				queue.add(right(queue.peek()));
			}
			queue.remove(queue.peek());
		}
		return s;
	}
*/
	public int[] findDelete(T value) {
		int[] indices = new int[2];
		boolean found = false;
		int c = 1; // Child
		int p = 1; // Parent
		while (c < tree.length && tree[c] != null) { //ket thuc khi duyet het mang hoac tim thay vale
			if (value.compareTo(tree[c]) < 0) { //du lieu duoc tim kiem nho hon du lieu co trong mang
				p = c;
				//di chuyen sang phia ben trai cua cay
				c = (2 * c); 
			}else if (value.compareTo(tree[c]) > 0) {
				p = c;
				// di chuyen sang phia ben phai cua cay
				c = (2 * c) + 1; 
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
	
	public void deleteNoChlid(int child_index) {
		tree[child_index] = null;
	}
	
	public void delOneChild(int child_index, int left, int right) {
		if (tree[right] == null) { // một con ở bên trái
			//Vị trí sẽ bị xóa được thay thế bằng nút bên trái ngay lập tức
			tree[child_index] = tree[left]; 
			//Một biến được sử dụng để lưu trữ phía bên phải của nút bên trái ngay lập tức
			int right_temp = (2*left) + 1;
			//Một biến được sử dụng để lưu trữ phía bên trai của nút bên trái ngay lập tức
			int left_temp = (2*left) ;
			while (right_temp < tree.length && left_temp < tree.length) { // vong lap cho toi khi het cay
				// di chuyen len mot bac o phia ben trai
				tree[left] = tree[left_temp]; 
				// cap nhat lai con tro
				left = left_temp;
				// d chuyen len mot bac o phia ben phai
				tree[right] = tree[right_temp];
				right = right_temp;
				
				//cap nhat nut ngoai cung cua ben phai
				right_temp = (2 * right) + 1;
				// cap nhat lai nut ngoai cung ben trai
				left_temp = (2 * left);
			}
			
			// dat cac nut cuoi cung la null vi tat ca cac nut truoc do da tang len mot bac
			tree[left] = null;
			tree[right] = null;
		}
		 else if (tree[left] == null) { //Mot not con ben phai
	            tree[child_index] = tree[right]; //Vi tri se bi xoa ngay lap tuc duoc thay the bang nut con ben phai
	            int right_temp = (2 * right) + 1; // Bien duoc dung de luu tru phia ben phai cua nut ben phai
	            int left_temp = (2 * right) ; //Bien duoc dung de luu tru phia ben trai cua nut ben phai
	            while (right_temp < tree.length && left_temp < tree.length) { //duyen toi khi het cay
	                tree[left] = tree[left_temp]; //di chuyen len mot bac o phia ben trai
	                left = left_temp; // cap nhat 1 con tro cho phia ben trai
	                tree[right] = tree[right_temp]; //Di chuyen len mot bac o phia ben phai
	                right = right_temp; //cap nhat 1 con tro cho phia ben phai

	                right_temp = (2 * right) + 1; //Cap nhat nut ngoai cung ben phai cua ben phai 
	                left_temp = (2 * left) ; //Cap nhat nut ngoai cung ben trai cua ben trai
	            }
	            //Dat tat ca cac nut cuoi cun la null vi cac nut truoc cua no da tang len mot bac
	            tree[left] = null;
	            tree[right] = null;
	        }
	}
	
	public void delete(T value) {
		if (findDelete(value) == null) {
			System.out.printf("\nKhong tim thay value, khong the xoa. \nDanh sach khong doi\n");
			int temp = n;
			n = -1;
			for (int i = 1; i <= temp; i++) {
				if (tree[i] != null) {
					n = i;
				}
			}
			int height = height(1);
			return;
		}else {
			int[] ref = findDelete(value);
			int c = ref[1];
			int right = (2*c) + 1;
			int left = (2 * c);
			System.out.printf("\nDeleting " + tree[c] + "\n");
			// TH khong con
			if ((right > tree.length || left > tree.length) || (tree[left] == null && tree[right] == null)) {
				deleteNoChlid(c);
			}// TH 1 con
			else if ((tree[right] == null && tree[left] != null) || (tree[right] != null && tree[left] == null)) {
				delOneChild(c, left, right);
			}else { // TH 2 con
				// dich chuyen sang ben phai cua nut se bi xoa
				int temp = right; 
				int temp2 = 0;
				while (tree[temp] != null) { // Cho toi khi ben phai rong
					temp2 = temp; // Vi tam thoi null se o cuoi vong lap, su dung mot bien de luu tru gia tri truoc do
					temp = (2 * temp);
				}
				// gia tri cua temp2 duoc sao chep tai nut se bi xoa
				tree[c] = tree[temp2]; 
				c = temp2; // cap nhat con de thuc hien xoa no chlid
				//phai va trai dc cap nhat de thuc hien xoa temp2
				right = (2* c) + 1;
				left = (2 * c);
				if ((right > tree.length || left > tree.length) || (tree[left] == null && tree[right] == null))  {
					deleteNoChlid(c);
				}else if ((tree[right] == null && tree[left] != null) || (tree[right] != null && tree[left] == null)) {
					delOneChild(c, left, right);
				}
			}
		}
	}

	public void find(T value) {
		int i = 1;// bo dem duyet mang
		boolean found = false;
		while (i < tree.length) { // ket thuc khi duyet het mang hoac tim thay value
			if (value.compareTo(tree[i]) < 0) { // du lieu duoc tim kiem nho hon du lieu co trong mang
				// dich chuyen sang ben trai cua cay
				i = (2 * i) ; 
			}else if (value.compareTo(tree[i]) > 0) {
				//dich chuyen sang ben phai cua cay
				i = (2 * i) + 1;
			}else { // value giong voi tree[i]
				found = true;
				break;
			}
		}
		 //value duoc tim thay
		if (found) {
			System.out.println(value + " found at " + i + ".");
		// value khong duoc tim thay	
		}else {
			System.out.println(value + " not found.");
		}
	}
	


	public int height(int i) {
		if(tree[i] == null) {
			return 0;
		}
        
        return Math.max(height(left(i)) , height(right(i))) + 1;
		
	}
	
	public void Preorder(int i) {
		if (i < tree.length && tree[i] != null) {
			System.out.print(tree[i] + " ");
			Preorder(2 * i);
			Preorder(2 * i + 1);
		}
	}
	public void Inorder(int i) {
		if(i < tree.length && tree[i] != null) {
			Inorder(2 * i);
			System.out.print(tree[i] + " ");
			Inorder(2 * i + 1);
		}
	}
	
	public void Postorder(int i) {
		if (i < tree.length && tree[i] != null) {
			Postorder(2 * i);
			Postorder(2 * i + 1);
			System.out.print(tree[i] + " ");
		}
	}
		
	public T findMin(int index) {
		if(tree[index] == null) {
  			return null;
  		}

  		else {
  			while(tree[left(index)] != null) {
  				index = left(index);
  			}
  		}
  		return tree[index];
	}
	
	public T findMax(int index) {
		if(tree[index] == null) {
  			return null; 
  		}
  		else {
  			while(tree[right(index)] != null) {
  				index = right(index);
  			}
  		}
  		return tree[index];
		
	}

	public T root() {
		return tree[1];
	}

	public int size() {
		return n;
	}

	public boolean isEmpty() {
		if(n == 0) {
			return true;
		}
		return false;
	}

	/*
	 * p is index of child (Left Child or Right Child)
	 * Return index of Parent
	 */
	public T parent(T p) {
		int index = (int) p;
		if(index < 1) {
			return null;
		}
		return (T) Integer.valueOf(index / 2);
	}
	/*
	 *p is index of node parent
	 *Return index left child of p: 2 * p
	 */
	@Override
	public T left(T p) {
		int parentIndex = (int) p;
		if(parentIndex < 1 || parentIndex >= defaultsize)
			return null;
		int leftIndex = 2 * parentIndex;	
		return (T) Integer.valueOf(leftIndex);
	
	}
	public int left(int p) {
		if(p < 1 || p > defaultsize) {
			return -1;
		}
		return 2 * p;
	}
	/*
	 *p is index of node parent
	 *Return index right child of p in array
	 */
	@Override
	public T right(T p) {
		int parentIndex = (int) p;
		int rightIndex = 2 * parentIndex + 1;
		if(parentIndex < 1 || parentIndex > defaultsize)
			return null;
		
		return (T) Integer.valueOf(rightIndex);
		
	}
	public int right(int p) {
		if(p < 1 || p > defaultsize) {
			return -1;
		}
		return 2 * p + 1;
	}
	
	
	 public Iterator<T> iterator() {
		return null;
	}

	@Override
	public T Min() {
		return findMin(1);
	}

	@Override
	public T Max() {
		return findMax(1);
	}

	@Override
	public void insert(T value) {
		insert(1, value);
		
	}
	/*
	public void printText(T p, int level) {
		if(p == null) {
			return;
		}
		printText(right(p), level + 1);
		for(int i=0; i < level; i++) {
			file += "\t";
		}
		file += getValue(p)+"\n";
		printText(left(p), level + 1);
	}
	*/
	/*
	 *Print tree in file txt
	 *Change path
	 */
	
	/*public void printFile() throws IOException{
		file ="";
		String path = "/C://Users//Asus//eclipse-workspace//OOP//src//hw5_19000283//TestArray.txt";
		printText(root(),0);
		FileWriter writer = new FileWriter(path);
		writer.write(file);
		writer.close();
	}
	*/

	
	
	
}
