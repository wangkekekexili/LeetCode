import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/h-index/
 * 
 * @author kewang
 *
 */
public class HIndex {
    public int hIndex(int[] citations) {
    	List<Integer> list = new ArrayList<>(citations.length);
    	for (int citation : citations) {
    		list.add(citation);
    	}
    	Collections.sort(list);
    	for (int index = 0;index != list.size();index++) {
    		int remaining = list.size() - index;
    		if (list.get(index) >= remaining) {
    			return remaining;
    		}
    	}
    	return 0;
    }
}
