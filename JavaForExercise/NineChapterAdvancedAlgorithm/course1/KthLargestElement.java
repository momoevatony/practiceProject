package course1;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement {
	
	//Accepted 11/21/2016  1174 ms
	public int kthLargestElement(int k, int[] nums) {
        // write your code here
		Queue<Integer> pq = new PriorityQueue<Integer>();
		for(int i:nums){
			pq.add(i);
			if(pq.size()>k){pq.poll();}
		}
		return pq.peek();
    }
}
