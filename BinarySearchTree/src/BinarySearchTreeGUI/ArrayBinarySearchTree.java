package BinarySearchTreeGUI;

public class ArrayBinarySearchTree {
	Node [] BST;
	int n = 0;
	int defaultsize = 1000;
	int lastIndex = -1;
	//size ve do lon vong tron cua 1 node
    public final int size = 30;
    public ArrayBinarySearchTree() {
    	BST = (Node[]) new Comparable[defaultsize];
		n = 0;
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
            return;
        }
        
        if(BST[Index].getValue() == 0 ) {
            n += 1;
            BST[Index].setValue(Value);
            if(Index != 1) {
            	  lastIndex = Index;
            }
            return;
        }
        //Chuyen sang cay con phai
        if(BST[Index].getValue() < Value){    	
            insertNode(right(Index) , Value);
        }
        //Chuyen sang cay con trai
        else if(BST[Index].getValue() > Value){
            insertNode(left(Index) , Value);
        }
        else if(BST[Index].getValue() == Value){
            return;
        }
    
    }

}
