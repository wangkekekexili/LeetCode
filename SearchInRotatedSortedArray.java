/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 
 * @author kewang
 *
 */
public class SearchInRotatedSortedArray {
	
	private int search(int[] nums, int start, int end, int target) {
		if (nums == null || end-start < 0) {
			return -1;
		}
		if (end-start == 0) {
			if (nums[start] == target) {
				return start;
			} else {
				return -1;
			}
		}
		if (end-start == 1) {
			if (nums[start] == target) {
				return start;
			} else if (nums[end] == target) {
				return end;
			} else {
				return -1;
			}
		}
		
		int middle = (start + end) / 2;
		if (nums[middle] == target) {
			return middle;
		}
		if (nums[start] < nums[middle]) {
			if (target >= nums[start] && target <= nums[middle]) {
				return search(nums, start, middle-1, target); 
			} else {
				return search(nums, middle+1, end, target);
			}
		} else {
			if (target >= nums[middle] && target <= nums[end]) {
				return search(nums, middle+1, end, target);
			} else {
				return search(nums, start, middle-1, target);
			}
		}
		
	}
	
    public int search(int[] nums, int target) {
    	return search(nums, 0, nums.length - 1, target);
    }
    
    public static void main(String[] args) {
    	int[] nums = {1,2,3};
    	new SearchInRotatedSortedArray().search(nums, 0);
    }
}
