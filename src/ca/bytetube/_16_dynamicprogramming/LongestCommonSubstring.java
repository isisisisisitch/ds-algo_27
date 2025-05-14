package ca.bytetube._16_dynamicprogramming;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        System.out.println(longestCommonSubstring("ABCBA", "BABCA"));
    }

    public static int longestCommonSubstring(String text1, String text2) {
        char[] nums1 = text1.toCharArray();
        char[] nums2 = text2.toCharArray();

        char[] rowsNums = nums1, colsNums = nums2;
        if (nums1.length < nums2.length) {
            colsNums = nums1;
            rowsNums = nums2;
        }
        int[] dp = new int[colsNums.length + 1];
        int max = 0;
        for (int i = 1; i <= rowsNums.length; i++) {
            int cur = 0;
            for (int j = 1; j <= colsNums.length; j++) {
                int leftTop = cur;
                cur = dp[j];
                if (rowsNums[i - 1] == colsNums[j - 1]) {
                    dp[j] = leftTop + 1;
                    max = Math.max(dp[j], max);
                } else dp[j] = 0;
            }
        }
        return max;

    }

    public static int longestCommonSubstring1(String s1, String s2) {
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        int[][] dp = new int[chs1.length + 1][chs2.length + 1];
        int max = 0;
        for (int i = 1; i <= chs1.length; i++) {
            for (int j = 1; j <= chs2.length; j++) {
                //str1[i – 1] ≠ str2[ j – 1]，then dp(i, j) = 0
                if (chs1[i - 1] != chs2[j - 1]) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max;
    }
}
