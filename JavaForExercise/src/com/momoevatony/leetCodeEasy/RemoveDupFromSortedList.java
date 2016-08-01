package com.momoevatony.leetCodeEasy;

public class RemoveDupFromSortedList {
	public static class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
	
	public static void main(String args[]){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		ListNode curr = head;
		head.next.val=3;
		
		System.out.println(curr.next.val);
	}
	
	
	public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next == null){return head;}
		ListNode curr = head;
		while(curr.next != null){
			if (curr.next.val == curr.val){
				curr.next = curr.next.next;
			}
			else{
				curr = curr.next;
			}
		}
        return head;
    } 
	

}
