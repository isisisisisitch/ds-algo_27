package ca.bytetube._00_leetcode.dp;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * @author dall.
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        char[] cs = s.toCharArray();
        if (cs.length <= 1) return s;
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[cs.length][cs.length];
        for (int i = cs.length - 1; i >= 0; i--) {
            for (int j = i; j < cs.length; j++) {
                int len = j - i + 1;
                dp[i][j] = (cs[i] == cs[j]) && (len <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && len > maxLen) {
                    maxLen = len;
                    begin = i;
                }
            }
        }

        return new String(cs, begin, maxLen);
    }
}
