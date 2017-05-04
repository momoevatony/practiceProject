package course8;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

public class HighFive {
	
	//Accepted 5.3.2017 9604ms
	public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (Record record : results) {
            int id = record.id;
            if (map.containsKey(id)) {
                map.get(id).add(record.score);
                if(map.get(id).size() > 5) {
                    map.get(id).poll();
                }
            } else {
                PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
                heap.add(record.score);
                map.put(id, heap);
            }
        }
        
        Map<Integer, Double> ans = new HashMap<>();
        
        for (Integer key : map.keySet()) {
            ans.put(key, getAvg(map.get(key)));
        }
        
        return ans;
    }
    
    private double getAvg(PriorityQueue<Integer> heap) {
        double sum = 0.0;
        Iterator<Integer> iter = heap.iterator();
        while (iter.hasNext()) {
            sum += iter.next();
        }
        return sum / heap.size();
    }
    
	class Record {
		public int id, score;

		public Record(int id, int score) {
			this.id = id;
			this.score = score;
		}
	}
}
