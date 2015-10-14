
public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
    	// find an index of target
    	int index = findOne(nums, 0, nums.length - 1, target);
    	if (index == -1) {
    		return new int[]{-1,-1};
    	}
    	int lastIndex = findLast(nums, index + 1, nums.length - 1, target);
    	int firstIndex = findFirst(nums, 0, index - 1, target);
    	return new int[]{firstIndex, lastIndex};
    }
    
    private int findLast(int[] nums, int start, int end, int target) {
    	if (start > end) {
    		return start - 1;
    	}
    	if (start == end) {
    		if (nums[start] == target) {
    			return start;
    		} else {
    			return start-1;
    		}
    	}
    	int middle = (start + end) / 2;
    	if (nums[middle] == target && (middle==end || nums[middle+1] > target)) {
    		return middle;
		} else if (nums[middle] == target) {
    		return findLast(nums, middle+1, end, target);
    	} else {
    		return findLast(nums, start, middle, target);
    	}
    }
    
    private int findFirst(int[] nums, int start, int end, int target) {
    	if (start > end) {
    		return end + 1;
    	}
    	if (start == end) {
    		if (nums[start] == target) {
    			return start;
    		} else {
    			return end+1;
    		}
    	}
    	int middle = (start + end) / 2 + 1;
    	if (nums[middle] == target && (middle == start || nums[middle-1] < target)) {
    		return middle;
    	} else if (nums[middle] == target) {
    		return findFirst(nums, start, middle - 1, target);
    	} else {
    		return findFirst(nums, middle, end, target);
    	}
    	
    }
    
    private int findOne(int[] nums, int start, int end, int target) {
    	if (start > end) {
    		return -1;
    	}
    	if (start == end) {
    		if (nums[start] == target) {
    			return start;
    		} else {
    			return -1;
    		}
    	}
    	int middle = (start + end) / 2;
    	if (nums[middle] == target) {
    		return middle;
    	} else if (nums[middle] > target) {
    		return findOne(nums, start, middle - 1, target); 
    	} else {
    		return findOne(nums, middle + 1, end, target);
    	}
    }
    
    public static void main(String[] args) {
    	SearchForARange instance = new SearchForARange();
    	int[] nums = {5, 7, 7, 8, 8, 10};
    	instance.searchRange(nums, 8);
    }
}
