package course3;

import java.util.ArrayList;

public class InsertIntervals {
	
	//accepted 5.23.2017 3378ms
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        // write your code here
        int insertPos = 0;
        for (int i = 0; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (curr.end < newInterval.start) {
                result.add(curr);
                insertPos++;
            } else if (curr.start > newInterval.end) {
                result.add(curr);
            } else {
                newInterval.start = Math.min(curr.start, newInterval.start);
                newInterval.end = Math.max(curr.end, newInterval.end);
            }
        }
        
        result.add(insertPos, newInterval);
        
        return result;
    }
	
	public class Interval {
		int start, end;
		 Interval(int start, int end) {
			 this.start = start;
			 this.end = end;
		 }
	}
}
