package course2;

public class LastPosOfTarget {
	
	//accepted 1.21.2017 31707ms
	public int lastPosition(int[] nums, int target) {
        // Write your code here
		if(nums==null || nums.length<=0 || target < nums[0] || target > nums[nums.length-1]){return -1;}
		
		int start = 0, end = nums.length-1;
		while(start+1 < end){
			int mid = (end - start) / 2 + start;
			if(nums[mid] == target){
				start = mid;
			}else if(nums[mid] > target){
				end = mid;
			}else{
				start = mid;
			}
		}
		
		if(nums[end] == target){return end;}
		if(nums[start] == target){return start;}
		return -1;
    }
}
