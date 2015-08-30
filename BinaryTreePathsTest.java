import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class BinaryTreePathsTest {

	@Test
	public void test() {
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode five = new TreeNode(5);
		root.left = two;
		root.right = three;
		two.right = five;
		
		BinaryTreePaths instance = new BinaryTreePaths();
		List<String> result = instance.binaryTreePaths(root);
		assertEquals(2, result.size());
		assertEquals("1->2->5", result.get(0));
		assertEquals("1->3", result.get(1));
	}

}
