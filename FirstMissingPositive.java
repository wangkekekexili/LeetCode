/**
 * https://oj.leetcode.com/problems/first-missing-positive/
 * 
 * @author Ke Wang
 *
 */

public class FirstMissingPositive {

    public int firstMissingPositive(int[] A) {
    	if (A==null) {
    		return 1;
    	}
    	
    	// first pass
    	for (int i = 0;i != A.length;i++) {
    		while (true){
    			if (A[i] <= 0 || A[i] > A.length || A[i] == i+1) {
    				break;
    			}
    			int temp = A[A[i]-1];
    			if (temp == A[i]) {
    				A[i] = 0;
    				break;
    			}
    			A[A[i]-1] = A[i];
    			A[i] = temp;
    		}
    	}
    	
    	// second pass
    	for (int i = 0;i != A.length;i++) {
    		if (A[i] != i+1) {
    			return i+1;
    		}
    	}
    	
    	return A.length+1;
    	
    }
	
	public static void main(String[] args) {
		int[] test1 = {3,4,-1,1};
		int[] test2 = {1,2,0};
		System.out.println(new FirstMissingPositive().firstMissingPositive(test2));
	}

}
