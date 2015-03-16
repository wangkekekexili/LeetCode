import java.util.Stack;


public class BinarySearchTreeIterator {

	Stack<TreeNode> parents;
	TreeNode current;
	
    public BinarySearchTreeIterator(TreeNode root) {
        parents = new Stack<>();
        current = root;
    }

    /** 
     * @return whether we have a next smallest number 
     **/
    public boolean hasNext() {
        if (parents.isEmpty() == false || current != null) {
        	return true;
        } else {
        	return false;
        }
    }

    /** 
     * @return the next smallest number 
     **/
    public int next() {
        while (current != null) {
        	parents.add(current);
        	current = current.left;
        }
        TreeNode next = parents.pop();
        current = next.right;
        return next.val;
    }
}
