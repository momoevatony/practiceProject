package com.momoevatony.dataStructure;

public class Stack {
	private Node top;
	
	public void push(int data){
		Node t = new Node(data);
		t.next = top;
		this.top = t;
	}
	
	public int pop(){
		if (this.top == null){return -255;}
		Node t = top;
		this.top = top.next;
		return t.data;
	}
	
	public boolean isEmpty(){
		return top==null;
	}
}
