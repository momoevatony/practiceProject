package course6;

public class ReverseNodesInKGroup {
	
	//Accepted 5.1.2017 1903ms
	public ListNode reverseKGroup(ListNode head, int k) {
        // Write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        head = dummy;
        while (head != null) {
            head = reverseKNodes(head, k);
        }
        
        return dummy.next;
    }
    
    //head -> n1 -> n2 -> ... -> nk -> nPlus
    //    
    //head -> nk -> nk-1 -> ... -> n1 -> nPlus
    //return n1
    
    private ListNode reverseKNodes(ListNode head, int k) {
        ListNode n1 = head.next;
        ListNode nk = head;
        
        for (int i = 0; i < k; i++) {
            nk = nk.next;
            if (nk == null) {
               return null; 
            }
        }
    
        ListNode nPlus = nk.next;
        ListNode prev = null;
        ListNode curr = n1;
        
        while (curr != nPlus) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        head.next = nk;
        n1.next = nPlus;
        
        return n1;
    }
    
    public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
		    val = x;
		    next = null;
		}
	}
}
