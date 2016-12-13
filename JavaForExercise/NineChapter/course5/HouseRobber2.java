package course5;

public class HouseRobber2 {
	
	//Accepted 12.12.2016 2457ms
	public int houseRobber2(int[] nums) {
        // write your code here
		if(nums.length==0){return 0;}
		if(nums.length==1){return nums[0];}
		
        return Math.max(calMax(nums,0,nums.length-2), calMax(nums, 1, nums.length-1));
    }
	
	private int calMax(int[] nums, int start, int end){
		if(start==end){return nums[start];}
		if(start==end-1){return Math.max(nums[start], nums[end]);}
		
		int[]map = new int[2];
		map[start%2] = nums[start];
		map[(start+1)%2] = Math.max(nums[start],nums[start+1]);
		for(int i=start+2;i<=end;i++){
			map[i%2] = Math.max(map[(i-1)%2],map[(i-2)%2]+nums[i]);
		}
		return map[end%2];
	}
}
