
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
    	int max = 0;
    	int index = prices.length-1;
    	while (index > 0) {
    		if (prices[index] > prices[index-1]) {
    			max += prices[index] - prices[index-1];
    		}
    		index--;
    	}
    	return max;
    }
}
