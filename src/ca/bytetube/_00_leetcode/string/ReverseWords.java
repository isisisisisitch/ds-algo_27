package ca.bytetube._00_leetcode.string;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 *
 * @author dall.
 */
public class ReverseWords {
    public static void main(String[] args) {
        String s = "a good   example";
        // System.out.println(s.length());
        reverseWords(s);
    }

    public static String reverseWords(String s) {
        if (s == null) return "";
        char[] chars = s.toCharArray();
        //用来指向当前有效的字符位置
        int cur = 0;
        //前一个是否为空格
        boolean space = true;
        int len = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                chars[cur++] = chars[i];
                space = false;
            } else if (space == false) {//chars[i] 是第一个空格字符，并且chars[i-1]是非空格字符
                chars[cur++] = ' ';
                space = true;

            }
        }

        len = space ? (cur - 1) : cur;

//        System.out.println(len);
        //对整个字符串先做一次reverse
        reverse(chars, 0, len);
       // System.out.println(new String(chars, 0, len));

        //对每个单词做reverse
        int prevSpaceIndex = -1;
        for (int i = 0; i < len; i++) {
            if (chars[i] != ' ') continue;

            //i位置现在一定是空格
            reverse(chars, prevSpaceIndex + 1, i);
            prevSpaceIndex = i;
        }
        //reverse最后一个单词
        reverse(chars, prevSpaceIndex + 1, len);


        return new String(chars, 0, len);
    }

    private static void reverse(char[] chars, int li, int ri) {
        ri--;
        while (li < ri) {
            char temp = chars[li];
            chars[li] = chars[ri];
            chars[ri] = temp;
            li++;
            ri--;
        }

    }
}
