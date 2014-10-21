import java.util.List;
import java.util.LinkedList;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/**
 * Given a binary tree, 
 * return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, 
 * then right to left for the next level and alternate between).
 * 
 * 
 * @author Ke Wang
 *
 */
public class BinaryTreeZiaZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
    	List<List<Integer>> result = new LinkedList<List<Integer>>();
    	
    	if (root==null) {
    		return result;
    	}
    	
    	Stack<TreeNode> leftStack = new Stack<TreeNode>();
        Stack<TreeNode> rightStack = new Stack<TreeNode>();
        
        leftStack.push(root);
        
        while (leftStack.isEmpty()==false || rightStack.isEmpty()==false) {
        	if (leftStack.isEmpty()==false) {
        		List<Integer> currentLayer = new LinkedList<Integer>();
        		while (leftStack.isEmpty()==false) {
        			TreeNode currentTreeNode = leftStack.pop();
        			currentLayer.add(new Integer(currentTreeNode.val));
        			if (currentTreeNode.left != null) {
        				rightStack.add(currentTreeNode.left);
        			}
        			if (currentTreeNode.right != null) {
        				rightStack.add(currentTreeNode.right);
        			}
        		}
        		result.add(currentLayer);
        	}
        	else {
        		List<Integer> currentLayer = new LinkedList<Integer>();
        		while (rightStack.isEmpty()==false) {
        			TreeNode currentTreeNode = rightStack.pop();
        			currentLayer.add(new Integer(currentTreeNode.val));
        			if (currentTreeNode.right != null) {
        				leftStack.add(currentTreeNode.right);
        			}
        			if (currentTreeNode.left != null) {
        				leftStack.add(currentTreeNode.left);
        			}
        		}
        		result.add(currentLayer);
        	}
        }
        
        return result;
        
    }
}
