package com.momoevatony.leetCodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	
	public static void main (String args[]){
		int[] nums = {1,2};
		List<List<Integer>> list = subsets(nums);
		for(List<Integer>innerList:list){
			System.out.println(Arrays.toString(innerList.toArray()));
		}
		//System.out.println(Arrays.toString(nums));
		//System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, nums.length-1)));
		
	}
	
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (nums.length<=0){return list;}
		if (nums.length == 1) {list.add(Arrays.asList(nums[0])); return list;}
        
		return addOneElement( subsets(Arrays.copyOfRange(nums, 0, nums.length-1)), nums[nums.length-1]);
    }

	public static List<List<Integer>> addOneElement(List<List<Integer>> list, int n){
		System.out.println("called n: "+n+" list length: "+list.size());
		List<List<Integer>> newList = new ArrayList<List<Integer>>(list);
		int index = 0;
		while (index<list.size()){
			List<Integer> innerList = new ArrayList<Integer>(list.get(index));
			innerList.add(n);
			newList.add(innerList);
			index++;
		}
		return newList;
	}
}
