//Sliding Window
class Solution {
    public int maxProfit(int[] prices) {

        int buy = 0;
        int sell = 1;
        int maxProfit = 0;

        while(sell < prices.length) {

            //int profit = 0;
            if(prices[buy] < prices[sell]) {
                int profit = prices[sell] - prices[buy];
                maxProfit = Math.max(profit, maxProfit);
                sell++;
            } else {
                buy=sell;
                sell++;
            }
        }
        return maxProfit;
        
    }
}
