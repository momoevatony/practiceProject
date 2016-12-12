package com.momoevatony.dataStructure;

import java.util.ArrayList;
import java.util.HashMap;

public class HashHeap_self {
	HashMap<Integer, Node> hashMap;
	ArrayList<Integer> data;
	int size;
	String mode;
	
	private class Node{
		int id;
		int num;
		public Node(Node node){
			this.id=node.id;
			this.num=node.num;
		}
		
		public Node(int id, int num){
			this.id=id;
			this.num=num;
		}
	}
	
	public HashHeap_self(String mode){
		this.size = 0;
		this.hashMap = new HashMap<Integer, Node>();
		this.data = new ArrayList<Integer>();
		this.mode = mode;
	}
	
	public int size(){
		return this.size;
	}
	
	public boolean isEmpty(){
		return (this.size>=0);
	}
	
	public int peek(){
		return data.get(0);
	}
	
	public void add(int curr){
		this.size++;
		if(hashMap.containsKey(curr)){
			Node currNode = hashMap.get(curr);
			hashMap.put(curr, new Node(currNode.id, currNode.num+1));
		}else{
			data.add(curr);
			hashMap.put(curr, new Node(data.size()-1,1));
			siftUp(data.size()-1);
		}
	}
	
	public int poll(){
		this.size--;
		int val = data.get(0);
		Node node = hashMap.get(val);
		if(node.num == 1){
			swap(0, data.size()-1);
			hashMap.remove(val);
			data.remove(data.size()-1);
			if(data.size()>0){siftDown(0);}
		}else{
			hashMap.put(val, new Node(node.id, node.num-1));
		}
		return val;
	}
	
	public void delete(int val){
		this.size--;
		Node node = hashMap.get(val);
		if(node.num==1){
			int id=node.id;
			swap(id,data.size()-1);
			hashMap.remove(val);
			data.remove(data.size()-1);
			if(data.size()>id){siftUp(id);siftDown(id);}
		}else{
			hashMap.put(val, new Node(node.id,node.num-1));
		}
	}
	
	private void swap(int ida, int idb){
		int valA = data.get(ida);
		int valB = data.get(idb);
		int numA = hashMap.get(valA).num;
		int numB = hashMap.get(valB).num;
		
		data.set(ida, valB);
		data.set(idb, valA);
		hashMap.put(valA,new Node(ida, numA));
		hashMap.put(valB,new Node(idb, numB));
	}
	
	private void siftUp(int index){
		if(index==0){return;}
		int parent = getParent(index);
		if( compareSmall(parent,index)){return;}
		else{
			swap(index, parent);
			siftUp(parent);
		}
	}
	
	private void siftDown(int parent){
		int left = getLeft(parent);
		int right = getRight(parent);
		int min=parent;
		if(left>=data.size()){return;}
		if(right>=data.size()){
			min = compareSmall(data.get(parent), data.get(left))?parent:left;
		}else{
			min = compareSmall(data.get(parent), data.get(compareSmall(data.get(left),data.get(right))?left:right) ) ? parent:compareSmall(data.get(left),data.get(right))?left:right;
		}
		if(min!=parent){
			swap(min,parent);
			siftDown(min);
		}
	}
	
	private boolean compareSmall(int a, int b){
		if(a<=b){
			if(this.mode.equals("min")){
				return true;
			}else{
				return false;
			}
		}else{
			if(this.mode.equals("min")){
				return false;
			}else{
				return true;
			}
		}
	}
	
	private int getParent(int index){
		return (index-1)/2;
	}
	private int getLeft(int index){
		return (index*2) +1;
	}
	private int getRight(int index){
		return (index*2) +2;
	}
}
