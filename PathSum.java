/**
 * Given a binary tree and a sum, 
 * determine if the tree has a root-to-leaf path 
 * such that adding up all the values along the path equals the given sum.
 * 
 * @author Ke Wang
 *
 */

import java.util.Queue;
import java.util.LinkedList;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root==null) {
			return false;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (q.isEmpty() == false) {
			TreeNode current = q.poll();
			if (current.left==null && current.right==null) { // is leave
				if (current.val==sum) {
					return true;
				}
			}
			else {
				if (current.left != null) {
					current.left.val += current.val;
					q.add(current.left);
				}
				if (current.right != null) {
					current.right.val += current.val;
					q.add(current.right);
				}
			}
		}
		return false;
	}
}
