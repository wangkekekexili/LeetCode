/**
 * https://leetcode.com/problems/reverse-linked-list/
 * 
 * @author Ke Wang
 *
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode oneBefore = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
        	next = current.next;
        	current.next = oneBefore;
        	oneBefore = current;
        	current = next;
        }
        return oneBefore;
    }
}
