/**
 * https://leetcode.com/problems/missing-number/
 * 
 * @author kewang
 *
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
    	int size = nums.length;
    	int total = size * (size + 1) / 2;
    	int actualTotal = 0;
    	for (int num : nums) {
    		actualTotal += num;
    	}
    	return total - actualTotal;
    }
}
