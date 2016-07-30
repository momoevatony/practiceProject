package com.momoevatony.leetCodeMedium;

import java.util.Arrays;

public class Rotatematrix {
	public static void main (String args[]){
		int[][]matrix = {{1,2,3},{4,5,6},{7,8,9}};
		for(int i =0; i< matrix.length;i++){
			System.out.println(Arrays.toString(matrix[i]));
		}
		rotate(matrix);
		for(int i =0; i< matrix.length;i++){
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
	
	//Accepted 7.29.2016
	public static void rotate(int[][] matrix) {
		for(int start=0, end=matrix.length-1; start<=end; start++, end--){
			int[] temp = new int[end-start];
			int tempIndex = 0;
			int i=start;
			int j=start;
			int swap =0;
			while(j<end){swap = matrix[i][j];matrix[i][j]=temp[tempIndex];temp[tempIndex]=swap;tempIndex++;j++;}
			tempIndex=0;
			while(i<end){swap = matrix[i][j];matrix[i][j]=temp[tempIndex];temp[tempIndex]=swap; tempIndex++;i++;}
			tempIndex=0;
			while(j>start){swap = matrix[i][j];matrix[i][j]=temp[tempIndex];temp[tempIndex]=swap;tempIndex++;j--;}
			tempIndex=0;
			while(i>start){swap = matrix[i][j];matrix[i][j]=temp[tempIndex];temp[tempIndex]=swap;tempIndex++;i--;}
			tempIndex=0;
			while(j<end){swap = matrix[i][j];matrix[i][j]=temp[tempIndex];temp[tempIndex]=swap; tempIndex++;j++;}
			tempIndex=0;
		}
    }

}
