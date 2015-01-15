/**
 * https://oj.leetcode.com/problems/swap-nodes-in-pairs/
 * 
 * @author Ke Wang
 *
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
    	if (head == null) {
    	   return null;
    	}
       
    	ListNode sentinel = new ListNode(0);
    	sentinel.next = head;
    	ListNode last = sentinel;
    	ListNode first = sentinel;
    	ListNode second = sentinel;
       
    	while (true) {
    		first = first.next;
    		if (first == null) {
    			return sentinel.next;
    		}
    		second = first.next;
    		if (second == null) {
    			return sentinel.next;
    		}
    		
    		last.next = second;
    		first.next = second.next;
    		second.next = first;
    			
			second = first;
			last = first;
    	}
    	       
    }
}
