package course5;

public class LongestIncreasingContinueSubseq2 {
	
	//Accepted 12.12.2016 10616ms
	int[][] map;
	boolean[][] flag;
	
	public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        // Write your code here
		if(A.length==0 || A[0].length==0){return 0;}
		int max = 0;
		map = new int[A.length][A[0].length];
		flag = new boolean[A.length][A[0].length];
		
		for(int i =0;i<A.length;i++){
			for(int j=0;j<A[0].length;j++){
				map[i][j] = DPsearch(A,i,j);
				max = Math.max(max, map[i][j]);
			}
		}
		
		return max;
    }
	
	int[] dx = {-1,0,1,0};
	int[] dy = {0,-1,0,1};
	private int DPsearch (int[][]A, int i, int j){
		if(flag[i][j]){return map[i][j];}
		int currMax = 1;
		for(int k=0;k<dx.length;k++){
		    if(i+dx[k] <0 || i+dx[k]>=A.length || j+dy[k]<0 || j+dy[k]>=A[0].length){continue;}
			if(A[i+dx[k]][j+dy[k]] > A[i][j]){
				currMax = Math.max(currMax, DPsearch(A,i+dx[k],j+dy[k])+1);
			}
		}
		flag[i][j] = true;
		map[i][j] = currMax;
		return currMax;
	}
}
