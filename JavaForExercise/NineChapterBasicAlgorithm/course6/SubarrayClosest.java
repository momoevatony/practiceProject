package course6;

import java.util.Arrays;
import java.util.HashMap;

public class SubarrayClosest {
	
	//accepted 3.15.2017 5262ms
	public int[] subarraySumClosest(int[] nums) {
        // write your code here
		int[] result = new int[2];
		int min = Integer.MAX_VALUE;
		int[] preSum = new int [nums.length + 1];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		preSum[0] = 0;
		map.put(0, -1);
		
		
		for(int i = 0; i < nums.length; i++) {
			preSum[i + 1] = preSum[i] + nums[i];
			if(map.containsKey(preSum[i + 1])) {
				return new int[] {map.get(preSum[i+1]) + 1, i};
			}else {
				map.put(preSum[i + 1], i);
			}
		}
		
		Arrays.sort(preSum);
		for(int i = 0; i < preSum.length - 1; i++) {
			if(preSum[i + 1] - preSum[i] < min) {
				min = preSum[i + 1] - preSum[i];
				if(map.get(preSum[i + 1]) > map.get(preSum[i])) {
					result[0] = map.get(preSum[i]) + 1;
					result[1] = map.get(preSum[i + 1]);
				}else {
					result[0] = map.get(preSum[i + 1]) + 1;
					result[1] = map.get(preSum[i]);
				}
			}
		}
		
		Arrays.sort(result);
		
		return result;
    }
}
