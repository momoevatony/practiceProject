package course2;

public class MirrorNumbers {
	
	//accepted 5.7.2017 Needs to re-write using HashMap
	public boolean isStrobogrammatic(String num) {
        // Write your code here
        int start = 0;
        int end = num.length() - 1;
        
        while (start < end) {
            char left = num.charAt(start);
            char right = num.charAt(end);
            if ((left >= '2' && left <= '5') || (left == '7') || (right >= '2' && right <= '5') || (left == '7') ) {
                return false;
            }
            if (left == '6') {
                if (right != '9') {return false;}
            } else if (left == '9') {
                if (right != '6') {return false;}
            } else if (left != right) {
                return false;
            }
            
            start++;
            end--;
        }
        if (start == end) {
            return (num.charAt(end) == '0' || num.charAt(end) == '1' || num.charAt(end) == '8');
        }
        
        return true;
    }
}
