package com.momoevatony.leetCodeMedium;

public class Search2DMatrix {
	
	//TODO
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix[0][0]>target || matrix[matrix.length-1][matrix[0].length-1]<target){return false;}
		
		int start = 0;
		int end = matrix.length-1;
		while(start <= end){
			int mid = start + (end-start)>>1;
			if(matrix[mid][0] == target){return true;}
			
			if(matrix[mid][0] < target){start = mid+1;}
			else {end=mid-1;}
		}
		
		int left = 0;
		int right = matrix[start].length-1;
		while(left<=right){
			int mid = left + (right-left)>>1;
			if(matrix[start][mid] == target){return true;}
			if(matrix[start][mid] < target){left = mid+1;}
			else{right = mid-1;}
		}
		
		return false;
    }
}
