package course5_greedy;

public class DeleteDigits {
	public String DeleteDigits(String A, int k) {
        // write your code here
        StringBuilder sb = new StringBuilder(A);
        
        while (k > 0) {
            int index = 0;
            while (index < sb.length() - 1) {
                if (sb.charAt(index) > sb.charAt(index + 1)) {
                    break;
                }
                index++;
            }
            sb.deleteCharAt(index);
            k--;
        }
        int index = 0;
        while (sb.charAt(index) == '0') {
            index++;
        }
        return sb.substring(index);
    }
}
