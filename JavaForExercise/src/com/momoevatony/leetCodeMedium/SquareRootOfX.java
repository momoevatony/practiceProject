package com.momoevatony.leetCodeMedium;

public class SquareRootOfX {
	
	public static void main(String args[]){
		System.out.println(mySqrt(2147395600));
	}
	
	//Accepted on 7.24.2016
	public static int mySqrt(int x) {
		if (x<0){return -1;}
		long start =0;
		long end = x;
		long mid = (start+end)/2;
		while(start < end){
			if(start*start == x || end*end==x || mid*mid ==x){return (int)(start*start == x?start:(mid*mid==x?mid:end));}
			if(mid*mid < x && (mid+1)*(mid+1)>x){return (int)mid;}
			else if((mid*mid) > x ){end = (int)mid-1; mid = (start+end)/2;}
			else{start=(int)mid+1;mid = (start+end)/2;}
		}
        return (int) (start+end)/2;
    }
	public static int mySqrt2(int x) {
		return (int)Math.sqrt(x);
	}
}
