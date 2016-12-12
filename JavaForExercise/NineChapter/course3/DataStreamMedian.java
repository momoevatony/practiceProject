package course3;

import java.util.PriorityQueue;

public class DataStreamMedian {
	
	
	//Accetped 12.10.2016 3852ms
	public int[] medianII(int[] nums) {
        // write your code here
		if(nums == null || nums.length<=0){return new int[0];}
		int[] result = new int[nums.length];
		PriorityQueue<MinNode> minHeap = new PriorityQueue<MinNode>();
		PriorityQueue<MaxNode> maxHeap = new PriorityQueue<MaxNode>();
		
		for(int i =0; i<nums.length;i++){
			if(minHeap.isEmpty()){minHeap.add(new MinNode(nums[i]));}
			else{
				if(nums[i]>=minHeap.peek().data){
					minHeap.add(new MinNode(nums[i]));
				}else{
					maxHeap.add(new MaxNode(nums[i]));
				}
			}
			while(minHeap.size()>maxHeap.size()+1){
				minToMax(minHeap,maxHeap);
			}
			while(maxHeap.size()>minHeap.size()+1){
				maxToMin(minHeap,maxHeap);
			}
			if(maxHeap.isEmpty()){result[i] = minHeap.peek().data;}
			else{
				if(minHeap.size() == maxHeap.size()){
					result[i] = maxHeap.peek().data;
				}else{
					result[i] = minHeap.size()>maxHeap.size()?minHeap.peek().data:maxHeap.peek().data;
				}
			}
		}
		
		return result;
    }
	private void maxToMin(PriorityQueue<MinNode> minHeap, PriorityQueue<MaxNode> maxHeap){
		if(maxHeap.isEmpty()){return;}
		MaxNode node = maxHeap.poll();
		minHeap.add(new MinNode(node.data));
	} 
	private void minToMax(PriorityQueue<MinNode> minHeap, PriorityQueue<MaxNode> maxHeap){
		if(minHeap.isEmpty()){return;}
		MinNode node = minHeap.poll();
		maxHeap.add(new MaxNode(node.data));
	}
	
	private class MinNode implements Comparable<MinNode>{
		int data;
		public MinNode(int data){
			this.data = data;
		}
		
		public int compareTo(MinNode node){
			if(this.data<node.data){return -1;}
			if(this.data>node.data){return 1;}
			return 0;
		}
	}
	
	private class MaxNode implements Comparable<MaxNode>{
		int data;
		public MaxNode(int data){
			this.data = data;
		}
		
		public int compareTo(MaxNode node){
			if(this.data>node.data){return -1;}
			if(this.data<node.data){return 1;}
			return 0;
		}
	}
}
