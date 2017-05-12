package amazon;

import java.util.LinkedList;
import java.util.Queue;

public class KnightShortestPath2 {
	
	//90% passed. Need to double check. Official answer is not correct.
	public int shortestPath2(boolean[][] grid) {
        // Write your code here
        if (grid.length == 1 && grid[0].length == 1) {
            return 1;
        }
        
        boolean[][] map = new boolean[grid.length][grid[0].length];
        
        int step = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));
        map[0][0] = true;
        
        int[] dx = {1, -1, 2, -2};
        int[] dy = {2, 2, 1, 1};
        
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int j = 0; j < size; j++){
                Node curr = queue.poll();
                for (int i = 0; i < dx.length; i++) {
                    Node next = new Node(curr.row + dx[i], curr.col + dy[i]);
                    
                    if (next.row == grid.length - 1 && next.col == grid[0].length - 1) {
                        return step;
                    }
                    if (isValid(grid, next) && !map[next.row][next.col]) {
                        queue.offer(next);
                        map[next.row][next.col] = true;
                    }
                }
            }
        }
        
        return -1;
    }
    
    private boolean isValid(boolean[][] grid, Node next) {
        if (next.row < 0 || next.col < 0) {
            return false;
        }
        
        return next.row < grid.length && next.col < grid[0].length && !grid[next.row][next.col];
    }
    
    private class Node {
        int row;
        int col;
        public Node (int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
