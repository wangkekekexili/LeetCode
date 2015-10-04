import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreeII {
    public List<TreeNode> generateTrees(int n) {
    	if (n <= 0) {
    		return new ArrayList<>();
    	}
    	return generateTrees(1, n);
    }
    private List<TreeNode> generateTrees(int start, int end) {
    	List<TreeNode> currentResult = new ArrayList<>();
    	if (start > end) {
    		return null;
    	} else if (start == end) {
    		currentResult.add(new TreeNode(start));
    	} else {
    		for (int index = start; index <= end; index++) {
    			List<TreeNode> left = generateTrees(start, index - 1);
    			List<TreeNode> right = generateTrees(index + 1, end);
    			if (left == null) {
    				for (TreeNode tempRight : right) {
    					TreeNode temp = new TreeNode(index);
    					temp.right = tempRight;
    					currentResult.add(temp);
    				}
    			} else if (right == null) {
    				for (TreeNode tempLeft : left) {
    					TreeNode temp = new TreeNode(index);
    					temp.left = tempLeft;
    					currentResult.add(temp);
    				}
    			} else {
    				for (TreeNode tempRight : right) {
    					for (TreeNode tempLeft : left) {
    						TreeNode temp = new TreeNode(index);
    						temp.left = tempLeft;
    						temp.right = tempRight;
    						currentResult.add(temp);
    					}
    				}
    			}
    		}
    	}
    	return currentResult;
    	
    }
}
