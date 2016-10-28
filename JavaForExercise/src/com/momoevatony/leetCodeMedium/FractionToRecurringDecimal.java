package com.momoevatony.leetCodeMedium;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
		long numeratorLong = numerator;
		long denominatorLong = denominator; 
		if(numeratorLong%denominatorLong==0){return Long.toString(numeratorLong/denominatorLong);}
		StringBuilder result = new StringBuilder();
        if( (numeratorLong>0)^(denominatorLong>0) ){result.append("-");}
        numeratorLong=Math.abs(numerator); denominatorLong = Math.abs(denominator);
		result.append(Long.toString(numeratorLong/denominatorLong));
		numeratorLong = numeratorLong%denominatorLong;
		if(numeratorLong == 0) {return result.toString();}
		result.append(".");
		int index = result.length()-1;
		Map <Long, Integer> map = new HashMap<Long, Integer>();
		while(!map.containsKey(numeratorLong)){
			if(numeratorLong == 0) {return result.toString();}
			map.put(numeratorLong, index);
			index++;
			numeratorLong = numeratorLong*10;
			result.append(Long.toString(Math.abs(numeratorLong)/Math.abs(denominatorLong)));
			numeratorLong = numeratorLong%denominatorLong;
		}
		index = map.get(numeratorLong);
		result.insert(index+1, "("); result.append(")");
		return result.toString();
    }
}
