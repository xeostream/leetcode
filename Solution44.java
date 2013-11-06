/*
 * Best Time to Buy and Sell Stock
 */
public class Solution44 {
	public int maxProfit(int[] prices) {
		int profit = 0;
		if (prices.length > 0) {
			int min = prices[0];
			for (int i = 1; i < prices.length; i++) {
				if (prices[i] > min)
					profit = Math.max(profit, prices[i]-min);
				else if (prices[i] < min)
					min = prices[i];
			}
		}
		return profit;
	}
}
