import java.util.HashSet;
import java.util.Set;



/**
 * Given a linked list, determine if it has a circle in it
 * 
 * @author Ke Wang
 *
 */

public class LinkedListCycle {
	/*public boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		
		// use a set to record which nodes have been visited
		Set<ListNode> set = new HashSet<ListNode>();
		
		set.add(head);
		
		
		ListNode currentNode = head;
		while (true) {
			ListNode next = currentNode.next;
			if (next==null) {
				return false;
			}
			
			if (set.contains(next)) {
				return true;
			} else {
				set.add(next);
			}
			
			currentNode = next;
		}
	}*/
	public boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		
		if (head.next == null) {
			return false;
		}
		
		ListNode fast = head.next;
		ListNode slow = head;
		while (fast != null) {
			slow = slow.next;
			if (fast.next == null || fast.next.next == null) {
				return false;
			} else {
				fast = fast.next.next;
				if (slow == fast) {
					return true;
				}
			}
		}
		
		return false;
		
	}
}
