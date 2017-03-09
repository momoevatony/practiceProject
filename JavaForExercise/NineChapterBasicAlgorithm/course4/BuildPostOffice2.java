package course4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BuildPostOffice2 {
	
	//Note: 3.8.2017 needs to debug, how to determine all houses could be reached???
	public int shortestDistance(int[][] grid) {
        // Write your code here
		if(grid.length == 0 || grid[0].length==0){return -1;}
		
		//Get all houses
		int candidates = 0;
		ArrayList<Point> houses = new ArrayList<>();
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[0].length; j++){
				if(grid[i][j] == 0){
					candidates++;
				}else if(grid[i][j] == 1){
					houses.add(new Point(i,j));
				}
			}
		}
		System.out.println("Find "+candidates+" available points");
		int[][] distances = new int[grid.length][grid[0].length];
		//For each house, use BFS to update the distance map
		boolean canReach = false;
		for(Point curr: houses){
			canReach = BFS(grid, distances, curr, candidates);
		}
		if(canReach){return findMin(distances);}
		return -1;
    }
	
	private boolean BFS(int[][]grid, int[][] distances, Point start, int candidates){
	    System.out.println("Analyzing "+start.x+" "+start.y);
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int visitedCandidates = 0;
		int distance = 0;
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(start);
		visited[start.x][start.y] = true;
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, -1, 0, 1};
		
		while(!queue.isEmpty()){
			int size = queue.size();
			distance++;
			for(int i=0; i<size; i++){
				Point curr = queue.poll();
				for(int j=0; j<dx.length; j++){
					Point next = new Point(curr.x+dx[j], curr.y+dy[j]);
					if(!validPoint(grid, next) || visited[next.x][next.y]){continue;}
					queue.offer(next);
					visited[next.x][next.y] = true;
					distances[next.x][next.y] += distance;
					visitedCandidates++;
					System.out.println("To "+next.x+" "+next.y+" is "+distance);
				}
			}
		}
		return visitedCandidates == candidates;
	}
	
	private int findMin(int[][] distances){
		int min = Integer.MAX_VALUE;
		for(int i = 0; i<distances.length; i++){
			for(int j = 0; j<distances[0].length; j++){
				if(distances[i][j] > 0){min = min<distances[i][j]?min:distances[i][j];}
			}
		}
		return min;
	}
	
	private boolean validPoint(int[][]grid, Point curr){
		return (curr.x>=0 && curr.x<grid.length && curr.y>=0 && curr.y<grid[0].length && grid[curr.x][curr.y] != 2);
	}
	
	
	private class Point{
		int x;
		int y;
		public Point(int x, int y){this.x = x; this.y = y;}
	}
}
