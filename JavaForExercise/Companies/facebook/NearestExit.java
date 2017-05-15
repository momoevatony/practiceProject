package facebook;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExit {
	
	//accepted 5.14.2017
	public void wallsAndGates(int[][] rooms) {
        // Write your code here
        Queue<Node> queue = new LinkedList<Node>();
        boolean[][] map = new boolean[rooms.length][rooms[0].length];
        
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new Node(i, j));
                    map[i][j] = true;
                }
            }
        }
    
        int step = 0;
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                for (int j = 0; j < dx.length; j++) {
                    Node next = new Node(curr.row + dx[j], curr.col + dy[j]);
                    if (!isValid(rooms, next) || map[next.row][next.col]) {
                        continue;
                    }
                    if (step < rooms[next.row][next.col]) {
                        queue.offer(next);
                        map[next.row][next.col] = true;
                        rooms[next.row][next.col] = step;
                    }
                }
            }
        }
        
    }
    
    private boolean isValid(int[][]rooms, Node next) {
        if (next.row < 0 || next.col < 0 || next.row >= rooms.length || next.col >= rooms[0].length) {
            return false;
        }
        return rooms[next.row][next.col] > 0;
    }
    
    private class Node {
        int row;
        int col;
        public Node (int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
	
	//failed at 85% Time exceeded, both from gate and room.
//	public void wallsAndGates(int[][] rooms) {
//        // Write your code here
//        for (int i = 0; i < rooms.length; i++) {
//            for (int j = 0; j < rooms[0].length; j++) {
//                if (rooms[i][j] == 0) {
//                    bfs(rooms, new Node(i, j));
//                }
//            }
//        }
//    }
//    
//    private void bfs2(int[][] rooms, Node gate) {
//        Queue<Node> queue = new LinkedList<Node>();
//        boolean[][] map = new boolean[rooms.length][rooms[0].length];
//        queue.offer(gate);
//        map[gate.row][gate.col] = true;
//        int step = 0;
//        
//        int[] dx = {-1, 0, 1, 0};
//        int[] dy = {0, -1, 0, 1};
//        
//        while(!queue.isEmpty()) {
//            int size = queue.size();
//            step++;
//            for (int i = 0; i < size; i++) {
//                Node curr = queue.poll();
//                for (int j = 0; j < dx.length; j++) {
//                    Node next = new Node(curr.row + dx[j], curr.col + dy[j]);
//                    if (!isValid2(rooms, next) || map[next.row][next.col]) {
//                        continue;
//                    }
//                    if (rooms[next.row][next.col] == 0) {
//                        rooms[gate.row][gate.col] = step;
//                        return;
//                    }
//                    if (step < rooms[next.row][next.col]) {
//                        queue.offer(next);
//                        map[next.row][next.col] = true;
//                    }
//                }
//            }
//        }
//    }
//    
//    private boolean isValid2(int[][]rooms, Node next) {
//        if (next.row < 0 || next.col < 0 || next.row >= rooms.length || next.col >= rooms[0].length) {
//            return false;
//        }
//        return rooms[next.row][next.col] != -1;
//    }
//    
//    private void bfs(int[][] rooms, Node gate) {
//        Queue<Node> queue = new LinkedList<Node>();
//        boolean[][] map = new boolean[rooms.length][rooms[0].length];
//        queue.offer(gate);
//        map[gate.row][gate.col] = true;
//        int step = 0;
//        
//        int[] dx = {-1, 0, 1, 0};
//        int[] dy = {0, -1, 0, 1};
//        
//        while(!queue.isEmpty()) {
//            int size = queue.size();
//            step++;
//            for (int i = 0; i < size; i++) {
//                Node curr = queue.poll();
//                for (int j = 0; j < dx.length; j++) {
//                    Node next = new Node(curr.row + dx[j], curr.col + dy[j]);
//                    if (!isValid2(rooms, next) || map[next.row][next.col]) {
//                        continue;
//                    }
//                    if (step < rooms[next.row][next.col]) {
//                        queue.offer(next);
//                        map[next.row][next.col] = true;
//                        rooms[next.row][next.col] = step;
//                    }
//                }
//            }
//        }
//    }
//    
//    private boolean isValid(int[][]rooms, Node next) {
//        if (next.row < 0 || next.col < 0 || next.row >= rooms.length || next.col >= rooms[0].length) {
//            return false;
//        }
//        return rooms[next.row][next.col] > 0;
//    }
//    
//    private class Node {
//        int row;
//        int col;
//        public Node (int row, int col) {
//            this.row = row;
//            this.col = col;
//        }
//    }
}
