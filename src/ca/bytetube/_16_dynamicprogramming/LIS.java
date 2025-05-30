package ca.bytetube._16_dynamicprogramming;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 *
 * @author dall.
 */
public class LIS {
    public int lengthOfLIS(int[] nums) {
        //① Define state
        int[] dp = new int[nums.length];
        //② Set initial state
        dp[0] = 1;
        int max = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            //③ Determine the state transition equation
            for (int j = 0; j < i; j++) {
                if (nums[i] <= nums[j]) continue;
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
