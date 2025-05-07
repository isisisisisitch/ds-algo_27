package ca.bytetube._16_dynamicprogramming;

/**
 * https://leetcode.com/problems/maximum-subarray/
 *
 * @author dall.
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
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

        return max;
    }

    public int maxSubArray1(int[] nums) {
        //① Define state
        int[] dp = new int[nums.length];
        //② Set initial state
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < nums.length; i++) {
            //③ Determine the state transition equation
            //if dp(i – 1) ≤ 0, dp(i) = nums[i]
            if (dp[i - 1] <= 0) dp[i] = nums[i];

                //if dp(i – 1) > 0, dp(i) = dp(i – 1) + nums[i]
            else dp[i] = dp[i - 1] + nums[i];
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
