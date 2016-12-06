package course2;

public class ConnectingGraph {
	
	//accetped 12.5.2016 7861ms
	int[] id;
	
	public ConnectingGraph(int n) {
        // initialize your data structure here.
		this.id = new int[n+1];
		for(int i=0; i<=n;i++){
			id[i] =0;
		}
    }

    public void connect(int a, int b) {
        // Write your code here
    	int ida = find(a);
    	int idb = find(b);
    	if(ida!=idb){
    		id[ida] = idb;
    	}
    }
        
    public boolean  query(int a, int b) {
        // Write your code here
    	return find(a) == find(b);
    }
    
    private int find (int a){
    	if (id[a] ==0){
    		return a;
    	}
    	return id[a] = find(id[a]);
    }
}
