/**
 * https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * @author Ke Wang
 *
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
    	if (prices==null || prices.length==0 || prices.length==1) {
    		return 0;
    	}
    	
    	int[] diff = new int[prices.length-1];
    	for (int i = 1;i < prices.length;i++) {
    		diff[i-1] = prices[i] - prices[i-1];
    	}
    	
    	int current = 0;
    	int max = 0;
    	for (int i : diff) {
    		current += i;
    		if (current < 0) {
    			current = 0;
    		} else if (current > max) {
    			max = current;
    		}
    	}
    	
    	return max;
    	
    }
}
