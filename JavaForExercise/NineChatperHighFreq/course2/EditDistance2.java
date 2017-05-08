package course2;

public class EditDistance2 {
	
	//accepted 5.7.2017 9669ms
	public boolean isOneEditDistance(String s, String t) {
        // Write your code here
        if (s.equals(t)) {
            return false;
        }
        
        int[] map = new int[256];
        boolean flag = false;
        
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        
        for (char ch : (s.length() <= t.length() ? s : t).toCharArray()) {
            map[(int)ch] ++;
        }
        
        for (char ch : (s.length() > t.length() ? s : t).toCharArray()) {
            if (map[(int)ch] == 0) {
                if (flag) {
                    return false;
                }
                flag = true;
            } else {
                map[(int)ch]--;
            }
        }
        
        return true;
    }
}
