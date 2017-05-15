package facebook;

public class BigIntegerMultiplication {
	
	//accepted 5.14.2017 4574ms
	public String multiply(String num1, String num2) {
        // Write your code here
        if (num1 == null || num2 == null) {
            return null;
        }
        
        int[] result = new int[num1.length() + num2.length()];
        int carry = 0;
        
        for(int i = num1.length() - 1; i >= 0; i--) {
            carry = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int int1 = (int)(num1.charAt(i) - '0');
                int int2 = (int)(num2.charAt(j) - '0');
                
                int curr = int1 * int2 + carry + result[i + j + 1];
                carry = curr / 10;
                result[i + j + 1] = curr % 10;
            }
            result[i] = carry;
        }
        
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < result.length - 1 && result[index] == 0) {
            index++;
        }
        
        while (index < result.length) {
            sb.append(result[index++]);
        }
        
        return sb.toString();
    }
}
