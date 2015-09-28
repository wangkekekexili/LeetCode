/**
 * https://leetcode.com/problems/trapping-rain-water/
 * 
 * @author kewang
 *
 */
public class TrappingRainWater {
    public int trap(int[] height) {
    	if (height == null || height.length <= 2) {
    		return 0;
    	}
    	
    	// get the highest
    	int maxHeight = Integer.MIN_VALUE;
    	int maxHeightIndex = -1;
    	for (int index = 0; index != height.length; index++) {
    		if (height[index] > maxHeight) {
    			maxHeightIndex = index;
    			maxHeight = height[index];
    		}
    	}
    	
    	int water = 0;
    	
    	// from left to the highest
    	int leftHeight = height[0];
    	for (int index = 1; index < maxHeightIndex; index++) {
    		if (height[index] > leftHeight) {
    			leftHeight = height[index];
    		} else {
    			water += leftHeight - height[index];
    		}
    	}
    	
    	// from right to the highest
    	int rightHeight = height[height.length - 1];
    	for (int index = height.length -2; index > maxHeightIndex; index--) {
    		if (height[index] > rightHeight) {
    			rightHeight = height[index];
    		} else {
    			water += rightHeight - height[index];
    		}
    	}
    	
    	return water;
    }
}
