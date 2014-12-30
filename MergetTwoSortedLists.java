/**
 * https://oj.leetcode.com/problems/merge-two-sorted-lists/
 * 
 * @author Ke Wang
 *
 */

public class MergetTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode sentinal = new ListNode(0);
    	ListNode current = sentinal;
    	while (l1!=null && l2!=null) {
    		if (l1.val < l2.val) {
    			current.next = l1;
    			current = l1;
    			l1 = l1.next;
    		} else {
    			current.next = l2;
    			current = l2;
    			l2 = l2.next;
    		}
    	}
    	if (l1!=null) {
    		current.next = l1;
    	}
    	if (l2!=null) {
    		current.next = l2;
    	}
    	return sentinal.next;
    }
}
