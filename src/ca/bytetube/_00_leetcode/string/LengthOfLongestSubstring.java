package ca.bytetube._00_leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * @author dall.
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        char[] chars = s.toCharArray();
        if (chars.length == 0) return 0;

        //记录每个字符上一次出现的位置
        int[] prevIndex = new int[128];
        for (int i = 0; i < prevIndex.length; i++) {
            prevIndex[i] = -1;
        }
        //prevIndex.put(chars[0], 0);
        prevIndex[chars[0]] = 0;
        int li = 0;
        int maxLen = 1;
        for (int i = 1; i < chars.length; i++) {
            //Integer pi = prevIndex.get(chars[i]);//1
            int pi = prevIndex[chars[i]];
            if (pi >= li) {
                li = pi + 1;//2
            }

            //prevIndex.put(chars[i], i);
            prevIndex[chars[i]] = i;
            maxLen = Math.max(maxLen, i - li + 1);


        }
        return maxLen;
    }
}
