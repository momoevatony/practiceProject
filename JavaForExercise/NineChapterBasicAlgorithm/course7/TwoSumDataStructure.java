package course7;

import java.util.HashMap;

public class TwoSumDataStructure {
	//Accepted 5.2.2017, 2904ms
	private HashMap<Integer, Integer> map = new HashMap<>();

	public void add(int number) {
		// Write your code here
		if (map.containsKey(number)) {
			map.put(number, map.get(number) + 1);
		} else {
			map.put(number, 1);
		}
	}

	// Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
		// Write your code here
		for (int curr : map.keySet()) {
			if (map.containsKey(value - curr)) {
				if (curr == value - curr) {
					if (map.get(curr) > 1) {
						return true;
					} else {
						continue;
					}
				}
				return true;
			}
		}
		return false;
	}
}
