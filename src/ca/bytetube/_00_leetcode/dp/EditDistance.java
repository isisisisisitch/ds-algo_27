package ca.bytetube._00_leetcode.dp;

/**
 * https://leetcode.com/problems/edit-distance/
 *
 * @author dall.
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        char[] cs1 = word1.toCharArray();
        char[] cs2 = word2.toCharArray();
        int[][] dp = new int[cs1.length + 1][cs2.length + 1];
        for (int row = 1; row <= cs1.length; row++) {
            dp[row][0] = row;
        }
        for (int col = 1; col <= cs2.length; col++) {
            dp[0][col] = col;
        }
        for (int i = 1; i <= cs1.length; i++) {
            for (int j = 1; j <= cs2.length; j++) {
                int top = dp[i - 1][j] + 1;
                int left = dp[i][j - 1] + 1;
                int leftTop = dp[i - 1][j - 1];
                if (cs1[i - 1] != cs2[j - 1]) {
                    leftTop++;
                }
                dp[i][j] = Math.min(Math.min(top, left), leftTop);
            }
        }

        return dp[cs1.length][cs2.length];
    }
}
