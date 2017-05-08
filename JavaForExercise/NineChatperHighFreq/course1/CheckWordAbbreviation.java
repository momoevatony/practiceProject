package course1;

public class CheckWordAbbreviation {
	
	//accepted 5.7.2017 10995ms
	public boolean validWordAbbreviation(String word, String abbr) {
        // Write your code here
        if (word.length() <= 1) {
            return (abbr.equals("1") || word.equals(abbr));
        }
        int j = 0;
        for (int i = 0; i < abbr.length(); i++) {
            if (abbr.charAt(i) == '0') {
                return false;
            }
            if (abbr.charAt(i) >= '1' && abbr.charAt(i) <= '9') {
                int curr = 0;
                while(i < abbr.length() && abbr.charAt(i) >= '0' && abbr.charAt(i) <= '9') {
                    curr += curr * 9 + (abbr.charAt(i) - '0');
                    i++;
                }
                j += curr;
            }
            if (i == abbr.length()) {
                if (j != word.length()) {
                    return false;
                }
            } else {
                if (word.charAt(j) != abbr.charAt(i)) {
                    return false;
                }
            }
            j++;
        }
        
        return true;
    }
}
