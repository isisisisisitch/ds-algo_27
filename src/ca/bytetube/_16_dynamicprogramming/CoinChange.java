package ca.bytetube._16_dynamicprogramming;

/**
 * https://leetcode.com/problems/coin-change/
 *
 * @author dall.
 */
public class CoinChange {
    public static void main(String[] args) {
        System.out.println(coinChange(41));
    }

    //dp的核心思路：把从找1分零钱所对应的硬币数，到找amount分零钱所对应的硬币数，依次的求出，并存入在dp数组中
    public static int coinChange(int amount) {//amount = 7;
        int[] dp = new int[amount + 1];//[0,1,2,3,4,]
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            if (i >= 1) min = Math.min(dp[i - 1], min);//min = dp[4] = 4
            if (i >= 5) min = Math.min(dp[i - 5], min);//min = min{0,4} = 0
            if (i >= 20) min = Math.min(dp[i - 20], min);
            if (i >= 25) min = Math.min(dp[i - 25], min);

            dp[i] = min + 1;

        }


        return dp[amount];
    }

    public static int coinChange2(int amount) {
        if (amount < 1) return Integer.MAX_VALUE;
        int[] coins = {1, 5, 20, 25};
        int[] dp = new int[amount + 1];
        for (int coin : coins) {
            if (amount < coin) continue;
            dp[coin] = 1;
        }

        return coinChange2(amount, dp);
    }

    private static int coinChange2(int amount, int[] dp) {
        if (amount < 1) return Integer.MAX_VALUE;
        if (dp[amount] == 0) {
            int min1 = Math.min(coinChange2(amount - 25, dp),
                    coinChange2(amount - 20, dp));

            int min2 = Math.min(coinChange2(amount - 5, dp),
                    coinChange2(amount - 1, dp));
            dp[amount] = Math.min(min1, min2) + 1;
        }


        return dp[amount];
    }

    public static int coinChange1(int n) {
        if (n < 1) return Integer.MAX_VALUE;
        if (n == 25 || n == 20 || n == 5 || n == 1) return 1;
        int min1 = Math.min(coinChange1(n - 25),
                coinChange1(n - 20));

        int min2 = Math.min(coinChange1(n - 5),
                coinChange1(n - 1));

        return Math.min(min1, min2) + 1;


    }
}
