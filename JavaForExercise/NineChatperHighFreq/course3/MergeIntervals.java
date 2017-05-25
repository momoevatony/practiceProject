package course3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	
	//accepted 5.23.2017
	public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        List<Interval> list = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return list;
        }
        
        Collections.sort(intervals, new IntervalComparator());
        
        Interval curr = intervals.get(0);
        
        for (int i = 1; i < intervals.size(); i++) {
            Interval next = intervals.get(i);
            if (next.start <= curr.end) {
                curr.end = next.end > curr.end ? next.end : curr.end;
            } else {
                list.add(curr);
                curr = next;
            }
        }
        
        list.add(curr);
        
        return list;
    }
    
    private class IntervalComparator implements Comparator<Interval> {
        public int compare (Interval a, Interval b) {
            return a.start - b.start;
        }
    }
	
	public class Interval {
		int start, end;
		 Interval(int start, int end) {
			 this.start = start;
			 this.end = end;
		 }
	}
}
