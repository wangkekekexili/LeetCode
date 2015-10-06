
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if (head == null) {
    		return null;
    	}
    	if (m == n) {
    		return head;
    	}
    	ListNode sentinel = new ListNode(0);
    	sentinel.next = head;
    	
    	ListNode beforeStart = sentinel;
    	for (int count = 1; count <= m; count++) {
    		beforeStart = beforeStart.next;
    	}
    	
    	ListNode lastNode = beforeStart.next;
    	ListNode now = lastNode;
    	ListNode next = now.next;
    	
    	for (int count = 1; count <= n - m - 1; count++) {
    		ListNode temp = next.next;
    		next.next = now;
    		now = next;
    		next = temp;
    	}
    	
    	beforeStart.next = now;
    	lastNode.next = next;
    	
    	return sentinel.next;
    }
}
