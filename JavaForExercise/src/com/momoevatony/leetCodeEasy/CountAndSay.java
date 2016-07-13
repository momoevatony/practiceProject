package com.momoevatony.leetCodeEasy;

import java.util.ArrayList;
import java.util.Arrays;

public class CountAndSay {
	public static void main (String args[]){
		String [] test = "Hello world ".split(" ");

		System.out.println("Hello world ".trim());
		System.out.println(Arrays.toString(test));
		//System.out.println(countAndSay(1333444));
	}
	static String countAndSay (int input){
		String output = "";
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(input>0){
			list.add(input%10);
			System.out.println(input%10);
			input = input/10;
		}
		int digit = 0;
		int count = 1;
		for(int i=list.size()-1;i>0;i--){
			digit = list.get(i);
			while(i>0 && list.get(i-1) == list.get(i)){
				count++;
				i--;
			}
			output=output+Integer.toString(count)+Integer.toString(digit);
			count=1;
		}
		return output;
	}

}
