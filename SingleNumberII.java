/**
 * https://oj.leetcode.com/problems/single-number-ii/
 * 
 * @author Ke Wang
 *
 */

public class SingleNumberII {
    public int singleNumber(int[] A) {
    	int result = 0;
    	for (int i = 0;i != 32;i++) {
    		int temp = 0;
    		for (int j = 0;j != A.length;j++) {
    			temp += (A[j]>>i)&1;
    		}
    		result += (temp%3)<<i;
    	}
    	return result;
    }	
    
    public static void main(String[] args) {
    	int[] test = {1,1,1,2,2,2,3};
    	int[] test2 = {10};
    	SingleNumberII s = new SingleNumberII();
    	System.out.println(s.singleNumber(test));
    	System.out.println(s.singleNumber(test2));
    }
}
