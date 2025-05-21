package ca.bytetube._00_leetcode.dp;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * @author dall.
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "caba";
        String longestPalindrome = longestPalindrome(s);
        System.out.println(longestPalindrome);

    }

    //扩展中心法优化：以连续相同的子串作为扩展中心
    public static String longestPalindrome(String s) {
        char[] cs = s.toCharArray();
        if (cs.length <= 1) return s;
        int begin = 0;
        int maxLen = 1;
        int i = 0;
        while (i < cs.length) {
            int r = i;
            int l = i - 1;
            //找到右边第一个不等于cs[i]的位置，记作r
            while (++r < cs.length && cs[r] == cs[i]) ;
            i = r;
            //l向左，r向右，继续扩展，进而得到更大的回文串
            while (l >= 0 && r < cs.length && cs[l] == cs[r]) {
                l--;
                r++;
            }

            int len = r - ++l;
            if (len > maxLen) {
                maxLen = len;
                begin = l;
            }
        }


        return new String(cs, begin, maxLen);
    }

    //扩展中心法
    public static String longestPalindrome2(String s) {
        char[] cs = s.toCharArray();
        if (cs.length <= 1) return s;
        int begin = 0;
        int maxLen = 1;
        for (int i = cs.length - 2; i >= 1; i--) {
            //1.以i号位字符作为扩展中心向左右两侧扩充
            int len1 = palindromeLen(cs, i - 1, i + 1);
            //2.以i号位字符右间隙作为扩展中心向左右两侧扩充
            int len2 = palindromeLen(cs, i, i + 1);

            len1 = Math.max(len1, len2);
            if (len1 > maxLen) {
                maxLen = len1;
                begin = i - ((maxLen - 1) >> 1);
            }

        }

        //处理0号位右间隙
        if (cs[0] == cs[1] && maxLen < 2) {
            maxLen = 2;
            begin = 0;
        }

        return new String(cs, begin, maxLen);
    }

    private static int palindromeLen(char[] cs, int l, int r) {
        while (l >= 0 && r < cs.length && cs[l] == cs[r]) {
            l--;
            r++;
        }

        return r - l - 1;
    }


    public String longestPalindrome1(String s) {
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
