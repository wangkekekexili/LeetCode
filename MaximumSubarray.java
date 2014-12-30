
/**
 * https://oj.leetcode.com/problems/maximum-subarray/
 * 
 * @author Ke Wang
 *
 */

public class MaximumSubarray {
    public int maxSubArray(int[] A) {
    	int length = A.length;
    	int[][] matrix = new int[length+1][length+1];
    	for (int i = 0;i != length;i++) {
    		matrix[i][i] = A[i];
    	}
    	for (int interval = 1;interval <= length-1;interval++) {
    		for (int begin = 0;begin <= length-interval;begin++) {
    			int end = begin+interval;
    			int temp = 0;;
    			
    			if (A[begin] < 0) {
    				temp = matrix[begin+1][end];
    			} else {
    				temp = A[begin]
    			}
    			
    			
    			
    			matrix[begin][end] = temp;
    		}
    	}
    }	
}
