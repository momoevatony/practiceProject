package course9;

public class UniquePaths2 {
	
	//Accepted 5.6.2017 9460ms
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if(obstacleGrid[0][0] == 1) {return 0;}
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] map = new int[2][n];
        
        for (int j = 0; j < n; j++) {
            if(obstacleGrid[0][j] == 1) {
                break;
            }
            map[0][j] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    map[i % 2][j] = 0;
                    continue;
                }
                
                if (j == 0) {
                    map[i % 2][j] = map[(i - 1) % 2][j];
                } else {
                    map[i % 2][j] = map[(i - 1) % 2][j] + map[i % 2][j - 1];
                }
            }
        }
        
        return map[(m - 1) % 2][n - 1];
    }
}
