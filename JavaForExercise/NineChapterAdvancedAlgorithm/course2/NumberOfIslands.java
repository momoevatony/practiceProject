package course2;

import java.util.List;
import java.util.ArrayList;

public class NumberOfIslands {
	
	//BFS Accepted 12.5.2016 10791 ms
	public int numIslands(boolean[][] grid) {
        // Write your code here
		if(grid.length == 0 || grid[0].length==0){return 0;}
		int count = 0;
		boolean [][] visit = new boolean[grid.length][grid[0].length];
		for(int row = 0; row<grid.length;row++){
			for(int col=0; col<grid[0].length;col++){
				if(!visit[row][col] && grid[row][col]){
					List<Node> list = new ArrayList<Node>();
					list.add(new Node(row,col));
					visit[row][col] = true;
					int index = 0;
					int[] dx = {-1,0,1,0};
					int[] dy = {0,-1,0,1};
					while(index<list.size()){
						Node curr = list.get(index);
						for(int i=0;i<dx.length;i++){
							Node next = new Node(curr.row+dx[i], curr.col+dy[i]);
							if(next.row<grid.length && next.row >= 0 && next.col<grid[0].length && next.col >= 0 && !visit[next.row][next.col] && grid[next.row][next.col]){
								list.add(next);
								visit[next.row][next.col] = true;
							}
						}
						index++;
					}
					count ++;
				}
			}
		}
		return count;
    }
	
	private class Node{
		int row;
		int col;
		public Node(int row, int col){
			this.row = row;
			this.col = col;
		}
	}
	
	//accepted 12.5.2016 10770ms
	public int numIslands2(boolean[][] grid){
		if(grid.length==0 || grid[0].length ==0){return 0;}
		UnionFind uf = new UnionFind(grid);
		int total = 0;
		int[] dx = {-1,0,1,0};
		int[] dy = {0,-1,0,1};
		
		for(int row=0;row<grid.length;row++){
			for (int col=0;col<grid[0].length;col++){
				if(grid[row][col]){ 
					total++;
					for (int i=0; i<dx.length;i++){
						if(row+dx[i]<0 || row+dx[i]>=grid.length || col+dy[i]<0 || col+dy[i]>=grid[0].length){continue;}
						if(grid[row+dx[i]][col+dy[i]]){
								uf.connect(row*grid[0].length+col, (row+dx[i])*grid[0].length+col+dy[i]);
						}
					}
				}
			}
		}
		
		return total-uf.count();
	}
	
	private class UnionFind{
		int[] id;
		int count;
		public UnionFind(boolean[][] grid){
			int size = grid.length * grid[0].length;
			this.id = new int[size];
			this.count = 0;
			for(int i=0; i<size; i++){
				id[i] = -1;
			}
		}
		
		public void connect(int a, int b){
			int ida = find(a);
			int idb = find(b);
			if(ida != idb){
				id[ida] = idb;
				count++;
			}
		}
		
		private int find (int a){
			if(id[a] == -1){return a;}
			return id[a]=find(id[a]);
		}
		public int count (){
			return count;
		}
	}
	
	
}
