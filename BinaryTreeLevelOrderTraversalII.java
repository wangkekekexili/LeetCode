import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://oj.leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * 
 * @author Ke Wang
 *
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
    	if (root == null) {
    		return result;
    	}
    	Queue<TreeNode> treeNodeQueue = new LinkedList<TreeNode>();
    	treeNodeQueue.add(root);
    	treeNodeQueue.add(null);
    	List<Integer> currentLevel = new ArrayList<Integer>();
    	TreeNode last = null;
    	while (treeNodeQueue.isEmpty() == false) {
    		TreeNode current = treeNodeQueue.poll();
    		if (current == null) {
    			if (last == null) {
    				break;
    			}
    			result.addFirst(currentLevel);
    			currentLevel = new ArrayList<Integer>();
    			treeNodeQueue.add(null);
    			last = null;
    		} else {
    			last = current;
    			currentLevel.add(current.val);
    			if (current.left != null) {
    				treeNodeQueue.add(current.left);
    			}
    			if (current.right != null) {
    				treeNodeQueue.add(current.right);
    			}
    		}
    	}
    	return result;
    }
}
