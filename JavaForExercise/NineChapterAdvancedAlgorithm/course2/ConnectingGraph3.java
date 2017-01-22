package course2;

public class ConnectingGraph3 {
	
	//accepted 12.5.2016 7452ms
	int id[];
	int count;
	
	public ConnectingGraph3(int n) {
        // initialize your data structure here.
		count = n;
		id = new int[n+1];
		for(int i=0;i<=n;i++){
			id[i] = 0;
		}
    }

    public void connect(int a, int b) {
        // Write your code here
    	int ida = find(a);
    	int idb = find(b);
    	if(ida != idb){
    		id[ida] = idb;
    		count--;
    	}
    }
        
    public int query() {
        // Write your code here
    	return count;
    }
    
    private int find(int a){
    	if(id[a]==0){return a;}
    	return id[a] = find(id[a]);
    }
    
}
