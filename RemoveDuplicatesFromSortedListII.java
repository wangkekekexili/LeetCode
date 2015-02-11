/**
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * 
 * @author Ke Wang
 *
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
    	if (head == null) {
    		return null;
    	}
    	if (head.next == null) {
    		return head;
    	}
    	ListNode sentinel = new ListNode(0);
    	sentinel.next = head;
    	
    	ListNode before = sentinel;
    	ListNode front = head;
    	ListNode tail = head.next;
    	while (tail != null) {
    		if (front.val == tail.val) {
    			while (tail != null && tail.val == front.val) {
    				tail = tail.next;
    			}
    			before.next = tail;
    			if (tail == null || tail.next == null) {
    				break;
    			} else {
    				front = tail;
    				tail = tail.next;
    			}
    		} else {
    			before = before.next;
    			front = front.next;
    			tail = tail.next;
    		}
    	}
    	return sentinel.next;
    }
}
