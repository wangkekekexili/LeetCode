import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 * 
 * @author kewang
 *
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
    	
    	List<Interval> result = new ArrayList<>();
    	if (intervals.size() == 0) {
    		return result;
    	}
    	
    	Collections.sort(intervals, (e1, e2)->{
    		if (e1.start < e2.start) {
    			return -1;
    		} else if (e1.start > e2.start) {
    			return 1;
    		} else {
    			return 0;
    		}
    	});	
    	Interval last = null;
    	for (Interval interval : intervals) {
    		if (last == null || last.end < interval.start) {
    			if (last != null) {
    				result.add(last);
    			}
    			last = interval;
    		} else if (interval.end > last.end) {
    			last.end = interval.end;
    		}
    	}
    	result.add(last);
    	return result;
    }
}
