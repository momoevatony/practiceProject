package com.momoevatony.searchAlgorithm;

import java.util.ArrayList;

public class DFSpractice {

	static int[] visitMap = new int[5];
	
	public static void main (String args[]){
		int[][]map = {{0,1,0,1,0},{1,0,1,0,1},{0,1,0,1,1},{1,0,1,0,0},{0,1,1,0,0}};
		Node start = new Node(3);
		Node end = new Node(4);
		System.out.println(DFS(map, start, end));
	}
	
	static class Node {
		int index;
		Node previous = null;
		
		public Node (int index){
			this.index = index;
		}
	}
	
	public static boolean DFS(int[][] map, Node curr, Node end){
		
		visitMap[curr.index] = 1;
		if(curr.index == end.index){System.out.println("pathFound");return true;}

		for (Node child : getChildren(map, curr)){
			if(visitMap[child.index] != 1){
				
				System.out.println("Visiting Node number: "+Integer.toString(child.index));
				if (DFS(map, child, end)){
					return true;
				}
				visitMap[child.index] =0;
			}
		}
		
		return false;
	}
	
	public static ArrayList<Node> getChildren (int[][] map, Node curr){
		ArrayList<Node> children = new ArrayList<Node>();
		for (int i=0; i<map.length;i++){
			if (map[curr.index][i] != 0){
				Node child = new Node(i);
				children.add(child);
			}
		}
		return children;
	}

}
