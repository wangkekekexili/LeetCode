import java.util.ArrayList;

/**
 * Given a singly linked list where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * 
 * @author Ke Wang
 *
 */
public class ConvertSortedListToBinarySearchTree {
    
	private void sortedListToBST(ArrayList<Integer> array, int begin, int end, TreeNode current) {
		if (begin > end) {
			return;
		}
		if (end - begin <= 2) {
			if (begin == end) {
				current.val = array.get(begin);
				return;
			} else if (end - begin == 1) {
				current.val = array.get(end);
				current.left = new TreeNode(array.get(begin));
				return;
			} else {
				current.val = array.get(begin+1);
				current.left = new TreeNode(array.get(begin));
				current.right = new TreeNode(array.get(end));
			}
		} else {
			int middle = (end+begin) / 2;
			current.val = array.get(middle);
			current.left = new TreeNode(0);
			current.right = new TreeNode(0);
			sortedListToBST(array, begin, middle-1, current.left);
			sortedListToBST(array, middle+1, end, current.right);
		}
	}
	
	public TreeNode sortedListToBST(ListNode head) {
    	if (head == null) {
    		return null;
    	}
    	ArrayList<Integer> array = new ArrayList<Integer>();
    	ListNode current = head;
    	while (current != null) {
    		array.add(head.val);
    		current = current.next;
    	}
    	TreeNode root = new TreeNode(0);
    	sortedListToBST(array, 0, array.size()-1,root);
    	return root;
    }
}
