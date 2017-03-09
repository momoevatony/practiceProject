package course2;

public class Search2DMatrix {
	
	//accepted 3.8.2017 3574ms
	public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
		if(matrix.length == 0 || matrix[0].length == 0){return false;}
		
		int start = 0;
		int end = matrix.length-1;
		
		while(start+1<end){
			int mid = (end-start)/2+start;
			
			if(matrix[mid][0] == target){
				return true;
			}else if(matrix[mid][0] < target){
				start = mid;
			}else{
				end = mid;
			}
		}
		
		if(matrix[start][0] ==target || matrix[end][0] == target ){
			return true;
		}
		
		int index=start;
		if(matrix[end][0] < target){
			index = end;
		}
		start = 0;
		end = matrix[index].length-1;
		
		while(start+1<end){
			int mid = (end-start)/2+start;
			
			if(matrix[index][mid] == target){
				return true;
			}else if(matrix[index][mid] < target){
				start = mid;
			}else{
				end = mid;
			}
		}
		
		if(matrix[index][start] ==target || matrix[index][end] == target ){
			return true;
		}
		
		return false;
    }
}
