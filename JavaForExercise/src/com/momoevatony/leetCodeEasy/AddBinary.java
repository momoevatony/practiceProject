package com.momoevatony.leetCodeEasy;

public class AddBinary {
	public static void main(String args[]){
		System.out.println(addBinary("11","1"));
	}
	
	public static String addBinary(String a, String b){
		int indexA = a.length();
		int indexB = b.length();
		int carry = 0;
		String res = "";
		while (indexA>0 || indexB>0){
			int bit1 = indexA>0 ? (a.charAt(--indexA)=='1'?1:0) :0;
			int bit2 = indexB>0 ? (b.charAt(--indexB)=='1'?1:0) :0;
			int value = bit1^bit2^carry;
			carry = bit1&carry|bit2&carry|bit1&bit2;
			res = (String.valueOf(value)).concat(res);
		}
		return (carry==1?"1".concat(res):res);
	}

}
