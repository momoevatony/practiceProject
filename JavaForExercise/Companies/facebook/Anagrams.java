package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
	
	//accepted 5.12.2017 3208ms
	public List<String> anagrams(String[] strs) {
        // write your code here
		List<String> list = new ArrayList<>();
		Map<String, ArrayList<String>> map = new HashMap<>();
		
		for (String str : strs) {
			String sorted = sortString(str);
			if (!map.containsKey(sorted)) {
				map.put(sorted, new ArrayList<String>());
			}
			map.get(sorted).add(str);
		}
		
		for (String key : map.keySet()) {
			if (map.get(key).size() > 1) {
				for (String value : map.get(key)) {
					list.add(value);
				}
			}
		}
		
		return list;
    }
	
	private String sortString (String str) {
		char[] charSet = str.toCharArray();
		Arrays.sort(charSet);
		return new String(charSet);
	}
}
