package com.momoevatony.dataStructure;

public class Queue {
	private Node last = null;
	private Node first = null;
	
	public void push (int data){
		Node t = new Node (data);
		if (this.last != null){
			this.last.next = t;
		}
		this.last = t;
		if (this.first == null){
			this.first = this.last;
		}
	}
	
	public int pop (){
		if (this.first==null) {return -255;}
		Node t = first;
		this.first = first.next;
		if (first == null){this.last = null;}
		return t.data;
	}

	public boolean isEmpty(){
		return first==null;
	}
}
