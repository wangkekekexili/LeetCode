import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/course-schedule/
 * 
 * @author kewang
 *
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	Map<Integer, Set<Integer>> incoming = new HashMap<>();
    	Map<Integer, Set<Integer>> outgoing = new HashMap<>();
    	for (int index = 0; index != prerequisites.length; index++) {
    		int to = prerequisites[index][0];
    		int from = prerequisites[index][1];
    		
    		Set<Integer> tempSet = null;
    		
    		tempSet = incoming.get(to);
    		if (tempSet == null) {
    			tempSet = new HashSet<>();
    			incoming.put(to, tempSet);
    		}
    		tempSet.add(from);
    		
    		tempSet = outgoing.get(from);
    		if (tempSet == null) {
    			tempSet = new HashSet<>();
    			outgoing.put(from, tempSet);
    		}
    		tempSet.add(to);
    	}
    	
    	Queue<Integer> withoutIncomingEdges = new LinkedList<>();
    	for (int i = 0; i != numCourses; i++) {
    		if (incoming.get(i) == null) {
    			withoutIncomingEdges.add(i);
    		}
    	}
    	
    	while (withoutIncomingEdges.isEmpty() == false) {
    		int id = withoutIncomingEdges.poll();
    		if (outgoing.get(id) != null) {
	    		for (int toId : outgoing.get(id)) {
	    			incoming.get(toId).remove(id);
	    			if (incoming.get(toId).isEmpty() == true) {
	    				incoming.remove(toId);
	    				withoutIncomingEdges.add(toId);
	    			}
	    		}
    		}
    	}
    	
    	return incoming.isEmpty() == true;
    }
}
