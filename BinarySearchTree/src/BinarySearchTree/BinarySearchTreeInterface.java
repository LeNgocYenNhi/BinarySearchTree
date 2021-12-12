package BinarySearchTree;

public interface BinarySearchTreeInterface<T> extends Iterable<T> {
	T root();
	int size();
	boolean isEmpty();
	
	public void find(T value);
	public void insert(T value);
	public void delete(T value);
	public T Min();
	public T Max();
	
	T parent(T p);		//return parent of p
	T left(T p);		//return left child of p
	T right(T p);		//return right child of p
	


}