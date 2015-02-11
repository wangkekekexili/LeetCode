/**
 * https://oj.leetcode.com/problems/partition-list/
 * 
 * @author Ke Wang
 *
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
    	if (head == null) {
    		return null;
    	}
    	ListNode firstHalfSentinel = new ListNode(0);
    	ListNode firstHalpCurrent = firstHalfSentinel;
    	ListNode secondHalfSentinel = new ListNode(0);
    	ListNode secondHalfCurrent = secondHalfSentinel;
    	
    	ListNode current = head;
    	while (current != null) {
    		if (current.val < x) {
    			firstHalpCurrent.next = current;
    			current = current.next;
    		} else {
    			secondHalfCurrent.next = current;
    			current = current.next;
    		}
    	}
    	firstHalpCurrent.next = secondHalfSentinel.next;
    	return firstHalfSentinel.next;
    }
}
