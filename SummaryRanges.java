import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of 
 * its ranges.
 *
 * <p>For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].</p>
 * 
 * @author kewang
 *
 */
public class SummaryRanges {
	
    public List<String> summaryRanges(int[] nums) {
    	List<String> result = new ArrayList<>();
    	if (nums == null || nums.length == 0) {
    		return result;
    	}
    	int start = nums[0];
    	int end = nums[0];
    	for (int i = 1; i < nums.length;i++) {
    		int current = nums[i];
    		if (current == end + 1) {
    			end++;
    		} else {
    			if (start == end) {
    				result.add(Integer.toString(start));
    			} else {
    				result.add(Integer.toString(start)
    						+"->"+Integer.toString(end));
    			}
    			start = end = current;
    		}
    	}
    	if (start == end) {
			result.add(Integer.toString(start));
		} else {
			result.add(Integer.toString(start)
					+"->"+Integer.toString(end));
		}
    	return result;
    }
    
    public static void main(String[] args) {
    	SummaryRanges object = new SummaryRanges();
    	int[] test = {0,1,2,4,5,7};
    	System.out.println(object.summaryRanges(test));
    }
    
}
