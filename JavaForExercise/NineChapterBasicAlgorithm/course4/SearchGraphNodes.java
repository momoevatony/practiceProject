package course4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SearchGraphNodes {
	
	//accepted 3.8.2017
	public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph, 
										  Map<UndirectedGraphNode, Integer> values, 
										  UndirectedGraphNode node, int target) {
		// Write your code here
		if(values.get(node) == target){return node;}
		
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
		queue.offer(node);
		visited.add(node);
		
		while(!queue.isEmpty()){
			UndirectedGraphNode curr = queue.poll();
			if(values.get(curr) == target){return curr;}
			for(UndirectedGraphNode neighbor:curr.neighbors){
				if(visited.contains(neighbor)){continue;}
				queue.offer(neighbor);
				visited.add(neighbor);
			}
		}
		
		return null;
	}
	
	class UndirectedGraphNode {
		int label;
		ArrayList<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) { 
			label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
		}
}
}
