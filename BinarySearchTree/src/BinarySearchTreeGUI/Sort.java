package BinarySearchTreeGUI;

public class Sort {
	public void Increase(int [] a) {
		int n = a.length;
		for(int i = 0; i < n; i++) {
			for(int j = 1; j < n - i; j++) {
				if(a[j - 1] > a[j]) {
					int temp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = temp;
				}
			}
		}
	}
	public void Decrease(int[] a){
		int n = a.length;
		for(int i = 0; i < n; i++) {
			for(int j = 1; j < n - i; j++) {
				if(a[j - 1] < a[j]) {
					int temp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = temp;
				}
			}
		}
		
    }
	public Sort() {
		
	}
	
  	
	
}
