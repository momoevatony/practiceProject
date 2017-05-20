package course1_string;

public class LongestCommonSubstring {
	
	//accepted 5.19.2017 1990ms
	public int longestCommonSubstring(String A, String B) {
        // write your code here
        int[][] map = new int[A.length() + 1][B.length() + 1];
        
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    map[i][j] = map[i - 1][j - 1] + 1;
                } else {
                    map[i][j] = 0;
                }
            }
        }
        
        int result = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                result = result > map[i][j] ? result : map[i][j];
            }
        }
        
        return result;
    }
}
