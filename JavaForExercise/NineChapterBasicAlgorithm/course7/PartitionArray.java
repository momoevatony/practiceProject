package course7;

import java.util.Arrays;

public class PartitionArray {
	
	//Accepted 5.2.2017 1694ms
	public int partitionArray(int[] nums, int k) {
	    //write your code here
	    if (nums == null || nums.length == 0) {
	        return 0;
	    }
	    
	    Arrays.sort(nums);
	    
	    int left = 0;
	    int right = nums.length - 1;
	    
	    while (left < right) {
	        while (left < right && nums[left] < k) {
	            left++;
	        }
	        while (left < right && nums[right] >= k) {
	            right--;
	        }
	        if (left < right) {
	            int temp = nums[left];
	            nums[left] = nums[right];
	            nums[right] = temp;
	            left++;
	            right--;
	        }
	    }
	    if (nums[left] < k) {
	        return left + 1;
	    } else {
	        return left;
	    }
    }
}
