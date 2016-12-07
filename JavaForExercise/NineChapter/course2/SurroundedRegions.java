package course2;

import java.util.ArrayList;
import java.util.List;

public class SurroundedRegions {
	
	
	//Accepted 12.6.2016 BFS 7743ms
	public void surroundedRegions(char[][] board) {
        // Write your code here
		if(board.length<=2 || board[0].length<=2){return;}
		boolean[][] map = new boolean[board.length][board[0].length];
		for(int i=0;i<board.length;i+= (board.length-1)){
			for(int j=0;j<board[0].length;j++){
				if(board[i][j] == 'O'){
					map[i][j] = true;
					BFS(board,i,j,map);
				}
			}
		}
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board.length;j+= (board[0].length-1)){
				if(board[i][j] == 'O'){
					map[i][j] = true;
					BFS(board,i,j,map);
				}
			}
		}
		
		for(int i=0;i<board.length;i++){
			for(int j=0; j<board[0].length;j++){
				if(board[i][j] == 'O' && !map[i][j]){board[i][j]='X';}
			}
		}
    }
	
	private void BFS(char[][] board, int row, int col, boolean[][] map){
		List<Node> list = new ArrayList<Node>();
		list.add(new Node(row,col));
		int[] dx = {-1,0,1,0};
		int[] dy = {0,-1,0,1};
		int index = 0;
		while(index<list.size()){
			Node curr = list.get(index);
			System.out.println("working on: "+curr.row+" ,"+curr.col);
			for(int i=0;i<dx.length;i++){
				if(curr.row+dx[i]<0||curr.row+dx[i]>=board.length||curr.col+dy[i]<0||curr.col+dy[i]>=board[0].length|| map[curr.row+dx[i]][curr.col+dy[i]]){continue;}
				if(board[curr.row+dx[i]][curr.col+dy[i]]=='O'){
					map[curr.row+dx[i]][curr.col+dy[i]] = true;
					list.add(new Node(curr.row+dx[i],curr.col+dy[i]));
				}
			}
			index++;
		}
	}
	
	private class Node{
		int row;
		int col;
		public Node(int row, int col){
			this.row=row;this.col=col;
		}
	}
	
	public void surroundedRegions2(char[][] board) {
		UnionFind uf = new UnionFind(board.length*board[0].length);
		for(int i=0;i<board.length;i+=(board.length-1)){
			for(int j=0;j<board[0].length;j++){
				uf.setEdge(i*(board[0].length)+j+1);
			}
		}
		
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j+=(board[0].length-1)){
				uf.setEdge(i*(board[0].length)+j+1);
			}
		}
		int[] dx = {-1,0,1,0};
		int[] dy = {0,-1,0,1};
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if(board[i][j] == 'O'){
					for(int k=0;k<dx.length;k++){
						if(i+dx[k]<0||i+dx[k]>=board.length||j+dy[k]<0||j+dy[k]>=board[0].length){continue;}
						if(board[i+dx[k]][j+dy[k]] == 'O'){
							uf.connect(i*(board[0].length)+j+1,(i+dx[k])*(board[0].length)+j+dy[k]+1);
						}
					}
				}
			}
		}
		
		for(int i=0; i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if(board[i][j] == 'O'){
					if(!uf.edge(i*(board[0].length)+j+1)){board[i][j]='X';}
				}
			}
		}
		
	}
	
	private class UnionFind{
		int id[];
		boolean edge [];
		
		public UnionFind(int size){
			id = new int[size+1];
			edge = new boolean[size+1];
			for(int i=0;i<=size;i++){
				id[i] = 0;
				edge[i] = false;
			}
		}
		
		public int find(int a){
			if(id[a] == 0){
				return a;
			}
			return id[a] = find(id[a]);
		}
		
		public void setEdge(int a){
			int ida = find(a);
			edge[ida] = true;
		}
		
		public boolean edge(int a){
			return edge[find(a)];
		}
		
		public void connect (int a, int b){
			int ida = find(a);
			int idb = find(b);
			if(ida!=idb){
				id[ida] = idb;
			}
		}
	}
}
