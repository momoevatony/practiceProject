package course2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ConnectedCompInUndirectedGraph {
	
	public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		UnionFind uf = new UnionFind(nodes);
		for (int i=0; i<nodes.size();i++){
			UndirectedGraphNode curr = nodes.get(i);
			for(int j=0; j<curr.neighbors.size();j++){
				uf.connect(curr.label, curr.neighbors.get(j).label);
			}
		}
		
		return uf.getList();
    }
	
	private class UnionFind{
		//int[] id;
		HashMap<Integer, Integer> id;
		HashMap<Integer, List<Integer>> map;
		public UnionFind(ArrayList<UndirectedGraphNode> nodes){
			int size = nodes.size();
			id = new HashMap<Integer, Integer>();
			map = new HashMap<Integer, List<Integer>>();
			for(int i=0; i<size;i++){
				List<Integer> list = new ArrayList<Integer>();
				list.add(nodes.get(i).label);
				map.put(nodes.get(i).label,list);
			}
		}
		
		private int find (int a){
			if(!id.containsKey(a)){
				return a;
			}
			int root = a;
			while(id.containsKey(root)){
				root=id.get(root);
			}
			int father = a;
			while(father!=root){
				int tmp = father;
				father=id.get(father);
				id.put(tmp,root);
			}
			return id.get(a);
		}
		
		public void connect (int a, int b){
			int ida = find(a);
			int idb = find(b);
			try{
				if(ida!=idb){
					id.put(idb, ida);
					List<Integer> lista = map.get(ida);
					List<Integer> listb = map.get(idb);
					lista.addAll(listb);
					map.put(ida,lista);
					map.remove(idb);
				}
			}catch (Exception e){e.printStackTrace();System.out.println("ida: "+ida+" idb: "+idb);}
		}
		
		public List<List<Integer>> getList(){
			List<List<Integer>> list = new ArrayList<List<Integer>>();
			Iterator it = map.entrySet().iterator();
			while (it.hasNext()){
				Map.Entry pair = (Map.Entry)it.next();
				List<Integer> innerList = (ArrayList<Integer>)pair.getValue();
				Collections.sort(innerList);
				list.add(innerList);
			}
			return list;
		}
	}
	
	class UndirectedGraphNode {
		      int label;
		      ArrayList<UndirectedGraphNode> neighbors;
		      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
		  }
}
