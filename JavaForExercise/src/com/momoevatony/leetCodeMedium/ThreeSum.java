package com.momoevatony.leetCodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {
	
	public static void main (String args[]){
		int[] input = {-11,-7,-4,-1,0,3,4,8,10};
		List<List<Integer>> list = threeSum (input);
		for (List<Integer> innerList : list){
			System.out.print(Arrays.toString(innerList.toArray()));
		}
	}
	
	static List<List<Integer>> threeSum(int[] nums) {
		if(nums.length<3){return null;}
        List<Integer> innerList = new ArrayList<Integer>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        Arrays.sort(nums);
        for (int i=0; i<nums.length-2;i++){
        	while(nums[i] == nums[i+1]){i++;}
        	int j=i+1;
        	int k=nums.length-1;
        	while(j<k){
        		while(nums[j] == nums[j+1]){j++;}
    			while(k<nums.length-1 && nums[k] == nums[k+1]){k--;}
        		if(nums[i]+nums[j]+nums[k] > 0){k--;}
        		else if(nums[i]+nums[j]+nums[k] <0){j++;}
        		else {
        			list.add(Arrays.asList(nums[i],nums[j],nums[k]));
        			j++;k--;
        		}
        	}
        	
        }
        
        return list;
    }
	
	
	//Easy way
	static List<List<Integer>> threeSum2(int[] nums){
        List<Integer> innerList = new ArrayList<Integer>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
		
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
        	while(nums[i] == nums[i+1]){i++;}
        	for (int j=i+1;j<nums.length-1;j++){
        		while(nums[j] == nums[j+1]){j++;}
        		for(int k=j+1; k<nums.length;k++){
        			while(k<nums.length-1 && nums[k] == nums[k+1]){k++;}
        			if(nums[i]+nums[j]+nums[k] == 0){innerList.add(nums[i]);innerList.add(nums[j]);innerList.add(nums[k]);list.add(innerList);}
        		}
        	}
        }
        
        return list;
	}

}
