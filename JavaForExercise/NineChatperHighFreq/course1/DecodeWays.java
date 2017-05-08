package course1;

public class DecodeWays {
	
	//accepted 5.7.2017 7794ms
	public int numDecodings(String s) {
        // Write your code here
        if (s.length() == 0 || s.equals("0")) {
            return 0;
        }
        
        if (s.length() == 1) {
            return 1;
        }
        
        int[] map = new int[s.length() + 1];
        map[0] = 1;
        map[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) == '0') {
                if (s.charAt(i - 2) != '1' && s.charAt(i - 2) != '2') {
                    return 0;
                } else {
                    map[i] = map[i - 2];
                }
            } else {
                if (s.charAt(i - 2) == '1') {
                    map[i] = map[i - 1] + map[i - 2];
                } else if (s.charAt(i - 2) == '2' && (s.charAt(i - 1) >= '1' && s.charAt(i - 1) <= '6')) {
                    map[i] = map[i - 1] + map[i - 2];
                } else {
                    map[i] = map[i - 1];
                }
            }
        }
        
        return map[s.length()];
    }
}
