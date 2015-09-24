
public class SortList {
	
	private ListNode merge(ListNode first, ListNode second) {
		ListNode sentinel = new ListNode(0);
		ListNode current = sentinel;
		while (first != null && second != null) {
			if (first.val >= second.val) {
				current.next = first;
				first = first.next;
			} else {
				current.next = second;
				second = second.next;
			}
			current = current.next;
		}
		if (first != null) {
			current.next = first;
		}
		if (second != null) {
			current.next = second;
		}
		return sentinel.next;
	}
	
    public ListNode sortList(ListNode head) {
    	if (head == null || head.next == null) {
    		return head;
    	}
    	
    	// find the middle node
    	ListNode slow = head;
    	ListNode fast = head;
    	while (fast.next != null && fast.next.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	
    	ListNode next = slow.next;
    	slow.next = null;
    	head = sortList(head);
    	next = sortList(next);
    	return merge(head, next);
    }
    
    public static void main(String[] args) {
    	ListNode first = new ListNode(3);
    	ListNode second = new ListNode(1);
    	ListNode third = new ListNode(4);
    	first.next = second;
    	second.next = third;
    	new SortList().sortList(first);
    }
}
