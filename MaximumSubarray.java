
/**
 * https://oj.leetcode.com/problems/maximum-subarray/
 * 
 * @author Ke Wang
 *
 */

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
    	if (nums == null || nums.length == 0) {
    		return 0;
    	}
    	if (nums.length == 1) {
    		return nums[0];
    	}
    	int max = nums[0];
    	int currentMax = nums[0];
    	
    	for (int index = 1; index < nums.length; index++) {
    		if (currentMax + nums[index] > nums[index]) {
    			currentMax += nums[index];
    		} else {
    			currentMax = nums[index];
    		}
    		if (currentMax > max) {
    			max = currentMax;
    		}
    	}
    	return max;
    }	
}
