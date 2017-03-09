package course4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule2 {
	
	//accepted 3.8.2017 17981ms
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Write your code here
		if(numCourses==1){return new int[1];}

		int[] result = new int[numCourses];
		HashMap<Integer, ArrayList<Integer>> relation = new HashMap<>(); //relational map
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); //indegree map
		
		for(int i=0; i<prerequisites.length; i++){
			int preClass = prerequisites[i][1];
			int posClass = prerequisites[i][0];
			
			if(map.containsKey(posClass)){
				map.put(posClass,map.get(posClass)+1);
			}else{
				map.put(posClass, 1);
			}
			
			if(relation.containsKey(preClass)){
				relation.get(preClass).add(posClass);
			}else{
				ArrayList<Integer> list = new ArrayList<>();
				list.add(posClass);
				relation.put(preClass, list);
			}
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		int index=0;
		for(int i=0;i<numCourses;i++){
			if(!map.containsKey(i)){
				queue.offer(i);
			}
		}
		
		while(!queue.isEmpty()){
			int curr = queue.poll();
			result[index] = curr;
			index++;
			if(relation.containsKey(curr)){
				ArrayList<Integer> neighbors = relation.get(curr);
				for(int neighbor : neighbors){
					map.put(neighbor, map.get(neighbor)-1);
					if(map.get(neighbor)==0){
						queue.offer(neighbor);
					}
				}
			}
		}
		if(index == numCourses){return result;}
		return new int[0];
    }
}
