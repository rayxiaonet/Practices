package net.rayxiao;

/**
 * 123. Best Time to Buy and Sell Stock III
 * LeetCode #123/Hard
 *

 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {1,2,6,8,3,8};
        System.out.println(maxProfit(prices));

    }


    public static int maxProfit(int[] prices) {
        int sell1 = 0, sell2 = 0, buy1 = Integer.MAX_VALUE, buy2 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, -buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
