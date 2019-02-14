package leetcode;

/*
 Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
 design an algorithm to find the maximum profit.
*/
public class Q121_BestTimeToBuyAndSellStockI {
	public int maxProfit(int[] prices) {
		if (prices.length <= 1)
			return 0;
		
		int profit = 0;
		
		int buy = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > buy)
				profit = Math.max(profit, prices[i] - buy);
			else
				buy = prices[i];
		}
		return profit;
	}
}
