
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * 
 * @author kewang
 *
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
    	if (nums == null || nums.length == 0) {
    		return 0;
    	}
    	if (nums.length == 1) {
    		return 1;
    	}
    	
    	Set<Integer> s = new HashSet<>();
    	for (int num : nums) {
    		s.add(num);
    	}
    	
    	int max = 0;
    	for (int index = 0; index != nums.length; index++) {
    		int count = 1;
    		s.remove(nums[index]);
    		
    		// check if there is number one smaller
    		int current = nums[index];
    		while (s.contains(--current)) {
    			count++;
    			s.remove(current);
    		}
    		
    		// check if there is number one larger
    		current = nums[index];
    		while (s.contains(++current)) {
    			count++;
    			s.remove(current);
    		}
    		
    		if (count > max) {
    			max = count;
    		}
    	}
    	
    	return max;
    }
}
