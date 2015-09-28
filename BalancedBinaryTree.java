/**
 * https://leetcode.com/problems/balanced-binary-tree/
 * 
 * @author kewang
 *
 */
public class BalancedBinaryTree {
	
	private boolean ifBalance = true;
	
	private int height(TreeNode node) {
		if (ifBalance == false) {
			return -1;
		}
		if (node == null) {
			return 0;
		}
		int leftHeight = height(node.left);
		int rightHeight = height(node.right);
		
		if (ifBalance == false) {
			return -1;
		}
		
		if (Math.abs(leftHeight - rightHeight) <= 1) {
			return 1 + Math.max(leftHeight, rightHeight);
		} else {
			ifBalance = false;
			return -1;
		}
	}
	
    public boolean isBalanced(TreeNode root) {
    	if (root == null) {
    		return true;
    	}
    	height(root);
    	if (ifBalance == true) {
    		return true;
    	} else {
    		return false;
    	}
    }
}
