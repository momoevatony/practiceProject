package com.momoevatony.leetCodeMedium;

public class PowerXN {
	public static void main(String args[]){
		System.out.println(myPow(1.001,1234));
	}
	
	public double myPow2(double x, int n) {
        if(n==0){return 0;}
        if(n==1){return x;}
        if(n<0){return 1/(x*myPow(x,-n-1));}
        return x*myPow(x,n-1);
    }
	
	public static double myPow(double x, int n){
        if(n==0){return 0;}
        if(n==1){return x;}
        if(n<0){return 1/(x*myPow(x,-n-1));}
		
		return n%2 == 1? myPow(x*x, (n-1)/2) : myPow(x*x, n/2);
	}
}
