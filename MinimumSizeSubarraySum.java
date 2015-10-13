/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * 
 * @author kewang
 *
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
    	if (nums == null || nums.length == 0) {
    		return 0;
    	}
    	int total = 0;
    	for (int num : nums) {
    		total += num;
    		if (total > s) {
    			break;
    		}
    	}
    	if (total < s) {
    		return 0;
    	} else if (total == s) {
    		return nums.length;
    	}
    	
    	int min = Integer.MAX_VALUE;
    	int startIndex = 0;
    	int endIndex = 0;
    	int currentSum = 0;
    	while (endIndex < nums.length) {
	    	while (endIndex < nums.length && currentSum < s) {
	    		currentSum += nums[endIndex];
	    		endIndex++;
	    	}
	    	if (currentSum >= s) {
	    		if (endIndex - startIndex< min) {
	    			min = endIndex - startIndex;
	    		}
	    	}
	    	while (startIndex < endIndex && currentSum >= s) {
	    		if (endIndex - startIndex < min) {
	    			min = endIndex - startIndex;
	    		}
	    		currentSum -= nums[startIndex];
	    		startIndex++;
	    		
	    	}
    	}
    	return min;
    }	
    
    public static void main(String[] args) {
    	MinimumSizeSubarraySum instance = new MinimumSizeSubarraySum();
    	int[] nums = {2,3,1,1,1,1,1};
    	System.out.println(instance.minSubArrayLen(5, nums));
    }
}
