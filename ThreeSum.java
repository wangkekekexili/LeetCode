import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 * 
 * @author kewang
 *
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> result = new ArrayList<>();
    	if (nums == null || nums.length <= 2) {
    		return result;
    	}
    	Arrays.sort(nums);
    	for (int first = 0; first <= nums.length - 3;) {
    		int second = first + 1;
    		int third = nums.length - 1;
    		while (second < third) {
    			if (nums[first] + nums[second] + nums[third] == 0) {
    				result.add(Arrays.asList(
    						nums[first], nums[second],nums[third]));
    				while (second + 1 < nums.length && 
    						nums[second] == nums[second + 1]) {
    					second++;
    				}
    				while (third - 1 >= 0 && nums[third] == nums[third - 1]) {
    					third--;
    				}
    				second++;
    				third--;
    			}
    			if (second >= nums.length || third < 0) {
    			    break;
    			}
    			if (nums[first] + nums[second] + nums[third] > 0) {
    				third--;
    			} else if (nums[first] + nums[second] + nums[third] < 0){
    				second++;
    			}
    		}
    		while (first + 1 < nums.length && nums[first] == nums[first + 1]) {
    		    first++;
    		}
    		first++;
    	}
    	return result;
    }	
}
