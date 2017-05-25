package course3;

import java.util.ArrayList;
import java.util.List;

public class MissingIntervals {
	
	/*
	 * Given nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99
	 *	return ["2", "4->49", "51->74", "76->99"].
	 */
	
	//accepted 5.24.2017 10495ms
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        // Write your code here
		List<String> list = new ArrayList<String>();
		if (lower == upper) {
		    if (nums.length == 0) {
		        addInterval(list, lower, upper);
		    }
		    return list;
		}
		
		for (int i = 0; i < nums.length; i++) {
			int curr = nums[i];
			if (curr == upper) {
				addInterval(list, lower, upper - 1);
			} else if (curr > lower) {
				addInterval(list, lower, curr - 1);
			}
			if (curr == Integer.MAX_VALUE) {
			    return list;
			}
			lower = curr + 1;
		}
		addInterval(list, lower, upper);
		
		return list;
    }
	
	private void addInterval (List<String> list, int lower, int upper) {
		if (lower > upper) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		if (lower == upper) {
			sb.append(lower);
		} else {
			sb.append(lower);
			sb.append("->");
			sb.append(upper);
		}
		list.add(sb.toString());
	}
}
