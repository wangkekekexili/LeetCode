/**
 * https://oj.leetcode.com/problems/insertion-sort-list/
 * 
 * @author Ke Wang
 *
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
    	if (head==null) {
    		return null;
    	}
    	
    	ListNode sentinel = new ListNode(0);
    	sentinel.next = head;
    	
    	ListNode toInsert = sentinel;
    	
    	while (toInsert.next != null) {
    		ListNode oneBeforeMin = toInsert;
    		ListNode min = toInsert.next;
    		ListNode current = toInsert.next;
    		while (current.next != null) {
    			if (current.next.val > min.val) {
    				oneBeforeMin = current;
    				min = current.next;
    			}
    			current = current.next;
    		}
    		oneBeforeMin.next = min.next;
    		min.next = toInsert.next;
    		toInsert.next = min;
    		
    		toInsert = toInsert.next;
    		
    	}
    	
    	return sentinel.next;
    	
    }
}
