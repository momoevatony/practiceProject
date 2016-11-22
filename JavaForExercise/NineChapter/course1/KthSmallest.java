package course1;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallest {
	
	
	//Accepted 11/21/2016 4955 ms
	public int kthSmallest(int[][] matrix, int k) {
        // write your code here
		Queue<Node> pq = new PriorityQueue<Node>();
		boolean[][] map = new boolean[matrix.length][matrix[0].length];
		pq.add(new Node(matrix[0][0], 0,0));
		for(int i=1;i<k;i++){
			Node curr = pq.poll();
			if (curr.row<matrix.length-1 && !map[curr.row+1][curr.col]){
				pq.add(new Node(matrix[curr.row+1][curr.col],curr.row+1,curr.col));
				map[curr.row+1][curr.col] = true;
			}
			if (curr.col<matrix[curr.row].length-1 &&!map[curr.row][curr.col+1]){
				pq.add(new Node(matrix[curr.row][curr.col+1],curr.row,curr.col+1));
				map[curr.row][curr.col+1] = true;
			}
		}
        
		return pq.peek().data;
    }
    
    private class Node implements Comparable<Node>{
        private int data;
        private int row;
        private int col;
        
        public Node(int data, int row, int col){
            this.data = data;
            this.row = row;
            this.col = col;
        }
        
        @Override
        public int compareTo (Node node){
            return Integer.compare(this.data, node.data);
        }
    }
}
