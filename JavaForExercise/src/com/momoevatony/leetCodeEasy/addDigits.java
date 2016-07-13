package com.momoevatony.leetCodeEasy;

public class addDigits {
	
	public static void main(String args[]){
		System.out.println(addDigits(46));
	}
	
	static int addDigits(int num) {
        if (num<10){return num;}
        int sum=0;
        while(num%10>0){
            sum+=num%10;
            num=num/10;
        }
        return addDigits(sum);
    }
}
