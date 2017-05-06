package course9;

public class UniquePaths {
	
	//Accepted 5.6.2017 13367ms
	public int uniquePaths(int m, int n) {
        // write your code here 
        int[][] map = new int[2][n];
        
        for (int j = 0; j < n; j++) {
            map[0][j] = 1;
        }
        
        map[1][0] = 1;
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                map[i % 2][j] = map[(i - 1) % 2][j] + map[i % 2][j - 1];
            }
        }
        
        return map[(m - 1) % 2][n - 1];
    }
}
