package course1;

import java.util.Arrays;

public class TwoSum2 {
	
	//Accepted 11/21/2016 4206 ms
	public int twoSum2(int[] nums, int target) {
        // Write your code here
		Arrays.sort(nums);
		int result = 0;
		int left = 0; int right = nums.length-1;
		while(left<right){
			int sum = nums[left]+nums[right];
			if(sum>target){
				result+= right-left;
				right--;
			}else{
				left++;
			}
		}
		
		return result;
    }
}
