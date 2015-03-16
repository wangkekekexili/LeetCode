/**
 * https://leetcode.com/problems/rotate-array/
 * 
 * @author Ke Wang
 *
 */
public class RotateArray {
		
	private void rotate(int[] nums, int start, int end) {
		int head = start;
		int tail = end;
		while (head < tail) {
			int temp = nums[head];
			nums[head] = nums[tail];
			nums[tail] = temp;
			head++;
			tail--;
		}
	}
	
	public void rotate(int[] nums, int k) {
		k = k % nums.length;
		this.rotate(nums, 0, nums.length-1-k);
		this.rotate(nums, nums.length-k, nums.length-1);
		this.rotate(nums, 0, nums.length-1);
    }
	
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7};
		RotateArray r = new RotateArray();
		r.rotate(array, 3);
		for (int i : array) {
			System.out.println(i);
		}
	}

}
