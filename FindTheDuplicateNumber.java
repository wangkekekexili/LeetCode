/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 * 
 * @author Ke Wang
 *
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
    	if (nums == null || nums.length <= 1) {
    		return 0;
    	}
    	if (nums.length == 2) {
    		return nums[0];
    	}
    	int first = 1;
    	int last = nums.length - 1;
    	while (true) {
    		int current = (last + first) / 2;
    		int numberOfCurrent = 0;
    		
    		int numbersLessThanCurrentExpected = current - first;
    		int numbersLessThanCurrent = 0;
    		
    		for (int num : nums) {
    			if (num == current) {
    				numberOfCurrent++;
    			} else if (num < current && num >= first) {
    				numbersLessThanCurrent++;
    			}
    		}
    		
    		if (numberOfCurrent > 1) {
    			return current;
    		}
    		
    		if (numbersLessThanCurrentExpected < numbersLessThanCurrent) {
    			last = current - 1;
    		} else {
    			first = current + 1;
    		}
    		
    	}
    	
    }	
    
    public static void main(String[] args) {
    	FindTheDuplicateNumber instance = new FindTheDuplicateNumber();
    	int[] test = {1,4,4,2,4};
    	System.out.println(instance.findDuplicate(test));
    }
}
