package course4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CloneGraph {
	
	//accepted 3.8.2017 2455ms
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
		if(node == null) {return null;}
		ArrayList<UndirectedGraphNode> map = new ArrayList<>();
		//Get all nodes in the graph
		map = getAll(node);
		//Mapping old graph to new graph
		Map<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
		for(int i=0; i<map.size(); i++){
			UndirectedGraphNode curr = map.get(i);
			UndirectedGraphNode newCurr = new UndirectedGraphNode(curr.label);
			mapping.put(curr, newCurr);
		}
		//Create connections
		for(int j=0; j<map.size(); j++){
			UndirectedGraphNode curr = map.get(j);
			ArrayList<UndirectedGraphNode> neighbors = curr.neighbors;
			for(int k=0; k<neighbors.size(); k++){
				mapping.get(curr).neighbors.add(mapping.get(curr.neighbors.get(k)));
			}
		}
		return mapping.get(node);
    }
	
	private ArrayList<UndirectedGraphNode> getAll(UndirectedGraphNode node){
		ArrayList<UndirectedGraphNode> map = new ArrayList<>();
		Set<UndirectedGraphNode> added = new HashSet<>();
		map.add(node);
		added.add(node);
		int index = 0;
		while(index<map.size()){
			UndirectedGraphNode curr = map.get(index);
			for(UndirectedGraphNode neighbor : curr.neighbors){
				if(added.contains(neighbor)){continue;}
				map.add(neighbor);
				added.add(neighbor);
			}
			index++;
		}
		return map;
	}
	
	class UndirectedGraphNode {
			int label;
			ArrayList<UndirectedGraphNode> neighbors;
			UndirectedGraphNode(int x) { 
				label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
			}
	}
}
