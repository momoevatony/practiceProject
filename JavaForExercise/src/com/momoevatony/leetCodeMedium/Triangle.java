package com.momoevatony.leetCodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
	
	private int[] minArray;
	
	public int minimumTotal(List<List<Integer>> triangle) {
		if(triangle.size()<=0){return 0;}
		minArray = new int[triangle.size()];
		minArray = minimumTotalDP2(triangle, 0);
		Arrays.sort(minArray);
        return minArray[0];
    }
	
	
	//This DP uses more spaces and is accepted 8.11.2016
	public int[] minimumTotalDP (List<List<Integer>> triangle, int currRow, int[] prevLevel){
		System.out.println(Arrays.toString(prevLevel));
		if(currRow>=triangle.size()) {return prevLevel;}
		int[] currLevel = new int[currRow+1];
		List<Integer> currList = new ArrayList<Integer>(triangle.get(currRow));

		if(currRow==0){currLevel[0] = currList.get(0); return minimumTotalDP(triangle, 1, currLevel);}
		
		currLevel[0]=currList.get(0)+prevLevel[0];
		currLevel[currLevel.length-1]=currList.get(currList.size()-1)+prevLevel[prevLevel.length-1];
		
		for(int i=1; i<currLevel.length-1;i++){
			currLevel[i] = currList.get(i) + (prevLevel[i-1]<prevLevel[i]?prevLevel[i-1]:prevLevel[i]); 
		}
		
		return minimumTotalDP(triangle, currRow+1, currLevel);
	}
	
	
	//Uses O(n) where n is the row's number. Accepted 8.11.2016
	public int[] minimumTotalDP2 (List<List<Integer>> triangle, int currRow){
		if(currRow == minArray.length){return minArray;}
		List<Integer> currList = new ArrayList<Integer>(triangle.get(currRow));
		
		if(currRow==0){minArray[0] = currList.get(0); return minimumTotalDP2(triangle,1);}
		minArray[currRow] = minArray[currRow-1]+currList.get(currRow);
		
		for(int i=currRow-1;i>0;i--){
			minArray[i] = (minArray[i-1]<=minArray[i]? minArray[i-1]:minArray[i]) + currList.get(i);
		}
		minArray[0]=minArray[0]+currList.get(0);
		
		return minimumTotalDP2(triangle, currRow+1);
	}
	
}
