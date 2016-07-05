package com.momoevatony.dataStructure;

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
		
		*/
		
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
		
	}

}
