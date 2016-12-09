package Others;

import java.util.ArrayList;
import java.util.Collections;

public class BuildingOutlines {
	public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        // write your code here
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		if(buildings.length<=0 || buildings[0].length<=2){return list;}
		
		boolean ground = true;
		
		ArrayList<Node> nodeList = new ArrayList<Node>();
		for(int i=0;i<buildings.length;i++){
			nodeList.add(new Node(buildings[i][2],buildings[i][0],true));
			nodeList.add(new Node(buildings[i][2],buildings[i][1],false));
		}
		Collections.sort(nodeList);
		for(Node node:nodeList){
			
			if(ground && node.up){
			}
		}
		return list;
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
				return 0;
			}
		}
	}
}
