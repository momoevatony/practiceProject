package course9;

public class MinimumPathSum {
	
	//accepted 5.6.2017 1640ms
	public int minPathSum(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        
        int[][] map = new int[2][grid[0].length];
        map[0][0] = grid[0][0];
        
        for (int j = 1; j < map[0].length; j++) {
            map[0][j] = map[0][j - 1] + grid[0][j];
        }
        //System.out.println(Arrays.toString(map[0]));
        
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j == 0) {
                    map[i % 2][j] = grid[i][j] + map[(i - 1) % 2][j];
                } else {
                    map[i % 2][j] = grid[i][j] + Math.min(map[(i - 1) % 2][j], map[i % 2][j - 1]);
                }
            }
            //System.out.println(Arrays.toString(map[i % 2]));
        }
        /*
        System.out.println("grid:");
        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
        */
        
        return map[(grid.length - 1) % 2][map[0].length - 1];
    }
}
