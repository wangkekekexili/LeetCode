/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * 
 * @author kewang
 *
 */
public class KthLargestElementInAnArray {
	
	
	private int findKthLargest(int[] nums, int start, int end, int k) {
		if (end == start && k == 1) {
			return nums[start];
		}
		int sentinel = nums[start];
		int lastSmallerIndex = start;
		for (int index = start + 1; index <= end; index++) {
			if (nums[index] < sentinel) {
				lastSmallerIndex++;
				int temp = nums[index];
				nums[index] =  nums[lastSmallerIndex];
				nums[lastSmallerIndex] = temp;
			}
		}
	
		int indexForSentinel = lastSmallerIndex;
		int temp = nums[indexForSentinel];
		nums[indexForSentinel] = nums[start];
		nums[start] = temp;
		
		if (indexForSentinel-start == k-1) {
			return sentinel;
		} else if (indexForSentinel-start < k-1) {
			return findKthLargest(nums, indexForSentinel+1, end, k-indexForSentinel+start-1);
		} else {
			return findKthLargest(nums, start, indexForSentinel-1, k);
		}
	}
	
    public int findKthLargest(int[] nums, int k) {
    	if (nums == null || nums.length == 0) {
    		return -1;
    	}
    	if (k <= 0 || k > nums.length) {
    		return -1;
    	}
    	
    	return findKthLargest(nums, 0, nums.length-1, nums.length-k+1);
    	
    }
    
    public static void main(String[] args) {
    	int[] nums = {3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};
    	System.out.println(new KthLargestElementInAnArray().findKthLargest(nums, 1));
    }
}
