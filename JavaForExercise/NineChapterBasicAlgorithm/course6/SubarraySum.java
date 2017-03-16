package course6;

import java.util.ArrayList;
import java.util.HashMap;

public class SubarraySum {
	
	//accepted 3.15.2017 4443ms
	public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
		ArrayList<Integer> list = new ArrayList<>();
		if(nums == null || nums.length <= 0) {return list;}
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] preSum = new int[nums.length+1];
		preSum[0] = 0;
		map.put(0, -1);
		for(int i = 0; i < nums.length; i++) {
			preSum[i + 1] = preSum[i] + nums[i];
			if(map.containsKey(preSum[i + 1])) {
				list.add(map.get(preSum[i + 1]) + 1);
				list.add(i);
				return list;
			}else {
				map.put(preSum[i + 1], i);
			}
		}
		return list;
    }
}
