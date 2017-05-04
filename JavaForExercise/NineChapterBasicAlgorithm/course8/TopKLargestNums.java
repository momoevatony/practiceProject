package course8;

import java.util.PriorityQueue;

public class TopKLargestNums {
	
	//Accepted 5.3.2017 1082ms
	public int[] topk(int[] nums, int k) {
        // Write your code here
        if (nums == null || nums.length < k) {
            return new int[0];
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        
        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = heap.poll();
        }
        
        return ans;
    }
}
