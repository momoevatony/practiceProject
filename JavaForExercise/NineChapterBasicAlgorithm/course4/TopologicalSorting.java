package course4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TopologicalSorting {
	
	//Accepted 3.8.2017 4039ms
	public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
		ArrayList<DirectedGraphNode> list = new ArrayList<>();
		Map<DirectedGraphNode, Integer> indegree = new HashMap<DirectedGraphNode, Integer>();
		indegree = getIndegree(graph);
		
		Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
		for(DirectedGraphNode n:graph){
			if(!indegree.containsKey(n)){
				queue.offer(n);
				list.add(n);
			}
		}
		
		while(!queue.isEmpty()){
			DirectedGraphNode curr = queue.poll();
			for(DirectedGraphNode neighbor : curr.neighbors){
				indegree.put(neighbor, indegree.get(neighbor)-1);
				if(indegree.get(neighbor) == 0){
					queue.offer(neighbor);
					list.add(neighbor);
				}
			}
		}
		return list;
    }
	
	private HashMap<DirectedGraphNode, Integer> getIndegree(ArrayList<DirectedGraphNode> graph){
		HashMap<DirectedGraphNode, Integer> indegree = new HashMap<DirectedGraphNode, Integer>();
		for(DirectedGraphNode curr : graph){
			for(DirectedGraphNode neighbor : curr.neighbors){
				if(indegree.containsKey(neighbor)){
					indegree.put(neighbor, indegree.get(neighbor)+1);
				}else{
					indegree.put(neighbor, 1);
				}
			}
		}
		
		return indegree;
	}
	
	class DirectedGraphNode {
		int label;
		ArrayList<DirectedGraphNode> neighbors;
		DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
	};
}
