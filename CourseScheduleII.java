import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/course-schedule-ii/
 * 
 * @author kewang
 *
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
    	
    	List<Integer> resultAsList = new ArrayList<>();
    	
    	Map<Integer, Set<Integer>> incoming = new HashMap<>();
    	Map<Integer, Set<Integer>> outgoing = new HashMap<>();
    	for (int index = 0; index != prerequisites.length; index++) {
    		if (prerequisites[index].length != 2) {
    			continue;
    		}
    		int to = prerequisites[index][0];
    		int from = prerequisites[index][1];
    		
    		Set<Integer> temp;
    		
    		temp = incoming.get(to);
    		if (temp == null) {
    			temp = new HashSet<>();
    			incoming.put(to, temp);
    		}
    		temp.add(from);
    		
    		temp = outgoing.get(from);
    		if (temp == null) {
    			temp = new HashSet<>();
    			outgoing.put(from, temp);
    		}
    		temp.add(to);
    	}
    	Queue<Integer> noPreCourses = new LinkedList<>();
    	for (int courseId = 0; courseId != numCourses; courseId++) {
    		if (incoming.get(courseId) == null) {
    			noPreCourses.add(courseId);
    		}
    	}
    	
    	while (noPreCourses.isEmpty() == false) {
    		Integer currentCourseId = noPreCourses.poll();
    		resultAsList.add(currentCourseId);
    		if (outgoing.get(currentCourseId) == null) {
    			continue;
    		}
    		for (Integer to : outgoing.get(currentCourseId)) {
    			Set<Integer> temp = incoming.get(to);
    			temp.remove(currentCourseId);
    			if (temp.size() == 0) {
    				noPreCourses.add(to);
    			}
    		}
    	}
    	
    	for (int courseId = 0; courseId != numCourses; courseId++) {
    		if (incoming.get(courseId) != null && 
    				incoming.get(courseId).size() != 0) {
    			return new int[0];
    		}
    	}
    	
    	int[] result = new int[numCourses];
    	for (int index = 0; index != numCourses; index++) {
    		result[index] = resultAsList.get(index);
    	}
    	return result;
    }	
}
