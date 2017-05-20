package course1_string;

public class LongestCommonPrefix {
	
	//accepted 5.19.2017 2474ms
	public String longestCommonPrefix(String[] strs) {
        // write your code here
        if (strs == null || strs.length == 0) {
            return "";
        }
        String first = strs[0];
        if (first == null || first.length() == 0) {
            return "";
        }
        Trie head = new Trie(' ');
        constructTrie(first, head);
        
        for (int i = 1; i < strs.length; i++) {
            String curr = strs[i];
            if (curr == null || curr.length() == 0) {
                return "";
            }
            
            Trie dummy = head.next;
            
            if (curr.charAt(0) != dummy.data) {
                return "";
            }
            
            for (int j = 1; j < curr.length(); j++) {
                char ch = curr.charAt(j);
                if (dummy.next == null) {
                    break;
                } else if (ch != dummy.next.data) {
                    dummy.next = null;
                    break;
                } else {
                    dummy = dummy.next;
                }
            }
        }
            
        StringBuilder sb = new StringBuilder();
        head = head.next;
        while (head != null) {
            sb.append(head.data);
            head = head.next;
        }
        
        return sb.toString();
    }
    
    private void printTrie(Trie head) {
        Trie dummy = head;
        while (dummy != null) {
            System.out.println(dummy.data);
            dummy = dummy.next;
        }
    }
    
    private void constructTrie(String first, Trie head) {
        Trie dummy = head;
        for (char ch : first.toCharArray()) {
            Trie next = new Trie(ch);
            dummy.next = next;
            dummy = next;
        }
    }
    
    private class Trie {
        char data;
        Trie next;
        public Trie (char data) {
            this.data = data;
        }
    }
}
