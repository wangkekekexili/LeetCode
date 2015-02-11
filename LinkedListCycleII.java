/**
 * https://oj.leetcode.com/problems/linked-list-cycle-ii/
 * 
 * @author Ke Wang
 *
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
    	if (head == null || head.next == null) {
    		return null;
    	}
    	ListNode slow = head;
    	ListNode fast = head;
    	ListNode late = head;
    	while (fast != null) {
    		slow = slow.next;
    		fast = fast.next;
    		if (fast.next == null) {
    			return null;
    		}
    		fast = fast.next;
    		if (slow == fast) {
    			while (late != slow) {
    				late = late.next;
    				slow = slow.next;
    			}
    			return slow;
    		}
    	}
    	return null;
    }
}
