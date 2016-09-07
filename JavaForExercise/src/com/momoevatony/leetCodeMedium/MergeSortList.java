package com.momoevatony.leetCodeMedium;


public class MergeSortList {
	
	
	//Accepted 8.30.2016
	public ListNode sortList(ListNode head) {
		
		if(head == null || head.next == null){return head;}
		
		ListNode slow = head;
		ListNode fast = head;
		ListNode midEnd = head;
		
		while(fast!=null && fast.next!=null){
			midEnd = slow;
			slow = slow.next;
			fast= fast.next.next;
		}
		midEnd.next = null;
		
		head = sortList(head);
		slow = sortList(slow);
		head = mergeList(head, slow);
		
        return head;
    }
	
	public ListNode mergeList(ListNode node1, ListNode node2){
		ListNode head = new ListNode(0);
		ListNode curr = head;
		ListNode node1Ptr = node1;
		ListNode node2Ptr = node2;
		while(node1Ptr!=null && node2Ptr!=null){
			if(node1Ptr.val<node2Ptr.val){
				curr.next = node1Ptr;
				node1Ptr=node1Ptr.next;
			}else{
				curr.next = node2Ptr;
				node2Ptr=node2Ptr.next;
			}
			curr=curr.next;
		}
		if(node1Ptr == null){
			curr.next = node2Ptr;
		}else{
			curr.next = node1Ptr;
		}
		
		return head.next;
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
