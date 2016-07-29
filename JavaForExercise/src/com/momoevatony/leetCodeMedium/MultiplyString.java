package com.momoevatony.leetCodeMedium;

public class MultiplyString {
	public static void main(String args[]){
		String num1 = "1231412415125";
		String num2 = "135157";
		String result = multiply(num1,num2);
		System.out.println(result);
	}
	
	//Accepted 7.28.2016
	public static String multiply(String num1, String num2) {
        String result = "";
        if(num1.equals("0") || num2.equals("0")){return "0";}
        
        int carry = 0;
        int currDigit = 0;
        int num1Digit = 0;
        int num2Digit = 0;
        
        for(int i=0; i<num1.length()+num2.length();i++){
        	System.out.println("forming "+i+" th digit");
        	for(int j=0;j<=i;j++){
        		num1Digit = j>=num1.length()?0:Character.getNumericValue(num1.charAt(num1.length()-1-j));
        		num2Digit = (i-j)>=num2.length()?0:Character.getNumericValue(num2.charAt(num2.length()-1-(i-j)));
        		currDigit = currDigit+num1Digit*num2Digit;
        		System.out.println("adding: num1's "+num1Digit+" and num2's "+num2Digit+". result is: "+currDigit);
        	}
        	currDigit += carry;
        	result = (currDigit%10)+result;
        	carry = currDigit/10;
        	currDigit =0;
        }
        
        return result.charAt(0) == '0'? result.substring(1): result;
    }

}
