package course4;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
	
	//Accepted 12.11.2016 2053ms
	public int[] twoSum(int[] numbers, int target) {
        // write your code here
		if(numbers.length<=1){return new int[2];}
		HashMap <Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<numbers.length;i++){
			map.put(target-numbers[i], i+1);
		}
		for(int i=0;i<numbers.length;i++){
			if(map.containsKey(numbers[i])){
				return new int[]{i+1,map.get(numbers[i])};
			}
		}
		
		return new int[2];
    }
}
