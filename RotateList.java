/**
 * https://leetcode.com/problems/rotate-list/
 * 
 * @author kewang
 *
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
    	if (head == null) {
    		return null;
    	}
    	int length = length(head);
    	k = k % length;
    	if (k == 0) {
    		return head;
    	}
    	
    	ListNode sentinel = new ListNode(0);
    	sentinel.next = head;
    	ListNode oldTail = sentinel.next;
    	
    	ListNode newTail = oldTail;
    	for (int count = 0; count != k; count++) {
    		newTail = newTail.next;
    	}
    	while (newTail.next != null) {
    		oldTail = oldTail.next;
    		newTail = newTail.next;
    	}
    	ListNode newHead = oldTail.next;
    	oldTail.next = null;
    	newTail.next = sentinel.next;
    	return newHead;
    }
    
    private int length(ListNode head) {
    	if (head == null) {
    		return 0;
    	} else {
    		return 1 + length(head.next);
    	}
    }
}
