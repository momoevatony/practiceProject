package course9;

public class Triangle {
	
	//Accepted 5.6.2017 1547ms
	public int minimumTotal(int[][] triangle) {
        // write your code here
		if (triangle == null || triangle.length == 0 || triangle[0].length == 0) {
            return -1;
        }
        
        int[] map = new int[triangle[triangle.length - 1].length];
        
        map[0] = triangle[0][0];
        
        for (int i = 1; i < triangle.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == 0) {
                    map[j] = triangle[i][j] + map[j];
                } else if (j == i) {
                    map[j] = triangle[i][j] + map[j - 1];
                } else {
                    map[j] = triangle[i][j] + Math.min(map[j], map[j - 1]);
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < map.length; i++) {
            min = Math.min(min, map[i]);
        }
        
        return min;
    }
}
