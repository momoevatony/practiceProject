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
}
