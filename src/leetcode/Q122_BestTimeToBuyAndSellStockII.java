package leetcode;

/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you 
like (ie, buy one and sell one share of the stock multiple times). However, you may not engage 
in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class Q122_BestTimeToBuyAndSellStockII {
	/*
	 * note: we buy in prices[0] on first day. We sell the stock as long as today's closing price (prices[i]) 
	 * is higher than yesterday's price (prices[i-1]). 
	 * if today's price is lower than yesterday's price, we (probably) buy in and wait tomorrow's result.
	 */
	public int maxProfit(int[] prices) {
		int profit = 0;

		if (prices.length <= 1)
			return profit;

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1])
				profit += prices[i] - prices[i - 1];
		}

		return profit;
	}
}
