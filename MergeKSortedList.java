import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * 
 * @author kewang
 *
 */
public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
    	ListNode sentinel = new ListNode(0);
    	ListNode current = sentinel;
    	PriorityQueue<ListNode> heap = new PriorityQueue<>((e1, e2) -> {
    		if (e1.val > e2.val) {
    			return 1;
    		} else if (e1.val < e2.val) {
    			return -1;
    		} else {
    			return 0;
    		}
    	});
    	for (ListNode node : lists) {
    		if (node != null) {
    			heap.add(node);
    		}
    	}
    	while (heap.isEmpty() == false) {
    		ListNode nodeWithMinValue = heap.poll();
    		current.next = nodeWithMinValue;
    		nodeWithMinValue = nodeWithMinValue.next;
    		if (nodeWithMinValue != null) {
    			heap.add(nodeWithMinValue);
    		}
    	}
    	return sentinel.next;
    }
}
