/**
 * https://oj.leetcode.com/problems/median-of-two-sorted-arrays/
 * 
 * @author Ke Wang
 *
 */

public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
    	int length = A.length+B.length;
    	int[] C = new int[length];
    	int index1 = 0;
    	int index2 = 0;
    	int current = 0;
    	while (index1<A.length && index2<B.length) {
    		if (A[index1]<B[index2]) {
    			C[current] = A[index1];
    			current++;
    			index1++;
    		} else {
    			C[current] = B[index2];
    			current++;
    			index2++;
    		}
    	}
    	while (index1<A.length) {
    		C[current] = A[index1];
    		current++;
    		index1++;
    	}
    	while (index2<B.length) {
    		C[current] = B[index2];
    		current++;
    		index2++;
    	}
    	
    	return (C[(length-1)/2]+C[length/2])/2.0;
    	
    }
    
    public static void main(String[] args) {
    	int[] A = {};
    	int[] B = {2,3};
    	MedianofTwoSortedArrays m = new MedianofTwoSortedArrays();
    	System.out.println(m.findMedianSortedArrays(A, B));
    }
}
