package course3;
import java.util.ArrayList;
import java.util.Arrays;

public class SlidingWindowMedian {
	public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(nums.length<k || k<=0){return list;}
		MinHeap minHeap = new MinHeap();
		MaxHeap maxHeap = new MaxHeap();
		int index = 0;
		for(index=0; index<k-1;index++){
			minHeap.insert(nums[index]);
		}
		maintain(minHeap, maxHeap);
		while(index<nums.length){
			
			
			index++;
		}
		return list;
    }
	
	private void maintain(MinHeap minHeap, MaxHeap maxHeap){
		while(minHeap.size-maxHeap.size>1){
			maxHeap.insert(minHeap.poll());
		}
		while(maxHeap.size-minHeap.size>1){
			minHeap.insert(maxHeap.poll());
		}
	}
	
	private class MinHeap{
		int data[];
		int size;
		
		public MinHeap(int[] data){
			this.size = data.length;
			this.data = data;
			this.build();
		}
		
		public MinHeap(){
			this.size = 0;
			this.data = new int[0];
		}
		
		public void insert(int number){
			int[] newData = new int[data.length+1];
			System.arraycopy(data, 0, newData, 0, size);
			newData[size] = number;
			this.data = newData;
			this.size++;
			siftUp(this.size-1);
		}
		
		public int poll(){
			int result = data[0];
			data[0] = data[data.length-1];
			int[] newData = new int[data.length-1];
			System.arraycopy(data, 0, newData, 0, size-1);
			this.data = newData;
			this.size = size-1;
			siftDown(0);
			return result;
		}
		
		public int peak(){
			return data[0];
		}
		
		
		private void build(){
			for(int i=0;i<data.length;i++){
				siftUp(i);
			}
		}
		
		private void siftUp(int index){
			if(index == 0){return;}
			int parent = getParent(index);
			if(data[parent]>data[index]){
				swap(parent, index);
				siftUp(parent);
			}
		}
		
		private void siftDown(int index){
			int left = getLeft(index);
			int right = getRight(index);
			int min = index;
			if(left>=data.length){return;}
			if(right>=data.length){
				min = data[index]<data[left]?index:left;
			}else{
				min = data[index]<data[data[left]<data[right]?left:right]?index:(data[left]<data[right]?left:right);
			}
			if(min!=index){
				swap(index,min);
				siftDown(min);
			}
		}
		
		private void swap(int a, int b){
			int temp = data[a];
			data[a] = data[b];
			data[b] = temp;
		}
		
		private int getParent(int index){
			return (index-1)>>1;
		}
		
		private int getLeft(int index){
			return (index<<1)+1;
		}
		
		private int getRight(int index){
			return (index<<1)+1;
		}
		
	}
	
	private class MaxHeap{
		int data[];
		int size;
		
		public MaxHeap(int[] data){
			this.size = data.length;
			this.data = data;
			this.build();
		}
		
		public MaxHeap(){
			this.size = 0;
			this.data = new int[0];
		}
		
		public void insert(int number){
			int[] newData = new int[data.length+1];
			System.arraycopy(data, 0, newData, 0, size);
			newData[size] = number;
			this.data = newData;
			this.size++;
			siftUp(this.size-1);
		}
		
		public int poll(){
			int result = data[0];
			data[0] = data[data.length-1];
			int[] newData = new int[data.length-1];
			System.arraycopy(data, 0, newData, 0, size-1);
			this.data = newData;
			this.size = size-1;
			siftDown(0);
			return result;
		}
		

		public int peak(){
			return data[0];
		}
		
		private void build(){
			for(int i=0;i<data.length;i++){
				siftUp(i);
			}
		}
		
		private void siftUp(int index){
			if(index == 0){return;}
			int parent = getParent(index);
			if(data[parent]<data[index]){
				swap(parent, index);
				siftUp(parent);
			}
		}
		
		private void siftDown(int index){
			int left = getLeft(index);
			int right = getRight(index);
			int min = index;
			if(left>=data.length){return;}
			if(right>=data.length){
				min = data[index]>data[left]?index:left;
			}else{
				min = data[index]>data[data[left]>data[right]?left:right]?index:(data[left]>data[right]?left:right);
			}
			if(min!=index){
				swap(index,min);
				siftDown(min);
			}
		}
		
		private void swap(int a, int b){
			int temp = data[a];
			data[a] = data[b];
			data[b] = temp;
		}
		
		private int getParent(int index){
			return (index-1)>>1;
		}
		
		private int getLeft(int index){
			return (index<<1)+1;
		}
		
		private int getRight(int index){
			return (index<<1)+1;
		}
	}
}
