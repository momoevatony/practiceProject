package course6;

import java.util.HashMap;

public class CopyListWithRandomPointer {
	
	//both ways accepted 3.15.2017
	
	//Use O(n) extra space, a map
	public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
		if(head == null) {return head;}
		
		HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode curr = head;
		while(curr != null) {
			RandomListNode newCurr = new RandomListNode(curr.label);
			map.put(curr, newCurr);
			curr = curr.next;
		}
		curr = head;
		while(curr != null) {
			map.get(curr).next = map.get(curr.next);
			map.get(curr).random = map.get(curr.random);
			curr=curr.next;
		}
		
		return map.get(head);
    }
	
	//Do it in space
	public RandomListNode copyRandomList2(RandomListNode head) {
        // write your code here
		if(head == null) {return head;}
		//1. insert new nodes
		insertNodes(head);
		//2. point random of new nodes
		pointRandom(head);
		//3. break the list
		return breakList(head);
    }
	
	private void insertNodes(RandomListNode curr) {
		while(curr != null) {
			RandomListNode newCurr = new RandomListNode(curr.label);
			newCurr.next = curr.next;
			curr.next = newCurr;
			curr = curr.next.next;
		}
	}
	
	private void pointRandom(RandomListNode curr) {
		while(curr !=null) {
		    if(curr.random == null) {
		        curr.next.random = null;
		    } else {
			    curr.next.random = curr.random.next;
		    }
			curr = curr.next.next;
		}
	}
	private RandomListNode breakList(RandomListNode head) {
		RandomListNode curr = head.next;
		while(curr.next != null) {
			curr.next = curr.next.next;
			curr = curr.next;
		}
		return head.next;
	}
	
	class RandomListNode {
	    int label;
	    RandomListNode next, random;
	    RandomListNode(int x) { this.label = x; }
	}
}
