package course9;

public class PerfectSquares {
	
	//accepted 5.6.2017 19737ms
	public int numSquares(int n) {
        // Write your code here
        if (n == 1) {
            return 1;
        }
        
        if (isSquare(n)) {
            return 1;
        }
        
        int[] map = new int[n + 1];
        map[0] = 0;
        map[1] = 1;
        
        for (int curr = 2; curr <= n; curr++) {
            if (isSquare(curr)) {
                map[curr] = 1;
                continue;
            } else {
                map[curr] = curr;
            }
            for (int j = 1; j * j < curr; j++) {
                if(map[j * j] + map[curr - j * j] < map[curr]) {
                    map[curr] = map[j * j] + map[curr - j * j];
                }
            }
        }
        
        return map[n];
    }
    
    private boolean isSquare(int input) {
        int sqrt = (int) Math.sqrt(input);
        return sqrt * sqrt == input;
    }
}
