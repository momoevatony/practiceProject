package course2;

public class FirstPosOfTarget {
	
	//accepted 1.21.2017 1963ms
	public int binarySearch(int[] nums, int target) {
        //write your code here
		if(nums.length<=0 || nums == null || target < nums[0] || target > nums[nums.length-1]){return -1;}
		
		int start = 0, end = nums.length-1;
		while(start+1<end){
			int mid = (end-start) /2 + start;
			if(nums[mid] == target){
				end = mid;
			}else if(nums[mid] > target){
				end = mid;
			}else{
				start = mid;
			}
		}
		if(nums[start] == target){return start;}
		if(nums[end] == target){return end;}
		
		return -1;
    }
}
