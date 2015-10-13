import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }
    	int[] result = new int[nums.length - k + 1];
    	Deque<Integer> index = new LinkedList<>();
    	for (int i = 0; i != nums.length; i++) {
    		if (index.isEmpty() == false && index.peekFirst() == i - k) {
    			index.removeFirst();
    		}
    		while (index.isEmpty() == false && nums[index.peekLast()] < nums[i]) {
    			index.removeLast();
    		}
    		index.addLast(nums[i]);
    		if (i >= k - 1) {
    			result[i - k + 1] = nums[index.peekFirst()];
    		}
    	}
    	return result;
    }
}
