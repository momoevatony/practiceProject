package course5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder2 {
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here 
		List<List<String>> list = new ArrayList<>();
		List<String> innerList = new ArrayList<>();
		
		if(start == null || start.length() == 0 || end == null || end.length() == 0) {
			return list;
		}
		if (start.equals(end)) {
			innerList.add(start); list.add(innerList);
			return list;
		}
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		createMap(start, end, dict, map);
		if(!map.containsKey(start)) {return list;}
		int startDegree = map.get(start);
		
		return list;
    }
	
	private void createMap(String start, String end, Set<String> dict, Map<String, Integer> map) {
		Queue<String> queue = new LinkedList<String>();
		Set<String> added = new HashSet<String>();
		queue.offer(end);
		int degree = 0;
		map.put(end, degree);
		
		while(!queue.isEmpty()) {
			degree++;
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				String curr = queue.poll();
				
				for(int index = 0; index < curr.length() ; index++) {
					for( char ch = 'a'; ch <= 'z'; ch++) {
						String next = curr.substring(0, index) + ch + curr.substring(index + 1,curr.length());
						if(added.contains(next)) {continue;}
						if(next.equals(end)) {
							map.put(next, degree);
							added.add(next);
							System.out.println("found end point: "+next+" with degree: "+degree);
							break;
						}
						if(dict.contains(next)) {
							queue.offer(next);
							map.put(next, degree);
							added.add(next);
							System.out.println("found: "+next+" with degree: "+degree);
						}
					}
				}
			}
		}
	}
	
	private void getPaths(String start, String end, Set<String> dict) {
		
	}
	
}
