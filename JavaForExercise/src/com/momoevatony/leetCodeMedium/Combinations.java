package com.momoevatony.leetCodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {
	
	public static void main(String args[]){
		List<List<Integer>> list = combine(3,2);
		for(List<Integer> innerList : list){
			System.out.print(Arrays.toString(innerList.toArray()));
		}
	}
	
	//Accepted on 7.24.2016
	
	static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(n == k){return nEqualk(n,k);}
		if(k==1){
			for(int i =1;i<=n;i++){list.add(Arrays.asList(i));}
			return list;
		}
		
		List<List<Integer>> list1 = combine(n-1,k);
		List<List<Integer>> list2 = addToList(combine(n-1,k-1), n);
		list.addAll(list1);
		list.addAll(list2);
		
		return list;
    }
	
	static List<List<Integer>> nEqualk (int n, int k){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> innerList = new ArrayList<Integer>();
		if(n!=k) {return null;}
		
		for(int i=1;i<=n;i++){innerList.add(i);}
		list.add(innerList);
		return list;
	}
	
	static List<List<Integer>> addToList (List<List<Integer>> list, int n){
		List<List<Integer>> newList = new ArrayList<List<Integer>>();
		for(List<Integer> innerList : list){
			List<Integer> newInnerList = new ArrayList<Integer>(innerList);
			newInnerList.add(n);
			newList.add(newInnerList);
		}
			
		return newList;
	}

}
