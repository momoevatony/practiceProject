package com.momoevatony.dataStructure;

import java.util.Arrays;

public abstract class Heap {
	protected int [] data;
	protected int length = 0;
	
	public Heap (int[] data){
		this.data = data;
		this.length = data.length;
	}
	
	public abstract Heap build();
	
	public abstract Heap remove();
	
	public abstract Heap insert(int value);
	
	public abstract void adjustDownHeap (int node);
	
	public abstract void adjustUpHeap (int node);
	
	public void swap (int n1, int n2){
		int temp = data[n1];
		data[n1] = data[n2];
		data[n2] = temp;
	}
	
	protected int getParentIndex (int node){
		return (node-1)>>1;
	}
	
	protected int getLeftChild (int node){
		return (node<<1)+1;
	}
	
	protected int getRightChild (int node){
		return (node<<1)+2;
	}
	
	protected void print(){
		System.out.println(Arrays.toString(data));
	}
}
