/**
 * https://oj.leetcode.com/problems/intersection-of-two-linked-lists/
 * 
 * @author Ke Wang
 *
 */

// set

/*public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	Set<ListNode> set = new HashSet<ListNode>();
    	while (headA != null) {
    		set.add(headA);
    		headA = headA.next;
    	}
    	while (headB != null) {
    		if (set.contains(headB)) {
    			return headB;
    		}
    		headB = headB.next;
    	}
    	return null;
    }
}*/

public class IntersectionOfTwoLinkedList {
	private int lengthOf(ListNode head) {
		ListNode current = head;
		int length = 0;
		while (current != null) {
			length++;
			current = current.next;
		}
		return length;
	}
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lengthA = lengthOf(headA);
		int lengthB = lengthOf(headB);
		while (lengthA > lengthB) {
			headA = headA.next;
			lengthA--;
		}
		while (lengthB > lengthA) {
			headB = headB.next;
			lengthB--;
		}
		while (true) {
			if (headA == headB) {
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
		}
	}
}
