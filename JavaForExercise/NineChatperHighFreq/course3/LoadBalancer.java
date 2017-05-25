package course3;

import java.util.ArrayList;
import java.util.HashMap;

public class LoadBalancer {
	
	//accepted 5.24.2017 
	ArrayList<Integer> list;
	HashMap<Integer, Integer> map;
	
	public LoadBalancer() {
        // Initialize your data structure here.
		this.list = new ArrayList<>();
		this.map = new HashMap<>();
    }

    // @param server_id add a new server to the cluster 
    // @return void
    public void add(int server_id) {
        // Write your code here
    	list.add(server_id);
    	map.put(server_id, list.size() - 1);
    }

    // @param server_id server_id remove a bad server from the cluster
    // @return void
    public void remove(int server_id) {
        // Write your code here
    	int index = map.get(server_id);
    	int temp = list.get(list.size() - 1);
    	list.set(index, temp);
    	list.remove(list.size() - 1);
    	map.put(temp, index);
    }

    // @return pick a server in the cluster randomly with equal probability
    public int pick() {
        // Write your code here
    	return list.get((int)(Math.random() * (list.size())));
    }
}
