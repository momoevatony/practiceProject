package course5;

import java.util.Arrays;

public class RemoveDuplicatesInArray {
	
	//Accepted 3.9.2017 9333ms
	public int deduplication(int[] nums) {
        // Write your code here
		if(nums.length <= 1){return nums.length;}
		Arrays.sort(nums);
		int slow = 0;
		
		for(int i=1; i<nums.length; i++){
			if(nums[i] != nums[slow]){
				nums[++slow] = nums[i];
			}
		}
		
		return slow+1;
    }
}
