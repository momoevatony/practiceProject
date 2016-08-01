package com.momoevatony.leetCodeMedium;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class NextPermutation {
	public static void main(String args[]){
		int nums[] = {1,2,3,5,4,2,1};
		nextPermutation(nums);
	}
	
	//Accepted 7.31.2016
	public static void nextPermutation(int[] nums) {
		if (nums.length<=1){return;}
        System.out.println(Arrays.toString(nums));
        List<Integer> list = new ArrayList<Integer>();
        int startIndex = nums.length-1;
        while(startIndex>=0){
        	System.out.println("working on index: "+startIndex+" number: "+nums[startIndex]);
        	if(startIndex==0){list.add(nums[startIndex]);break;}
        	list.add(nums[startIndex]);
        	if(nums[startIndex]>nums[startIndex-1]){
        		break;
        	}
        	startIndex--;
        }
        int switchIndex = startIndex-1;
        int listIndex1 = 0;
        if(startIndex!=0){
        	while(listIndex1<list.size()){
        		if(list.get(listIndex1)>nums[switchIndex]){int temp = nums[switchIndex];nums[switchIndex] = list.get(listIndex1);list.set(listIndex1,temp);break;}
        		listIndex1++;
        	}
        }
        System.out.println(Arrays.toString(list.toArray()));
        int listIndex = 0;
        while(startIndex<nums.length && listIndex<list.size()){
        	nums[startIndex] = list.get(listIndex);
        	startIndex++;listIndex++;
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(list.toArray()));
    }
}
