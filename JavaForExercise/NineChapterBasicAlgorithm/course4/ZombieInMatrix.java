package course4;

import java.util.LinkedList;
import java.util.Queue;

public class ZombieInMatrix {
	//accepted 3.8.2017 7540ms
	public int zombie(int[][] grid) {
        // Write your code here
		if(grid.length==0 || grid[0].length==0){return 0;}
		int humans = 0;
		int days = 0;
		
		Queue<Node> queue = new LinkedList<Node>();
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[i].length;j++){
				if(grid[i][j] == 1){queue.offer(new Node(i,j));}
				if(grid[i][j] == 0){humans++;}
			}
		}
		if(humans==0){return 0;}
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, -1, 0, 1};
		
		while(!queue.isEmpty()){
			days++;
			int size = queue.size();
			for(int i=0; i<size; i++){
				Node curr = queue.poll();
				for(int j=0; j<dx.length; j++){
					if(isHuman(grid, curr.row+dx[j], curr.col+dy[j])){
						grid[curr.row+dx[j]][curr.col+dy[j]] = 1;
						queue.offer(new Node(curr.row+dx[j], curr.col+dy[j]));
						humans--;
						if(humans==0){return days;}
					}
				}
			}
		}
		return -1;
    }
	
	private boolean isHuman(int[][] grid, int row, int col){
		if(row<0 || row>=grid.length){return false;}
		if(col<0 || col>=grid[0].length){return false;}
		return grid[row][col] == 0;
	}
	
	private class Node{
		int row;
		int col;
		public Node (int row, int col){
			this.row = row;
			this.col = col;
		}
	}
}
