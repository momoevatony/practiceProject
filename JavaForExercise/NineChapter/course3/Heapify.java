package course3;

public class Heapify {
	
	//Accepted 12.7.2016 
	public void heapify(int[] A){
		if(A==null || A.length<=0){return;}
		for(int i=0;i<A.length;i++){
			siftUp(A,i);
		}
	}
	
	private void siftDown(int[]A, int index){
		int left = getLeft(index);
		int right = getRight(index);
		int min = index;
		if(left >= A.length){return;}
		if(right>=A.length){
			min = A[index] < A[left] ? index:left;
		}else{
			min = A[index] < A[A[left]<A[right]?left:right] ? index: (A[left]<A[right]?left:right);
		}
		if(min!=index){
			swap(A, min, index);
			siftDown(A,min);
		}
	}
	
	private void siftUp(int[]A, int index){
		int parent = getParent(index);
		if(parent <0){return;}
		if(A[parent]>A[index]){
			swap(A, parent, index);
			siftUp(A,parent);
		}
	}
	
	private void swap(int[] A, int a, int b){
		int temp = A[a];
		A[a]=A[b];
		A[b]=temp;
	}
	
	private int getParent (int index){
		return (index-1)>>1;
	}
	private int getLeft (int index){
		return (index<<1)+1;
	}
	private int getRight (int index){
		return (index<<1)+1;
	}
}
