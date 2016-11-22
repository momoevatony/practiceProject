package course1;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthInArrays {
	
	
	//Accepted 11/21/2016 13852 ms
	public int KthInArrays(int[][] arrays, int k) {
        // Write your code here
		Queue<Node> pq = new PriorityQueue<Node>();
		for(int i=0;i<arrays.length;i++){
			if(arrays[i].length==0){continue;}
			Arrays.sort(arrays[i]);
			System.out.println(Arrays.toString(arrays[i]));
			pq.add(new Node(arrays[i][arrays[i].length-1],i,arrays[i].length-1));
		}
		for(int j=1;j<k;j++){
			Node curr = pq.poll();
			System.out.println("polling node from row: "+curr.row+" and col: "+curr.col+" with data: "+curr.data);
			if (curr.col > 0){
				Node next = new Node (arrays[curr.row][curr.col-1],curr.row,curr.col-1);
				pq.add(next);
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
		public int compareTo(Node node){
			return Integer.compare(node.data,this.data);
		}
	}
}
