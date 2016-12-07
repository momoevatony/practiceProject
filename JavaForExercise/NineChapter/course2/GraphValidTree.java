package course2;

public class GraphValidTree {
	
	//Accetped 12.6.2016 12524ms
	public boolean validTree(int n, int[][] edges) {
        // Write your code here
		if(n>edges.length+1){return false;}
		
		UnionFind uf = new UnionFind(n);
		for(int i=0; i<edges.length; i++){
			if(uf.connected(edges[i][0], edges[i][1])){return false;}
			uf.connect(edges[i][0], edges[i][1]);
		}
		
		return true;
    }
	private class UnionFind{
		int id[];
		int count;
		
		public UnionFind(int size){
			id = new int[size];
			count = size;
			for(int i=0; i<size; i++){
				id[i] = -1;
			}
		}
		
		private int find(int a){
			if(id[a] == -1){return a;}
			return id[a] = find(id[a]);
		}
		
		public void connect (int a, int b){
			int ida = find(a);
			int idb = find(b);
			if(ida!=idb){
				id[ida] = idb;
				count--;
			}
		}
		
		public boolean connected (int a, int b){
			return find(a) == find(b);
		}
	}
}
