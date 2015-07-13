/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * 
 * @author kewang
 *
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(
    		TreeNode root, TreeNode p, TreeNode q) {
    	
    	// Make sure p's value is smaller than q's value.
    	if (p.val > q.val) {
    		TreeNode temp = p;
    		p = q;
    		q = temp;
    	}
    	
    	TreeNode current = root;
    	while (current != null) {
    		if (q.val < current.val) {
    			return lowestCommonAncestor(current.left, p, q);
    		} else if (p.val > current.val) {
    			return lowestCommonAncestor(current.right, p, q);
    		} else {
    			return current;
    		}
    	}
    	return null;
    }
}
