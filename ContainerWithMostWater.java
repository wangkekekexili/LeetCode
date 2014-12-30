/**
 * https://oj.leetcode.com/problems/container-with-most-water/
 * 
 * @author Ke Wang
 *
 */

// brute force
// time limit exceeded
/*public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		if (height==null || height.length==1) {
			return 0;
		}
		int max = 0;
		for (int i = 0;i < height.length-1;i++) {
			for (int j = i+1;j < height.length;j++) {
				int temp = Math.min(height[i], height[j])*(j-i);
				if (temp > max) {
					max = temp;
				}
			}
		}
		return max;
	}
}*/

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int begin = 0;
		int end = height.length-1;
		int max = 0;
		while (end > begin) {
			int current = (end-begin)*(Math.min(height[begin], height[end]));
			if (current > max) {
				max = current;
			}
			if (height[begin] > height[end]) {
				end--;
			} else {
				begin++;
			}
		}
		return max;
	}
}