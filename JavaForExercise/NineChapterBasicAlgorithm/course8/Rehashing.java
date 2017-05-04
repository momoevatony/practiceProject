package course8;

public class Rehashing {
	
	//Accepted 5.3.2017 2308ms
	public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        
        //1. double the size
        ListNode[] newTable = new ListNode[hashTable.length * 2];
        
        //2. loop through original table
        for (ListNode curr : hashTable) {
            
            //2.2 inside loop, rehash each ListNode
            ListNode head = curr;
            while (head != null) {
                addNode(newTable, head);
                head = head.next;
            }
        }
        
        return newTable;
    }
    
    private void addNode (ListNode[] hashTable, ListNode node) {
        //System.out.println("adding " + node.val + " to new table.");
        ListNode head = hashTable[ (node.val % hashTable.length + hashTable.length) % hashTable.length];
        if (head == null) {
            hashTable[ (node.val % hashTable.length + hashTable.length) % hashTable.length] = new ListNode(node.val);
            return;
        }
        while(head.next != null) {
            head = head.next;
        }
        head.next = new ListNode(node.val);
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
