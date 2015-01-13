/**
 * https://oj.leetcode.com/problems/find-peak-element/
 * 
 * @author Ke Wang
 *
 */

public class FindPeakElement {
    public int findPeakElement(int[] num) {
    	if (num == null) {
    		return 0;
    	}
    	
    	if (num.length == 1) {
    		return 0;
    	}
    	
    	if (num.length == 2) {
    		if (num[0] > num[1]) {
    			return 0;
    		} else {
    			return 1;
    		}
    	}

    	for (int i = 1;i <= num.length-2;i++) {
    		if (num[i] > num[i-1] && num[i] > num[i+1]) {
    			return i; 
    		}
    	}
    	
    	return 0;
    	
    }
}
