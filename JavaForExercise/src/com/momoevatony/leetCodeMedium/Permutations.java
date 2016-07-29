package com.momoevatony.leetCodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
	
	public static void main(String args[]){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(Arrays.asList(0));
		System.out.println(list.size());
	}
	
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(nums.length<=0){return list;}
        
        return list;
    }
	
	public static void permuteDP (int[] nums, int index, List<List<Integer>> list){
		if(list.size()==0){list.add(Arrays.asList(nums[index]));}
		else{
			for(int i=0; i<list.size();i++){
				List<Integer> innerList = list.get(i);
				
			}
		}
	}

}
