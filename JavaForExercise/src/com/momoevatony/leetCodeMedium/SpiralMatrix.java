package com.momoevatony.leetCodeMedium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public static void main (String args[]){
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		for (int i:spiralOrder(matrix)){
			System.out.println(i);
		}
	}
	
	//Accepted 7.29.2016
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<Integer>();
		if(matrix.length<=0){return list;}
		
		int left = 0; int right = matrix[0].length-1;
		int top = 0; int bottom = matrix.length-1;
		while (true){
			for(int i=left; i<=right;i++ ){
				list.add(matrix[top][i]);
			}
			top++;
			if(top>bottom){break;}
			for(int i=top; i<=bottom; i++){
				list.add(matrix[i][right]);
			}
			right--;
			if(right<left){break;}
			for(int i=right;i>=left;i--){
				list.add(matrix[bottom][i]);
			}
			bottom--;
			if(bottom<top){break;}
			for(int i=bottom; i>=top; i--){
				list.add(matrix[i][left]);
			}
			left++;
			if(left>right){break;}
		}
        return list;
    }
}
