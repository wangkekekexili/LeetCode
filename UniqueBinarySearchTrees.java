/**
 * https://oj.leetcode.com/problems/unique-binary-search-trees/
 * 
 * @author Ke Wang
 *
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
    	if (n<0) {
    		return 0;
    	}
    	if (n==0 || n==1) {
    		return 1;
    	}
    	
    	int[] array = new int[n+1];
    	array[0] = 1;
    	array[1] = 1;
    	for (int i = 2;i <= n;i++) {
    		int sum = 0;
    		for (int j = 0;j < i;j++) {
    			sum += array[j]*array[i-j-1];
    		}
    		array[i] = sum;
    	}
    	
    	return array[n];
    	
    }
    
    public static void main(String[] args) {
    	UniqueBinarySearchTrees u = new UniqueBinarySearchTrees();
    	System.out.println(u.numTrees(4));
    }
}
