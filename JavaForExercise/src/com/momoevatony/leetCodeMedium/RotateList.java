package com.momoevatony.leetCodeMedium;

public class RotateList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	//Accepted 7.29.2016
	public ListNode rotateRight(ListNode head, int k) {
		if(head == null){return null;}
        if(k==0 || head.next==null){return head;}
		ListNode fast = head;
		ListNode slow = head;
		for(int i=1;i<=k;i++){
			fast = fast.next;
			if(fast == null){fast=head;}
		}
		while(fast.next!=null){
			fast = fast.next;
			slow = slow.next;
		}
		
		fast.next = head;
		ListNode newHead=slow.next;
		slow.next = null;
		
        return newHead;
    }
}
