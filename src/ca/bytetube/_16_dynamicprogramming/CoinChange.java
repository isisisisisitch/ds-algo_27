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

    //我们用array来存之前计算出来的最佳情况
    public int coinChange2(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] res = new int[amount + 1];
        //res[0] = 0;
        //先在各个coin面值的位子放上1
        for (int c : coins) {
            if (c < res.length) {
                res[c] = 1;
            }

        }
        //从头开始loop每个amount最小的组成部分
        for (int i = 1; i <= amount; i++) {//1,2,5 amount = 5;
            //在每个amount时候找出最当前最小的硬币数量
            for (int c : coins) {
                if (i - c >= 0) {
                    //第一次走到amount=i 且i-c之后剩下的钱是有最优解的情况下
                    if (res[i] == 0 && res[i - c] > 0) {
                        res[i] = 1 + res[i - c];
                        //i-c之后剩下的钱是有最优解的情况下，对比当前面值coin总数和之前的最小值
                    } else if (res[i - c] > 0) {
                        res[i] = Math.min(res[i], 1 + res[i - c]);
                    }

                }

            }

        }

        //如果最后一个数字是0则无解
        return res[amount] == 0 ? -1 : res[amount];
    }

    public int coinChange(int[] coins, int amount) {//2 amount = 3
        int[] dp = new int[amount + 1];
        //
        // 0 ,Integer.MAX_VALUE - 1 ,1,  Integer.MAX_VALUE - 1

        // 从1开始计算每一个数目所需的最少硬币数
        for (int currentAmount = 1; currentAmount <= amount; currentAmount++) {
            // 初始化当前数目，减1是为了避免后续计算加1时overflow
            dp[currentAmount] = Integer.MAX_VALUE - 1;
            // 从第一个硬币开始，计算当前数目需要的最少钱币数
            for (int coin : coins) {
                if (currentAmount >= coin) {
                    // 如果当前数目大于当前硬币面额，那么当前硬币面额所需的最小钱币数 = （当前数目 - 当前硬币面额）的最小钱币数 + 1
                    // 然后在每个不同面值的硬币中找到最小的所需最小钱币数
                    dp[currentAmount] = Math.min(dp[currentAmount - coin] + 1, dp[currentAmount]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
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
