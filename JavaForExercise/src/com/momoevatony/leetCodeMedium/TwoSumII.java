package com.momoevatony.leetCodeMedium;

import java.util.HashMap;
import java.util.Map;

public class TwoSumII {
	
	//Accetped 10.27.2016
	public int[] twoSum(int[] numbers, int target) {
		if(numbers.length<=0){return new int[]{};}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i=0; i<numbers.length; i++){
			map.put(target-numbers[i], i);
		}
		for (int j=0; j<numbers.length; j++){
			if(map.containsKey(numbers[j])){
				return new int[]{ map.get(numbers[j])>j?j+1:map.get(numbers[j])+1, map.get(numbers[j])>j ?map.get(numbers[j])+1:j+1 };
			}
		}
		return new int[]{};
    }
}
