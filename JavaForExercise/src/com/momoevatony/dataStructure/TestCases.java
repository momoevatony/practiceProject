package com.momoevatony.dataStructure;

import java.util.Arrays;

public class TestCases {
	public static void main (String args[]){
		/*Stack Test
		 
	    Stack testStack = new Stack();
		int[] array = {2,4,6,8,10};
		for (int i=0;i< array.length;i++){
			testStack.push(array[i]);
		}
		while (!testStack.isEmpty()){
			System.out.println(testStack.pop());
		}
		System.out.println(testStack.isEmpty());
		
		
		
		//Queue Test
		Queue testQueue = new Queue();
		int [] array = {2,4,6,8,10};
		for (int i=0;i< array.length;i++){
			testQueue.push(array[i]);
		}
		while (!testQueue.isEmpty()){
			System.out.println(testQueue.pop());
		}
		System.out.println(testQueue.isEmpty());
		*/
		
		
		/*
		String input = "t";
		System.out.println(test(input));
		*/
		
		//Min Heap Test
		int[] data = {14,13,16,10,12,9,11,6,8,7,4,3,1};
		Heap heap = new MinHeap(data);
		heap.build();
		System.out.println(Arrays.toString(heap.data));
		
		heap.insert(5);
		System.out.println(Arrays.toString(heap.data));
		
		heap.remove();
		System.out.println(Arrays.toString(heap.data));
	}
	
	static String test(String input){
		return input.length()>=2 ? Character.toString(input.charAt(0)).concat(Integer.toString(input.length()-2)).concat(Character.toString(input.charAt(input.length()-1))) : input;
	}

}
