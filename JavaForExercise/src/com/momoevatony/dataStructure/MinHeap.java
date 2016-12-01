package com.momoevatony.dataStructure;

public class MinHeap extends Heap {
	public MinHeap(int[] data){
		super(data);
	}
	
	@Override
	public Heap build(){
		for (int start = getParentIndex(length-1);start>=0;start--){
			adjustDownHeap(start);
		}
		return this;
	}
	
	@Override
	public Heap remove(){
		swap (0, length-1);
		int[] newData = new int [length-1];
		System.arraycopy(data, 0, newData, 0, length-1);
		this.data = newData;
		this.length = length-1;
		adjustDownHeap(0);
		
		return this;
	}
	
	@Override
	public Heap insert(int value){
		int[] newData = new int [length+1];
		System.arraycopy(data, 0, newData, 0, length);
		newData[length] = value;
		this.data = newData;
		this.length = length+1;
		adjustUpHeap(this.length-1);
		
		return this;
	}
	
	@Override
	public void adjustDownHeap(int node){
		if(getLeftChild(node)>=length){return;}
		int left = getLeftChild(node);
		int right = getRightChild(node);
		int max = node;
		//Find the smallest in these three nodes and switch it to the parent node (if not parent);
		if(right>=length){
			max = data[max] < data[left] ? max:left;
		}else{
			max = data[max] < data[(data[left]<data[right]?left:right)]? max:(data[left]<data[right]?left:right);
		}
		if(max!=node){
			swap (node, max);
			adjustDownHeap(max);
		}
	}
	
	@Override
	public void adjustUpHeap(int node){
		int parent = getParentIndex(node);
		//switch current node with its parent node if it's smaller than its parent and it's not root.
		if(parent >= 0 && data[parent] > data[node]){
			swap(node, parent);
			adjustUpHeap(parent);
		}
	}
}
