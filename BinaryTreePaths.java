import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.StringJoiner;

/**
 * https://leetcode.com/problems/binary-tree-paths/
 * 
 * @author kewang
 *
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
        	return result;
        }
    	Stack<TreeNode> stack = new Stack<>();
    	Set<TreeNode> visited = new HashSet<>();
    	TreeNode current = root;
    	while (current != null) {
    		stack.add(current);
    		current = current.left;
    	}
    	
    	while (true) {
    		current = stack.peek();
    		if (current.right != null && !visited.contains(current)) {
    			visited.add(current);
    			current = current.right;
    			while (current != null) {
    				stack.add(current);
    				current = current.left;
    			}
    		} else if (current.left == null && current.right == null) {
    			// add the path to the result
    			StringJoiner sj = new StringJoiner("->");
    			for (int index = 0;index != stack.size();index++) {
    				sj.add(Integer.toString(stack.get(index).val));
    			}
    			result.add(sj.toString());
    			visited.add(current);
    			stack.pop();
    			if (stack.empty() == true) {
    				break;
    			}
    		} else {
    			stack.pop();
    			if (stack.empty() == true) {
    				break;
    			}
    		}
    	}
    	
    	return result;
    }
}
