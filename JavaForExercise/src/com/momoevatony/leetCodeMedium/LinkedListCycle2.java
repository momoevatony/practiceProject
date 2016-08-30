package com.momoevatony.leetCodeMedium;

public class LinkedListCycle2 {
	
	//Accepted 8.29.2016
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {return null;}
		
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				ListNode node1 = head;
				ListNode node2 = slow;
				while(node1!=node2){
					node1=node1.next;
					node2=node2.next;
				}
				return node1;
			}
		}
		
        return null;
    }
	
	class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
}
