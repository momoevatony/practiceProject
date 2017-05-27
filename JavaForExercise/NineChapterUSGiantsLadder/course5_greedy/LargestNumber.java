package course5_greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LargestNumber {
	
	//accepted 5.26.2017 2321ms
	public String largestNumber(int[] num) {
        // write your code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int curr : num) {
            list.add(curr);
        }
        Collections.sort(list, new formNumberComparator());
        StringBuilder sb = new StringBuilder();
        for (int curr : list) {
            sb.append(curr);
        }
        if (sb.charAt(0) == '0' && sb.length() > 1) {
            return "0";
        }
        return sb.toString();
    }
    
    private class formNumberComparator implements Comparator<Integer> {
        public int compare (Integer a, Integer b) {
            String aString = Integer.toString(a);
            String bString = Integer.toString(b);
            
            if (aString.charAt(0) != bString.charAt(0)) {
                return bString.charAt(0) - aString.charAt(0);
            } else {
                boolean switched = false;
                if (aString.length() < bString.length()) {
                    String temp = new String(aString);
                    aString = new String(bString);
                    bString = new String(temp);
                    switched = true;
                }
                
                char firstCh = aString.charAt(0);
                
                for (int i = 1; i < aString.length(); i++) {
                    char aCh = aString.charAt(i);
                    char bCh = firstCh;
                    if (i < bString.length()) {
                        bCh = bString.charAt(i);
                    }
                    if (aCh == bCh) {
                        continue;
                    }
                    if (switched) {
                        return aCh - bCh;
                    } else {
                        return bCh - aCh;
                    }
                }
            }
            
            return 0;
        }
    }
}
