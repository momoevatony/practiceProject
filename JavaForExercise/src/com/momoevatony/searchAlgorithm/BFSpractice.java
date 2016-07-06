package com.momoevatony.searchAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;

import com.momoevatony.dataStructure.*;

public class BFSpractice {
	
	public static void main (String args[]){
		int [][] maze = {{0,1,0,0,0},{0,1,0,1,0},{0,0,0,0,0},{0,1,1,1,0},{0,0,0,1,0}};
		Node startPt = new Node(0,0);
		Node endPt = new Node (4,4);
		BFS(maze, startPt, endPt);
	}
	
	static class Node {
		int row, col;
		Node previous = null;
		boolean isVisited = false;
		
		public Node (int row, int col){
			this.row = row;
			this.col = col;
			this.isVisited = false;
		}
	}

	
	static void BFS (int [][] maze, Node startPt, Node endPt){
		
		ArrayList <Node> list = new ArrayList<Node>();
		int listIndex = 0;
		list.add(startPt);
		int [][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
		int [][] visitMap = new int[5][5];
		
		while (listIndex < list.size()){
			Node curr = list.get(listIndex);
			visitMap[curr.row][curr.col] = 1;
			System.out.println("current node is: "+Integer.toString(curr.row)+ ", "+Integer.toString(curr.col));
			
			if (equalNode(curr, endPt)){
				while(curr.previous != null){
					System.out.println ("["+Integer.toString(curr.row)+ ", "+Integer.toString(curr.col)+"] ");
					curr = curr.previous;
				}
				return;
			}
			
			for (int[] dir : directions){
				Node next = moveNode(dir, curr);
				next.previous = curr;
				if (isOnPath(maze,next) && visitMap[next.row][next.col] == 0){
					System.out.println("Next node is: "+Integer.toString(next.row)+ ", "+Integer.toString(next.col));
					list.add(next);
				}
			}
			
			listIndex++;
		}
		System.out.println("Path not found.");
	}
	
	
	static Node moveNode (int[] dir, Node curr){
		Node next = new Node(curr.row+dir[0], curr.col+dir[1]);
		return next;
	}
	
	static boolean isOnPath (int [][] maze, Node curr){
		if (curr.row < 0 || curr.col< 0 || curr.row > 4 || curr.col >4){return false;}
		return (maze[curr.row][curr.col]==0);
	}
	
	static boolean equalNode (Node a, Node b){
		return (a.row == b.row && a.col == b.col);
	}

}
