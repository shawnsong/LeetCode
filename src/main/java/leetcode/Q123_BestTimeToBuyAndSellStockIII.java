package leetcode;

/*
 Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most two transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class Q123_BestTimeToBuyAndSellStockIII {

	public int maxProfit(int[] prices) {
		if (prices.length <= 1) {
			return 0;
		}

		/*
		 * these four variables represent your profit after executing
		 * corresponding transaction in the beginning, your profit is 0. when
		 * you buy a stock ,the profit will be deducted of the price of stock.
		 */
		int firstBuy = Integer.MIN_VALUE, firstSell = 0;
		int secondBuy = Integer.MIN_VALUE, secondSell = 0;
		for (int curPrice : prices) {
			if (firstBuy < -curPrice)
				firstBuy = -curPrice; // the max profit after you buy first
										// stock
			if (firstSell < firstBuy + curPrice)
				firstSell = firstBuy + curPrice; // the max profit after you
													// sell it
			if (secondBuy < firstSell - curPrice)
				secondBuy = firstSell - curPrice; // the max profit after you
													// buy the second stock
			if (secondSell < secondBuy + curPrice)
				secondSell = secondBuy + curPrice; // the max profit after you
													// sell the second stock
		}
		return secondSell;
	}
}
