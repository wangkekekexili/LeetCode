/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * 
 * @author Ke Wang
 *
 */

public class JumpGame {
	public boolean canJump(int[] A) {
		if (A==null) {
			return true;
		}
		
		int last = 1;
		for (int i = 0;i != A.length-1;i++) {
			if (last-1==0 && A[i]==0) {
				return false;
			}
			if (last-1 > A[i]) {
				last = last - 1;
			} else {
				last = A[i];
			}
		}
		
		return true;
	}
}
