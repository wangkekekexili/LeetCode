import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * https://oj.leetcode.com/problems/clone-graph/
 * Clone an undirected graph. 
 * Each node in the graph contains a label and a list of its neighbors.
 * 
 * @author Ke Wang
 *
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if (node == null) {
    		return null;
    	}
    	Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
    	Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
    	queue.add(node);
    	UndirectedGraphNode root = new UndirectedGraphNode(node.label);
    	queue.add(root);
    	map.put(root.label, root);
    	
    	while (queue.isEmpty() == false) {
    		UndirectedGraphNode oldNode = queue.poll();
    		UndirectedGraphNode newNode = queue.poll();
    		for (UndirectedGraphNode n : oldNode.neighbors) {
    			UndirectedGraphNode temp = null;
    			if ((temp = map.get(n.label)) !=  null) {
    				newNode.neighbors.add(temp);
    			} else {
    				temp = new UndirectedGraphNode(n.label);
    				map.put(temp.label, temp);
    				newNode.neighbors.add(temp);
    				queue.add(n);
    				queue.add(temp);
    			}
    		}
    	}
    	return root;
    }	
}
