package com.momoevatony.LintCodeEasy;

public class TrailingZeros {
	public long trailingZeros(long n) {
		if(n<5){return 0;}
		if(n<10){return 1+trailingZeros(n-5);}
        // write your code here
		return 2+trailingZeros(n-10);
    }
}
