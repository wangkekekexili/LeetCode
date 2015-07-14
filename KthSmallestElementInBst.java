import java.util.Stack;

public class KthSmallestElementInBst {
    public int kthSmallest(TreeNode root, int k) {
    	
    	if (root == null) {
    		return 0;
    	}
    	
    	TreeNode current = root;
    	
    	Stack<TreeNode> stack = new Stack<>();
    	while (current != null) {
    		stack.add(current);
    		current = current.left;
    	}
    	
    	while (k > 0) {
    		current = stack.pop();
    		k--;
    		if (k == 0) {
    			return current.val;
    		}
    	    if (current.right != null) {
    	    	current = current.right;
    	    	while (current != null) {
    	    		stack.add(current);
    	    		current = current.left;
    	    	}
    	    }
    	}
    	
    	return 0;
    	
    }
}
