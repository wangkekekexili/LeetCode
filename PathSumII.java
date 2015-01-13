import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://oj.leetcode.com/problems/path-sum-ii/
 * 
 * @author Ke Wang
 *
 */
public class PathSumII {
	
	private class Item {
		private TreeNode treeNode;
		private int currentSum;
		private List<Integer> intList;
		
		public Item(TreeNode treeNode, int currentSum, List<Integer> intList) {
			this.treeNode = treeNode;
			this.currentSum = currentSum;
			this.intList = intList;
		}
		
		public TreeNode getTreeNode() {
			return this.treeNode;
		}
		
		public int getCurrentSum() {
			return this.currentSum;
		}
		
		public List<Integer> getIntList() {
			return this.intList;
		}
		
	}
	
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if (root==null) {
    		return result;
    	}
    	
    	List<Integer> first = new ArrayList<Integer>();
    	first.add(root.val);
    	Queue<Item> q = new LinkedList<Item>();
    	q.add(new Item(root, root.val, first));
    	
    	while (q.isEmpty() == false) {
    		Item currentItem = q.poll();
    		TreeNode currentTreeNode = currentItem.getTreeNode();
    		int currentSum = currentItem.getCurrentSum();
    		List<Integer> currentList = currentItem.getIntList();
    		
    		if (currentTreeNode.left==null && currentTreeNode.right==null) {
    			if (currentSum == sum) {
    				result.add(currentList);
    			}
    		} else {
    			if (currentTreeNode.left != null) {
    				List<Integer> newList = new ArrayList<Integer>(currentList);
    				newList.add(currentTreeNode.left.val);
    				q.add(new Item(currentTreeNode.left, 
    						currentSum+currentTreeNode.left.val, newList));
    			}
    			if (currentTreeNode.right != null) {
    				List<Integer> newList = new ArrayList<Integer>(currentList);
    				newList.add(currentTreeNode.right.val);
    				q.add(new Item(currentTreeNode.right,
    						currentSum+currentTreeNode.right.val, newList));
    			}
    		}
    		
    	}
    	
    	return result;
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
