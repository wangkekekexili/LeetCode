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
    		ListNode oneBeforeMax = toInsert;
    		ListNode max = toInsert.next;
    		ListNode current = toInsert.next;
    		while (current.next != null) {
    			if (current.next.val > max.val) {
    				oneBeforeMax = current;
    				max = current.next;
    			}
    			current = current.next;
    		}
    		oneBeforeMax.next = max.next;
    		max.next = toInsert.next;
    		toInsert.next = max;
    		
    		toInsert = toInsert.next;
    		
    	}
    	
    	return sentinel.next;
    	
    }
}
