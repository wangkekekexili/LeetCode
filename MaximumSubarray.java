
/**
 * https://oj.leetcode.com/problems/maximum-subarray/
 * 
 * @author Ke Wang
 *
 */

public class MaximumSubarray {
    public int maxSubArray(int[] A) {
    	if (A == null || A.length == 0) {
    		return 0;
    	}
    	if (A.length == 1) {
    		return A[0];
    	}
    	int max = A[0];
    	int currentMax = A[0];
    	
    	for (int index = 1; index < A.length; index++) {
    		if (currentMax + A[index] > A[index]) {
    			currentMax += A[index];
    		} else {
    			currentMax = A[index];
    		}
    		if (currentMax > max) {
    			max = currentMax;
    		}
    	}
    }	
}
