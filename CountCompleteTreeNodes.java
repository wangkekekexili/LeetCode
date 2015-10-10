
public class CountCompleteTreeNodes {
	
	private int countLeft(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + countLeft(node.left);
		}
	}
	
	private int countRight(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + countRight(node.right);
		}
	}
	
    public int countNodes(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}
    	int leftCount = countLeft(root);
    	int rightCount = countRight(root);
    	if (leftCount == rightCount) {
    		return Math.pow(2, leftCount) - 1;
     	} else {
     		return 1 + countNodes(root.left) + countNodes(root.right);
     	}
    }
}
