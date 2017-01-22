package course2;

public class ConnectingGraph2 {
	
	//accepted 12.5.2016 7895ms
	int id[];
	int size[];
	
	public ConnectingGraph2(int n) {
        // initialize your data structure here.
		id = new int[n+1];
		size = new int[n+1];
		for(int i=0; i<=n;i++){
			id[i] = 0;
			size[i] = 1;
		}
    }

    public void connect(int a, int b) {
        // Write your code here
    	int ida = find(a);
    	int idb = find(b);
    	if(ida!=idb){
    		id[ida] = idb;
    		size[idb] += size[ida];
    	}
    }
        
    public int query(int a) {
        // Write your code here
    	return size[find(a)];
    }
    
    private int find(int a){
    	if(id[a] == 0){
    		return a;
    	}
    	return id[a] = find(id[a]);
    }
}
