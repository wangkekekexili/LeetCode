import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> result = new ArrayList<>();
    	Set<TreeNode> childrenVisited = new HashSet<>();
    	Stack<TreeNode> stack = new Stack<>();
    	if (root == null) {
    		return result;
    	}
    	stack.add(root);
    	
    	while (stack.isEmpty() == false) {
    		TreeNode current = stack.pop();
    		if (childrenVisited.contains(current) == false) {
    			childrenVisited.add(current);
    			stack.push(current);
    			if (current.right != null) {
    				stack.push(current.right);
    			}
    			if (current.left != null) {
    				stack.push(current.left);
    			}
    		} else {
    			result.add(current.val);
    		}
    	}
    	return result;
    }
}
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Stack;
//
//
//class Item {
//	Object object;
//	boolean isNode;
//	
//	Item(Object object, boolean isNode) {
//		this.object = object;
//		this.isNode = isNode;
//	}
//	
//}
//
//public class BinaryTreePostorderTraversal {
//	/*
//	private void postorderTraversal(TreeNode node, List<Integer> list) {
//		if (node != null) {
//			postorderTraversal(node.left, list);
//			postorderTraversal(node.right, list);
//			list.add(node.val);
//		}
//	}
//	
//    public List<Integer> postorderTraversal(TreeNode root) {
//    	List<Integer> resultList = new ArrayList<Integer>();
//    	if (root == null) {
//    		return resultList;
//    	}
//    	this.postorderTraversal(root, resultList);
//    	return resultList;
//    }*/
//	
//	public List<Integer> postorderTraversal(TreeNode root) {
//		List<Integer> resultList = new ArrayList<>();
//		if (root == null) {
//			return resultList;
//		}
//		
//		Stack<Item> stack = new Stack<>();
//		stack.push(new Item(root, true));
//		
//		while (stack.isEmpty() == false) {
//			Item currentItem = stack.pop();
//			if (currentItem.isNode == false) {
//				resultList.add((Integer)currentItem.object);
//			} else {
//				TreeNode currentNode = (TreeNode)currentItem.object;
//				stack.push(new Item(new Integer(currentNode.val), false));
//				if (currentNode.right != null) {
//					stack.push(new Item(currentNode.right, true));
//				}
//				if (currentNode.left != null) {
//					stack.push(new Item(currentNode.left, true));
//				}
//			}
//		}
//		
//		return resultList;
//		
//	}
//}
