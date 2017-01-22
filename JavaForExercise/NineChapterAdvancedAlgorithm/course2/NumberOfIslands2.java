package course2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIslands2 {
	private class Point{
		int x;
		int y;
		Point(){x=0;y=0;}
		Point(int a, int b){x=a;y=b;}
	}
	
	
	//accepted 12.5.2016 6807ms
	public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // Write your code here
		List<Integer> list = new ArrayList<Integer>();
		if(m<=0 || n<=0 || operators.length<=0){return list;}
		boolean[][] map = new boolean[n][m];
		UnionFind uf = new UnionFind(n*m);
		int [] dx = {-1,0,1,0};
		int [] dy = {0,-1,0,1};
		for(int i=0; i<operators.length;i++){
			Point curr = operators[i];
			map[curr.x][curr.y] = true;
			for(int row=0;i<n;row++){System.out.println(Arrays.toString(map[row]));}
			for(int j=0; j<dx.length;j++){
				if(curr.x+dx[j]>=n || curr.x+dx[j]<0 || curr.y+dy[j]>=m || curr.y+dy[j]<0){continue;}
				if(map[curr.x+dx[j]][curr.y+dy[j]]){
					uf.connect(curr.x*m+curr.y, (curr.x+dx[j])*m+curr.y+dy[j]);
				}
			}
			list.add(i+1-uf.count());
		}
		
		return list;
    }
	
	private class UnionFind{
		int id[];
		int count;
		
		public UnionFind(int size){
			id = new int[size];
			for(int i=0;i<size;i++){
				id[i] = -1;
			}
			count = 0;
		}
		
		private int find(int a){
			if(id[a] == -1){return a;}
			return id[a] = find(id[a]);
		}
		
		public void connect(int a, int b){
			int ida = find(a);
			int idb = find(b);
			if(ida != idb){
				id[ida] = idb;
				System.out.println("connecting "+a+" and "+b);
				count++;
			}
		}
		
		public int count(){
			return count;
		}
	}
}
