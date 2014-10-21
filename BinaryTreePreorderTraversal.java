/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * 
 * @author Ke Wang
 *
 */

import java.util.Stack;
import java.util.List;
import java.util.LinkedList;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        
        if (root==null) {
        	return list;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        stack.push(root);
        while (stack.isEmpty()==false) {
        	TreeNode current = stack.pop();
        	list.add(new Integer(current.val));
        	if (current.right!=null) {
        		stack.push(current.right);
        	}
        	if (current.left!=null) {
        		stack.push(current.left);
        	}
        }
        return list;
    }
}
