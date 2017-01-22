package course2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumOfAirplanes {
	
	//Accepted 12.6.2016 8278 ms
	public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
		if(airplanes.size()<=0){return 0;}
		int count = 0;
		int max = Integer.MIN_VALUE;
		List<Node> list = new ArrayList<Node>();
		for(Interval interval:airplanes){
			list.add(new Node(interval.start,true));
			list.add(new Node(interval.end,false));
		}
		Collections.sort(list);
		for(Node node:list){
			System.out.println(node.time);
			if(node.up){count++;}else{count--;}
			if(count>max){max = count;}
		}
		return max;
    }
	
	private class Node implements Comparable<Node>{
		int time;
		boolean up;
		public Node(int time, boolean up){
			this.time = time;
			this.up = up;
		}
		
		@Override
		public int compareTo(Node node){
			if(this.time<node.time){return -1;}
			else if(this.time>node.time){return 1;}
			else{
				if(this.up == true && node.up == false){return -1;}
				if(this.up == false && node.up == true){return 1;}
				return 0;
			}
		}
	}
	
	private class Interval{
		int start, end;
		Interval(int start, int end){this.start=start;this.end=end;}
	}
}
