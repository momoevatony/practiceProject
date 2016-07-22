package com.momoevatony.leetCodeMedium;

public class SquareRootOfX {
	
	public static void main(String args[]){
		System.out.println((int)3.6);
		System.out.println((int)3.4);
		System.out.println(Math.floor(3.6));
		System.out.println(Math.round(3.4));
		System.out.println(mySqrt(500));
		
		
	}
	
	public static int mySqrt(int x) {
		if (x<0){return -1;}
		int start =0;
		int end = x;
		int mid = (start+end)/2;
		while(start < end){
			System.out.println(start + " " + mid + " "+ end);
			if(mid*mid <= x && (mid+1)*(mid+1)>=x){return mid;}
			else if((mid*mid) > x ){end = mid-1; mid = (start+end)/2;}
			else{start=mid+1;mid = (start+end)/2;}
			
		}
        return (start+end)/2;
    }
}
