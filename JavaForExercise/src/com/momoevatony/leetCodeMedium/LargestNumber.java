package com.momoevatony.leetCodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestNumber {
	public String largestNumber(int[] nums) {
		if(nums.length<=0){return "";}
		StringBuilder sb = new StringBuilder();
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		
		for(int i=0;i<nums.length;i++){
			int curr = nums[i];
			while(curr>10){
				curr=curr/10;
			}
			if(map.containsKey(curr)){
				List<Integer> tempList = map.get(curr);
				tempList.add(nums[i]);
				map.put(curr,tempList);
			}else{
				map.put(curr, Arrays.asList(nums[i]));
			}
		}
		for (int j=9;j>=0;j--){
			if(!map.containsKey(j)){continue;}
			List<Integer> list = map.get(j);
			Collections.sort(list);
			for(int k:list){
				sb.append(Integer.toString(k));
			}
		}
		return sb.toString();
    }
}
