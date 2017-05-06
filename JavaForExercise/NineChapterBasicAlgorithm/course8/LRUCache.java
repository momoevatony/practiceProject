package course8;

import java.util.HashMap;
import java.util.Map;

//Accepted 5.4.2017 4754ms
public class LRUCache {
	Map<Integer, ListNode> map;
    ListNode dummyHead;
    ListNode tail;
    int size;
    int capacity;
    // @param capacity, an integer
    public LRUCache(int capacity) {
        // write your code here
        map = new HashMap<Integer, ListNode>();
        dummyHead = new ListNode(-1, -1);
        size = 0;
        this.capacity = capacity;
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        if (map.containsKey(key)) {
            moveToTail(map.get(key));
            return map.get(key).val;
        } else {
            return -1;
        }
    } 

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // write your code here
        //System.out.println("Adding: "+ key);
        if (map.containsKey(key)) {
            map.get(key).val = value;
            moveToTail(map.get(key));
        } else {
            if(tail == null) {
                tail = new ListNode(key, value);
                dummyHead.next = tail;
                tail.prev = dummyHead;
                map.put(key, tail);
            } else {
                ListNode newTail = new ListNode(key, value);
                map.put(key, newTail);
                newTail.prev = tail;
                tail.next = newTail;
                tail = newTail;
            }
            /*
            System.out.println("current list: ");
            ListNode print = dummyHead.next;
            while (print != null) {
                System.out.println(print.val);
                print = print.next;
            }
            */
            size++;
            //System.out.println("current size: "+ size);
            if (size > capacity) {
                //System.out.println("remmoving: "+dummyHead.next.val);
                map.remove(dummyHead.next.key);
                dummyHead.next = dummyHead.next.next;
                dummyHead.next.prev = dummyHead;
            }
        }
    }
    
    private void moveToTail(ListNode curr) {
        if(curr == tail) {
            return;
        } else {
            ListNode prev = curr.prev;
            ListNode next = curr.next;
            prev.next = next;
            next.prev = prev;
            
            tail.next = curr;
            curr.prev = tail;
            curr.next = null;
            tail = curr;
        }
    }
    
    private class ListNode {
        int val;
        int key;
        public ListNode next;
        public ListNode prev;
        public ListNode(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }
}
