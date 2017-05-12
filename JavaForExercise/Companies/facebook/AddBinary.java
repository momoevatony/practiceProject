package facebook;

public class AddBinary {
	
	//accepted 5.11.2017 13051ms
	public String addBinary(String a, String b) {
        // Write your code here
        if (a.length() < b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        
        int pa = a.length() - 1;
        int pb = b.length() - 1;
        int curr = 0;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        
        while (pb >= 0) {
            int bitA = (int)(a.charAt(pa) - '0');
            int bitB = (int)(b.charAt(pb) - '0');
            
            curr = (carry + bitA + bitB) % 2;
            carry = carry + bitA + bitB >= 2 ? 1 : 0;
            
            sb.insert(0, Integer.toString(curr));
            
            pa--;
            pb--;
        }
        
        while (pa >= 0) {
            int bitA = (int)(a.charAt(pa) - '0');
            curr = (carry + bitA) % 2;
            carry = carry + bitA >= 2 ? 1 : 0;
            
            sb.insert(0, Integer.toString(curr));
            
            pa--;
        }
        
        if (carry > 0) {
            sb.insert(0, '1');
        }
        
        return sb.toString();
    }
}
