package ca.bytetube._00_leetcode.dp;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * @author dall.
 */
//greedy:把每一天都看作是卖出的那一天
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("max profit:" + new MaxProfit().maxProfit2(prices));
    }

    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(prices[i] - minPrice, maxProfit);
            }
        }

        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        if (prices.length <= 1) return 0;
        int[] difference = new int[prices.length - 1];

        for (int i = 0; i < difference.length; i++) {
            difference[i] = prices[i + 1] - prices[i];
           // System.out.println(difference[i]);
        }

        return maxSubArray(difference);
    }

    private int maxSubArray(int[] nums) {
        //① Define state
        int dp = nums[0];
        //② Set initial state
        int max = dp;

        for (int i = 1; i < nums.length; i++) {
            //③ Determine the state transition equation
            //if dp(i – 1) ≤ 0, dp(i) = nums[i]
            if (dp <= 0) dp = nums[i];

                //if dp(i – 1) > 0, dp(i) = dp(i – 1) + nums[i]
            else dp = dp + nums[i];
            max = Math.max(max, dp);
        }


        return Math.max(max, 0);
    }
}
