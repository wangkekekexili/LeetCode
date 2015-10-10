
public class HouseRobberII {
    
	private int rob(int[] nums, int start, int end) {
		if (nums == null || start > end) {
			return 0;
		}
		if (start == end) {
			return nums[0];
		}
		int[] max = new int[end - start + 1];
		max[0] = nums[start];
		max[1] = Math.max(nums[start], nums[start + 1]);
		for (int index = start + 2; index <= end; index++) {
			if (max[index - 1 - start] > max[index - 2 - start] + nums[index]) {
				max[index - start] = max[index - 1 - start];
			} else {
				max[index - start] = max[index - 2 - start] + nums[index];
			}
		}
		return max[end - start];
	}
	
	public int rob(int[] nums) {
    	if (nums == null || nums.length == 0) {
    		return 0;
    	}
    	if (nums.length == 1) {
    		return nums[0];
    	}
    	if (nums.length == 2) {
    		return Math.max(nums[0], nums[1]);
    	}
    	
    	int temp = Math.max(rob(nums, 0, nums.length-2), 
    			rob(nums, 1, nums.length-1));
    	temp = Math.max(temp, rob(nums, 1, nums.length - 2));
    	return temp;
    }
	
	public static void main(String[] args) {
		HouseRobberII instance = new HouseRobberII();
		int[] test = {1,2,1,1};
		System.out.println(instance.rob(test));
		System.out.println();
	}
}
