
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (root!=null) {
			queue.add(root.left);
			queue.add(root.right);
		}
		while (queue.isEmpty()==false) {
			int currentSize = queue.size();
			if (currentSize%2==1) {
				return false;
			}
			ArrayList<TreeNode> currentLevel = new ArrayList<TreeNode>();
			for (int i = 0;i != currentSize/2;i++) {
				TreeNode temp = queue.poll();
				currentLevel.add(temp);
				if (temp==null)
					continue;
				queue.add(temp.left);
				queue.add(temp.right);
			}
			for (int i = currentSize/2;i != currentSize;i++) {
				TreeNode temp = queue.poll();
				int lastIndex = currentLevel.size()-1;
				if (temp==null&&currentLevel.get(lastIndex)==null || 
						temp!=null&&currentLevel.get(lastIndex)!=null&&temp.val==currentLevel.get(lastIndex).val) {
					currentLevel.remove(lastIndex);
				}
				else {
					return false;
				}
				if (temp==null)
					continue;
				queue.add(temp.left);
				queue.add(temp.right);
			}
		}
		return true;
	}
}
