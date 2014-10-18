/**
 * Given two sorted integer arrays A and B, 
 * merge B into A as one sorted array.
 * 
 * @author Ke Wang
 *
 */
public class MergetSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		
		int currentA = m-1;
		int currentB = n-1;
		int current = m+n-1;
		
		while (currentA>=0 && currentB>=0) {
			if (A[currentA]>B[currentB]) {
				A[current] = A[currentA];
				currentA--;
			}
			else {
				A[current] = B[currentB];
				currentB--;
			}
			current--;
		}
		
		while (currentB>=0) {
			A[current] = B[currentB];
			current--;
			currentB--;
		}
		
	}
}
