
public class RemoveLinkedListElements {
	
    public ListNode removeElements(ListNode head, int val) {
    	ListNode sentinal = new ListNode(0);
    	sentinal.next = head;
    	
    	ListNode oneBefore = sentinal;
    	ListNode current = head;
    	
    	while (current != null) {
    		if (current.val != val) {
    			oneBefore = current;
    			current = current.next;
    		} else {
    			oneBefore.next = current.next;
    			current = current.next;
    		}
    	}
    	
    	return sentinal.next;
    }
}
