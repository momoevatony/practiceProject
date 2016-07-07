package com.momoevatony.leetCodeEasy;
import java.util.ArrayList;

import com.momoevatony.dataStructure.Node;

public class ZigZagConversion {
	public static void main(String args[]){
		System.out.println("final String is: "+convert("PAYPALISHIRING",3));
	}
	
	public static String convert(String original, int rows){
		ArrayList<Queue> map = new ArrayList<Queue>();
		for(int i=0;i<rows;i++){map.add(new Queue());}
		boolean goingDown = true; //0 means going down, 1 means going up;
		int stringIndex = 0;
		int stackIndex = 0;
		while (stringIndex < original.length()){
			System.out.println("working on character: "+Character.toString(original.charAt(stringIndex)));
			System.out.println("Current Queue is: "+Integer.toString(stackIndex));
			map.get(stackIndex).push(Character.toString(original.charAt(stringIndex)));			
			if (goingDown == true){
				stackIndex++;
				goingDown = stackIndex == rows-1 ? false : true;
			}else{
				stackIndex--;
				goingDown = stackIndex == 0 ? true : false;
			}
			stringIndex++;
		}
		String finalString = "";
		for (Queue curr : map){
			while(!curr.isEmpty()){
				finalString.concat((String)curr.pop());
			}
		}
		return finalString;
	}
	
	public static class Node {
		Node next = null;
		String data;
		
		public Node (String data){
			this.data = data;
		}
	}
	
	public static class Queue {
		private Node last = null;
		private Node first = null;
		
		public void push (String data){
			Node t = new Node (data);
			if (this.last != null){
				this.last.next = t;
			}
			this.last = t;
			if (this.first == null){
				this.first = this.last;
			}
		}
		
		public String pop (){
			if (this.first==null) {return null;}
			Node t = first;
			this.first = first.next;
			if (first == null){this.last = null;}
			return t.data;
		}

		public boolean isEmpty(){
			return first==null;
		}
	}

}
