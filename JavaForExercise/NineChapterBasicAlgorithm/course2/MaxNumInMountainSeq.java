package course2;

public class MaxNumInMountainSeq {
	
	//accepted 3.8.2017 14909ms
	public int mountainSequence(int[] nums) {
        // Write your code here
		if(nums.length==1){return nums[0];}
		if(nums.length==2){return nums[0]>nums[1]?nums[0]:nums[1];}
		
		if(nums[0]>nums[1]){return nums[0];}
		if(nums[nums.length-1]>nums[nums.length-2]){return nums[nums.length-1];}
		int start = 0;
		int end = nums.length-1;
		
		while(start + 1 < end){
			int mid = (end - start) / 2 + start;
			
			if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
				return nums[mid];
			}else if (nums[mid]>nums[mid-1] && nums[mid] < nums[mid+1]){
				start = mid;
			}else{
				end = mid;
			}
		}
		if(start>0 && nums[start]>nums[start-1] && nums[start]>nums[start+1]){
			return nums[start];
		}else{
			return nums[end];
		}
    }
}
