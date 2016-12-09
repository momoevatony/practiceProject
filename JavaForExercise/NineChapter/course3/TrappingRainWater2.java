package course3;

import java.util.PriorityQueue;

public class TrappingRainWater2 {
	
	//Accepted 12.8.2016 2141ms
	public int trapRainWater(int[][] heights) {
        // write your code here
		if(heights==null||heights.length <=2 || heights[0].length<=2){return 0;}
		int area = 0;
		boolean[][]map=new boolean[heights.length][heights[0].length];
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		for(int i=0;i<heights.length;i++){
			for(int j=0;j<heights[0].length;j+=heights[0].length-1){
				pq.add(new Node(i,j,heights[i][j]));
				map[i][j]=true;
			}
		}
		
		for(int i=0;i<heights.length;i+=heights.length-1){
			for(int j=1;j<heights[0].length-1;j++){
				pq.add(new Node(i,j,heights[i][j]));
				map[i][j]=true;
			}
		}
		
		int [] dx = {-1,0,1,0};
		int [] dy = {0,-1,0,1};
		
		while(!pq.isEmpty()){
			Node curr = pq.poll();
			for(int i=0;i<dx.length;i++){
				if(curr.row+dx[i]<=0||curr.row+dx[i]>=heights.length-1||curr.col+dy[i]<=0||curr.col+dy[i]>=heights[0].length-1||map[curr.row+dx[i]][curr.col+dy[i]]){continue;}
				Node next = new Node(curr.row+dx[i],curr.col+dy[i],heights[curr.row+dx[i]][curr.col+dy[i]]);
				if(next.height<curr.height){
					area+=curr.height-next.height;
					next.height=curr.height;
				}
				pq.add(next);
				map[next.row][next.col] = true;
			}
		}
		
		return area;
    }
	
	private class Node implements Comparable<Node>{
		int row;
		int col;
		int height;
		
		public Node(int row, int col, int height){
			this.row=row;
			this.col=col;
			this.height=height;
		}
		
		public int compareTo(Node node){
			if(this.height<node.height){return -1;}
			if(this.height>node.height){return 1;}
			return 0;
		}
		
	}
}
