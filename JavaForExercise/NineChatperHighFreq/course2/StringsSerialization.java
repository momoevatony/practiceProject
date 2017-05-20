package course2;

import java.util.ArrayList;
import java.util.List;

public class StringsSerialization {
	
	//accepted 5.8.2017 3995ms
	public String encode(List<String> strs) {
        // Write your code here
        StringBuilder sb = new StringBuilder();
        for (String curr : strs) {
            if (curr.indexOf(":") >= 0) {
                for (char ch : curr.toCharArray()) {
                    sb.append(ch);
                    if (ch == ':') {
                        sb.append(':');
                    }
                }
            } else {
                sb.append(curr);
            }
            sb.append(":");
        }
        return sb.toString();
    }

    /**
     * @param str a string
     * @return dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // Write your code here
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ':') {
                if (i == str.length() - 1) {
                    list.add(sb.toString());
                } else if (str.charAt(i + 1) == ':') {
                    sb.append(":");
                    i++;
                } else {
                    list.add(sb.toString());
                    sb = new StringBuilder();
                }
            } else {
                sb.append(ch);
            }
        }
        
        return list;
    }
}
