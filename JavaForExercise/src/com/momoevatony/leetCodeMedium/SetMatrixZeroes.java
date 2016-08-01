package com.momoevatony.leetCodeMedium;

import java.util.Arrays;

public class SetMatrixZeroes {
	
	//Accepted 7.31.2016
	public void setZeroes(int[][] matrix) {
		boolean zeroFlag = false;
		boolean[]zeroRows = new boolean[matrix.length];
		for (int j=0;j<matrix[0].length;j++){
			zeroFlag = false;
			for(int i=0;i<matrix.length;i++){
				if(zeroFlag){if(matrix[i][j]==0){zeroRows[i]=true;}matrix[i][j]=0;}
				else{
					if(matrix[i][j]==0){
						int currRow = i;
						zeroRows[currRow]=true;
						while(currRow>=0){matrix[currRow][j]=0;currRow--;}
						zeroFlag=true;
					}
				}
			}
		}
		for(int i=0;i<zeroRows.length;i++){
			if(zeroRows[i]){matrix[i] = new int[matrix[i].length];}
		}
        
    }
	

}
