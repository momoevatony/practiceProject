package com.momoevatony.leetCodeMedium;

public class PartitionList {
	
	//Accepted 7.31.2016
	public ListNode partition(ListNode head, int x) {
		if (head==null || head.next == null){return head;}

		ListNode smallHead = new ListNode(0);
		ListNode largeHead = new ListNode(0);
		ListNode small = smallHead;
		ListNode large = largeHead;
		ListNode curr = head;
		boolean noSmall = true;
		boolean noLarge = true;
		while(curr!=null){
			if(curr.val<x){
			    noSmall = false;
				small.next = new ListNode(curr.val);
				small=small.next;
			}else{
			    noLarge = false;
				large.next = new ListNode(curr.val);
				large=large.next;
			}
			curr=curr.next;
		}
		if(noLarge){return smallHead.next;}
		if(noSmall){return largeHead.next;}
		small.next = largeHead.next;
		
		return smallHead.next;
    }
	
	public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
