/**
 * https://leetcode.com/problems/perfect-squares/
 * 
 * @author kewang
 *
 */
public class PerfectSquares {
    public int numSquares(int n) {
    	if (n <= 0) {
    		return 0;
    	}
    	if (n == 1) {
    		return 1;
    	}
    	int[] least = new int[n+1];
    	least[0] = 0;
    	least[1] = 1;
    	for (int number = 2;number <= n; number++) {
    		least[number] = Integer.MAX_VALUE;
    		for (int square = 1; square*square <= number; square++) {
    			if (least[number - square*square] + 1 < least[number]) {
    				least[number] = least[number - square*square] + 1;
    			}
    		}
    	}
    	return least[n];
    }	
}
