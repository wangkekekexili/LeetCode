/**
 * https://oj.leetcode.com/problems/validate-binary-search-tree/
 * 
 * @author Ke Wang
 *
 */
public class ValidateBinarySearchTree {
	private boolean isValidBST(TreeNode node, long min, long max) {
		if (node==null) {
			return true;
		}
		if (node.val > min && node.val < max) {
			if (node.left==null && node.right==null) {
				return true;
			} else {
				return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
			}
		} else {
			return false;
		}
	}
    public boolean isValidBST(TreeNode root) {
    	return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
