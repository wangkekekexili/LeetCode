import java.util.Stack;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * 
 * @author kewang
 *
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
    	if (root == null) {
    		return;
    	}
    	Stack<TreeNode> stack = new Stack<>();
    	stack.push(root);
    	
    	TreeNode sentinel = new TreeNode(0);
    	TreeNode last = sentinel;
    	
    	while (stack.isEmpty() == false) {
    		TreeNode current = stack.pop();
			if (current.right != null) {
				stack.push(current.right);
			}
			if (current.left != null) {
				stack.push(current.left);
			}
			current.left = null;
			current.right = null;
			last.right = current;
			last = current;
    	}
    }	
}
