/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * Find the minimum element.
 * 
 * @author Ke Wang
 *
 */

public class FindMinimumInRotatedSortedArray {
	private int findMin(int[] num, int first, int last) {
		if (last-first==1) {
			if (num[first]>num[last]) {
				return num[last];
			}
			else {
				return num[first];
			}
		}
		else {
			int middle = (first+last)/2;
			if (num[middle]>=num[first] && num[middle]<=num[last]) {
				return num[first];
			}
			else if (num[middle]>=num[first] && num[middle]>=num[last]) {
				return findMin(num, middle, last);
			}
			else if (num[first]>=num[middle] && num[last]>=num[middle]) {
				return findMin(num, first, middle);
			}
		}
		// should not come here
		return 0;
	}
	public int findMin(int[] num) {
		if (num == null) {
			return 0;
		}
		if (num.length == 1) {
			return num[0];
		}
		return findMin(num, 0, num.length-1);
	}
}
