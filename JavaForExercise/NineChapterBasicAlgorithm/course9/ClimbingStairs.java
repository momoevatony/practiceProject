package course9;

public class ClimbingStairs {
	
	//Accepted 5.6.2017 2611ms
	public int climbStairs(int n) {
        // write your code here
        int[] map = new int[2];
        
        map[0] = 1;
        map[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            map[i % 2] = map[(i - 1) % 2] + map[(i - 2) % 2];
        }
        
        return map[n % 2];
    }
}
