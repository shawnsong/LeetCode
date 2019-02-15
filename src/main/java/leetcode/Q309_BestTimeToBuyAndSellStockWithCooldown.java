package leetcode;
/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as 
you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

    You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
    After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)

Example:

prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]
 */
public class Q309_BestTimeToBuyAndSellStockWithCooldown {
	public int maxProfit(int[] prices) {
		if (prices.length <= 1)
			return 0;
		int buy = prices[0];
		int[] sell = new int[prices.length];
		int[] cooldown = new int[prices.length];
		
		sell[0] = 0;
		cooldown[0] = 0;
		
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < buy)
				buy = prices[i];
			else {
				sell[i] = Math.max(cooldown[i-1], sell[i-1] + prices[i] - prices[i-1]);
				cooldown[i] = Math.max(sell[i - 1], cooldown[i - 1]);
			}
		}
		
		return Math.max(cooldown[prices.length - 1], sell[prices.length - 1]);
	}
}
