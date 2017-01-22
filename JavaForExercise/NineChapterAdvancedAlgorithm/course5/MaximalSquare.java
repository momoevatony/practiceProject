package course5;

public class MaximalSquare {
	
	//Accepted 12.12.2016 2398ms
	public int maxSquare(int[][] matrix) {
        // write your code here
        if(matrix.length<=0 || matrix[0].length<=0){return 0;}
		int max = 0;
		int[][] map = new int[matrix.length][matrix[0].length];
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				if(i==0||j==0){map[i][j] = matrix[i][j] == 1? 1:0; max = max>map[i][j]?max:map[i][j];continue;}
				if(matrix[i][j] == 0){
					map[i][j] = 0;
				}else{
					map[i][j] = Math.min(map[i-1][j-1], Math.min(map[i-1][j], map[i][j-1]))+1;
				}
				max = max>map[i][j]?max:map[i][j];
			}
		}
		
		return max*max;
    }
}
