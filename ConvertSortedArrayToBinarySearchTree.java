/**
 * https://oj.leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * @author Ke Wang
 *
 */
public class ConvertSortedArrayToBinarySearchTree {
    
	public void sortedArrayToBST(int[] num, int begin, int end, TreeNode current) {
		if (begin > end) {
			return;
		}
		if (end - begin <= 2) {
			if (begin == end) {
				current.val = num[begin];
				return;
			} else if (end - begin == 1) {
				current.val = num[end];
				current.left = new TreeNode(num[begin]);
				return;
			} else {
				current.val = num[begin+1];
				current.left = new TreeNode(num[begin]);
				current.right = new TreeNode(num[end]);
			}
		} else {
			int middle = (end+begin) / 2;
			current.val = num[middle];
			current.left = new TreeNode(0);
			current.right = new TreeNode(0);
			sortedArrayToBST(num, begin, middle-1, current.left);
			sortedArrayToBST(num, middle+1, end, current.right);
		}
	}
	
	public TreeNode sortedArrayToBST(int[] num) {
    	if (num==null) {
    		return null;
    	}
		TreeNode root = new TreeNode(0);
    	if (num.length==0) {
    		return root;
    	}
    	sortedArrayToBST(num, 0, num.length-1, root);
    	return root;
    }
}
