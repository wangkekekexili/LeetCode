
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
    	
    	if (nums == null || nums.length == 0) {
    		return 0;
    	}
    	if (nums.length == 1) {
    		return nums[0];
    	}
    	
    	int maxProduct = 0;
    	
    	int start = 0;
    	int end = 0;
    	while (end < nums.length) {
    		while (end < nums.length && nums[end] != 0) {
    			end++;
    		}
    		int currentMax = maxProduct(nums, start, end - 1);
    		if (currentMax > maxProduct) {
    			maxProduct = currentMax;
    		}
    		end++;
    		start = end;
    	}
    	
    	return maxProduct;
    }
    
    private int maxProduct(int[] nums, int start, int end) {
    	if (start > end) {
    		return 0;
    	}
    	int product = 1;
    	for (int index = start; index <= end; index++) {
    		product *= nums[index];
    	}
    	if (product > 0) {
    		return product;
    	} else {
    		int head = 1;
    		int tail = 1;
    		for (int index = start; index <= end; index++) {
    			head *= nums[index];
    			if (nums[index] < 0) {
    				break;
    			}
    		} 
    		for (int index = end; index >= start; index--) {
    			tail *= nums[index];
    			if (nums[index] < 0) {
    				break;
    			}
    		}
    		if (head < tail) {
    			return product / tail;
    		} else {
    			return product / head;
    		}
    		
    	}
    }
    
    public static void main(String[] args) {
    	MaximumProductSubarray instance = new MaximumProductSubarray();
    	int[] test = {2,3,-2,4};
    	System.out.println(instance.maxProduct(test));
    }
}
