/**
 * https://oj.leetcode.com/problems/add-two-numbers/
 * 
 * @author Ke Wang
 *
 */

/*public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1==null && l2==null) {
			return null;
		}
		
		ListNode head = null;
		ListNode pre = null;
		
		int carry = 0;
		while (l1!=null && l2!=null) {
			int temp = l1.val + l2.val + carry;
			if (temp >= 10) {
				carry = 1;
				temp -= 10;
			} else {
				carry = 0;
			}
			ListNode current = new ListNode(temp);
			if (head == null) {
				head = current;
			} else {
				pre.next = current;
			}
			pre = current;
			l1 = l1.next;
			l2 = l2.next;
		}
		
		while (l1 != null) {
			int temp = l1.val + carry;
			if (temp >= 10) {
				carry = 1;
				temp -= 10;
			} else {
				carry = 0;
			}
			ListNode current = new ListNode(temp);
			if (head == null) {
				head = current;
			} else {
				pre.next = current;
			}
			pre = current;
			l1 = l1.next;
		}
		
		while (l2 != null) {
			int temp = l2.val + carry;
			if (temp >= 10) {
				carry = 1;
				temp -= 10;
			} else {
				carry = 0;
			}
			ListNode current = new ListNode(temp);
			if (head == null) {
				head = current;
			} else {
				pre.next = current;
			}
			pre = current;
			l2 = l2.next;
		}
		
		if (carry != 0) {
			ListNode node = new ListNode(1);
			pre.next = node;
		}
		
		return head;
    }
	
	
	
}*/

// a more compact version
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode sentinal = new ListNode(0);
		ListNode current = sentinal;
		int sum = 0;
		while (l1!=null || l2!=null) {
			if (l1!=null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2!=null) {
				sum += l2.val;
				l2 = l2.next;
			}
			ListNode n = new ListNode(sum%10);
			current.next = n;
			current = n;
			sum /= 10;
		}
		if (sum == 1) {
			ListNode n = new ListNode(1);
			current.next = n;
		}
		return sentinal.next;
	}
}
