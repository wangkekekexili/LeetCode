import java.util.Stack;

/**
 * https://oj.leetcode.com/problems/sum-root-to-leaf-numbers/
 * 
 * @author Ke Wang
 *
 */

public class SumRoottoLeafNumbers {
    private class TreeNodeValuePair {
    	TreeNode treeNode;
    	int value;
    	public TreeNodeValuePair(TreeNode treeNode, int value) {
    		this.treeNode = treeNode;
    		this.value = value;
    	}
    	public TreeNode getTreeNode() {
    		return this.treeNode;
    	}
    	public int getValue() {
    		return this.value;
    	}
    }
	public int sumNumbers(TreeNode root) {
    	if (root == null) { return 0; }
    	
    	int sum = 0;
    	
    	Stack<TreeNodeValuePair> stack = new Stack<TreeNodeValuePair>();
    	stack.push(new TreeNodeValuePair(root, root.val));
    	while (stack.empty() != true) {
    		TreeNodeValuePair current = stack.pop();
    		if (current.getTreeNode().left==null && 
    				current.getTreeNode().right==null) {
    			sum += current.getValue();
    		} else {
    			if (current.getTreeNode().left!=null) {
    			stack.push(new TreeNodeValuePair(current.getTreeNode().left, 
    					current.getValue()*10+current.getTreeNode().left.val));
    			}
    			if (current.getTreeNode().right!=null){
    			stack.push(new TreeNodeValuePair(current.getTreeNode().right,
    					current.getValue()*10+current.getTreeNode().right.val));
    			}
    		}
    	}
    	
    	return sum;
    }
}
