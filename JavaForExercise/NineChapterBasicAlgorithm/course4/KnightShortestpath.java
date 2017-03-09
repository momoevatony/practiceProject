package course4;

import java.util.LinkedList;
import java.util.Queue;

public class KnightShortestpath {
	
	//accepted 3.8.2017 8528ms
	public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // Write your code here
		if(samePoint(source, destination)){return 0;}
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(source);
		
		int moves = 0;
		int[] dx = {1,1,-1,-1,2,2,-2,-2};
		int[] dy = {2,-2,2,-2,1,-1,1,-1};
		while(!queue.isEmpty()){
			int size = queue.size();
			moves++;
			for(int k=0; k<size; k++){
				Point curr = queue.poll();
				for(int i=0; i<dx.length; i++){
					int row = curr.x+dx[i];
					int col = curr.y+dy[i];
					Point next = new Point(row,col);
					if(!validMove(grid,next) || visited[row][col]){continue;}
					if(samePoint(next, destination)){return moves;}
					queue.offer(next);
					visited[row][col] = true;
				}
			}
		}
		
		return -1;
    }
	
	private boolean samePoint(Point a, Point b){
		return(a.x==b.x && a.y==b.y);
	}
	
	private boolean validMove(boolean[][]grid, Point a){
		return (a.x>=0 && a.x<grid.length && a.y>=0 && a.y<grid[0].length && grid[a.x][a.y]==false);
	}

	
	public class Point {
	    public int x, y;
		public Point() { x = 0; y = 0; }
		public Point(int a, int b) { x = a; y = b; }
	}
}
