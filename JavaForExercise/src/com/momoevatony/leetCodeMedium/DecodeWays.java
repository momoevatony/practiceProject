package com.momoevatony.leetCodeMedium;

public class DecodeWays {
	
	public static void main(String args[]){
		String s = "712128121";
		long startTime=System.currentTimeMillis();
		System.out.println(numDecodings(s));
		long endTime=System.currentTimeMillis(); 
		System.out.println("It takes： "+(endTime-startTime)+"ms");
		
	}
	
	
	//Accepted 7.25.2016
	public static int numDecodings(String s) {
		if(s.length()<1){return 0;}
		int index = 0;
		int totalWays = 1;
		int ways=1;
		while(index<s.length()){
		    if(s.charAt(index)=='0'){
				if (index ==0) {return 0;}
				if (s.charAt(index-1)!='1' && s.charAt(index-1)!='2') {return 0;}
			}
			if(index == s.length()-1){return totalWays * fib(ways);}
			if(s.charAt(index)=='1'){
				if(s.charAt(index+1) =='0'){ways--;}
				else{ways++;}
			}
			else if(s.charAt(index)=='2'){
				if(s.charAt(index+1) =='0'){ways--;}
				else if(s.charAt(index+1)<='6'){ways++;}
			}
			else{
				totalWays = totalWays * fib(ways); ways =1;
			}			
			index++;
		}
		
		return totalWays;
    }
	
	private static int fib(int n){
		if(n<=1){return 1;}
		return fib(n-1)+fib(n-2);
	}
}
