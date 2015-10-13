import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
    	List<Integer> result = new ArrayList<>();
    	if (nums == null || nums.length == 0) {
    		return result;
    	} else if (nums.length == 1) {
    		result.add(nums[0]);
    		return result;
    	} else if (nums.length == 2) {
    		result.add(nums[0]);
    		result.add(nums[1]);
    		return result;
    	}
    	
    	int candidate1 = 0;
    	int candidate2 = 0;
    	int candidate1Count = 0;
    	int candidate2Count = 0;
    	for (int num : nums) {
    		if (candidate1Count == 0) {
    			candidate1 = num;
    		}
    		if (candidate2Count == 0) {
    			candidate2 = num;
    		}
    		if (num == candidate1) {
    			candidate1Count++;
    		} else if (num == candidate2) {
    			candidate2Count++;
    		} else {
    			candidate1Count--;
    			candidate2Count--;
    		}
    	}
    	
    	// verify
    	candidate1Count = 0;
    	for (int num : nums) {
    		if (num == candidate1) {
    			candidate1Count++;
    		}
    	}
    	if (candidate1Count > nums.length / 3) {
    		result.add(candidate1);
    	}
    	if (candidate1 != candidate2) {
    		candidate2Count = 0;
        	for (int num : nums) {
        		if (num == candidate2) {
        			candidate2Count++;
        		}
        	}
        	if (candidate2Count > nums.length / 3) {
        		result.add(candidate2);
        	}
    	}
    	return result;
    }
}
