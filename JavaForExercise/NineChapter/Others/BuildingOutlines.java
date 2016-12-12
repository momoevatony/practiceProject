package Others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class BuildingOutlines {
	
	//Got stuck at 86% test cases. Need TODO
	public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        // write your code here
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		if(buildings.length<=0 || buildings[0].length<=2){return list;}
		
		ArrayList<Node> nodeList = new ArrayList<Node>();
		for(int i=0;i<buildings.length;i++){
			nodeList.add(new Node(buildings[i][2],buildings[i][0],true));
			nodeList.add(new Node(buildings[i][2],buildings[i][1],false));
		}
		HashHeap hashHeap = new HashHeap("max");
		int currHeight=0;
		int currX = 0;
		Collections.sort(nodeList);
		for(Node node:nodeList){
			if(node.up){
				if(node.height>currHeight){
					if(currHeight != 0){
						addToList(list,currX, node.xAxis, currHeight);
						hashHeap.add(currHeight);
					}
					currHeight = node.height;
					currX = node.xAxis;
				}else{
					hashHeap.add(node.height);
				}
			}else{
				if(node.height<currHeight || ((!hashHeap.isEmpty())&&node.height==currHeight && currHeight == hashHeap.peek()) ){
					hashHeap.delete(node.height);
				}else{
					addToList(list,currX,node.xAxis,currHeight);
					if(hashHeap.isEmpty()){currHeight = 0;}
					else{currHeight = hashHeap.poll();}
					currX = node.xAxis;
				}
			}
		}
		return list;
    }
	
	private void addToList(ArrayList<ArrayList<Integer>> list, int x, int y, int height){
	    if(x==y){return;}
		ArrayList<Integer> innerList = new ArrayList<Integer>();
		innerList.add(x);
		innerList.add(y);
		innerList.add(height);
		list.add(innerList);
	}
	
	private class Node implements Comparable<Node>{
		int height;
		int xAxis;
		boolean up;
		public Node(int height, int xAxis, boolean up){
			this.height=height;this.xAxis=xAxis;this.up=up;
		}
		
		public int compareTo(Node node){
			if(this.xAxis>node.xAxis){return 1;}
			else if(this.xAxis<node.xAxis){return -1;}
			else{
			    if(this.up && node.up){
    				if(this.height<node.height){return 1;}
    				else if(this.height>node.height){return -1;}  
			    }else if((!this.up) && (!node.up)){
    				if(this.height<node.height){return -1;}
    				else if(this.height>node.height){return 1;}     
			    }
				return 0;
			}
		}
	}
	
	public class HashHeap {
	    ArrayList<Integer> heap;
	    String mode;
	    int size_t;
	    HashMap<Integer, Node> hash;

	    class Node {
	        public Integer id;
	        public Integer num;

	        Node(Node now) {
	            id = now.id;
	            num = now.num;
	        }

	        Node(Integer first, Integer second) {

	            this.id = first;
	            this.num = second;
	        }
	    }

	    public HashHeap(String mod) {
	        heap = new ArrayList<Integer>();
	        mode = mod;
	        hash = new HashMap<Integer, Node>();
	        size_t = 0;
	    }

	    int peek() {
	        return heap.get(0);
	    }

	    int size() {
	        return size_t;
	    }

	    Boolean isEmpty() {
	        return (heap.size() == 0);
	    }

	    int parent(int id) {
	        if (id == 0) {
	            return -1;
	        }
	        return (id - 1) / 2;
	    }

	    int lson(int id) {
	        return id * 2 + 1;
	    }

	    int rson(int id) {
	        return id * 2 + 2;
	    }

	    boolean comparesmall(int a, int b) {
	        if (a <= b) {
	            if (mode == "min")
	                return true;
	            else
	                return false;
	        } else {
	            if (mode == "min")
	                return false;
	            else
	                return true;
	        }

	    }

	    void swap(int idA, int idB) {
	        int valA = heap.get(idA);
	        int valB = heap.get(idB);

	        int numA = hash.get(valA).num;
	        int numB = hash.get(valB).num;
	        hash.put(valB, new Node(idA, numB));
	        hash.put(valA, new Node(idB, numA));
	        heap.set(idA, valB);
	        heap.set(idB, valA);
	    }

	    Integer poll() {
	        size_t--;
	        Integer now = heap.get(0);
	        Node hashnow = hash.get(now);
	        if (hashnow.num == 1) {
	            swap(0, heap.size() - 1);
	            hash.remove(now);
	            heap.remove(heap.size() - 1);
	            if (heap.size() > 0) {
	                siftdown(0);
	            }
	        } else {
	            hash.put(now, new Node(0, hashnow.num - 1));
	        }
	        return now;
	    }

	    void add(int now) {
	        size_t++;
	        if (hash.containsKey(now)) {
	            Node hashnow = hash.get(now);
	            hash.put(now, new Node(hashnow.id, hashnow.num + 1));

	        } else {
	            heap.add(now);
	            hash.put(now, new Node(heap.size() - 1, 1));
	        }

	        siftup(heap.size() - 1);
	    }

	    void delete(int now) {
	        size_t--;
	        ;
	        Node hashnow = hash.get(now);
	        int id = hashnow.id;
	        int num = hashnow.num;
	        if (hashnow.num == 1) {

	            swap(id, heap.size() - 1);
	            hash.remove(now);
	            heap.remove(heap.size() - 1);
	            if (heap.size() > id) {
	                siftup(id);
	                siftdown(id);
	            }
	        } else {
	            hash.put(now, new Node(id, num - 1));
	        }
	    }

	    void siftup(int id) {
	        while (parent(id) > -1) {
	            int parentId = parent(id);
	            if (comparesmall(heap.get(parentId), heap.get(id)) == true) {
	                break;
	            } else {
	                swap(id, parentId);
	            }
	            id = parentId;
	        }
	    }

	    void siftdown(int id) {
	        while (lson(id) < heap.size()) {
	            int leftId = lson(id);
	            int rightId = rson(id);
	            int son;
	            if (rightId >= heap.size() || (comparesmall(heap.get(leftId), heap.get(rightId)) == true)) {
	                son = leftId;
	            } else {
	                son = rightId;
	            }
	            if (comparesmall(heap.get(id), heap.get(son)) == true) {
	                break;
	            } else {
	                swap(id, son);
	            }
	            id = son;
	        }
	    }
	}
}
