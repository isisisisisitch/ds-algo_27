package ca.bytetube._20_amzOA;

public class GetMaxScore {
    public static void main(String[] args) {
        System.out.println(getMaxScore("abez"));
    }

    //1. 计算原始分数
    //2.对于字符串上的每一个i位置的字符，依次的去尝试将它替换为a~z的每一个字母（除去原字母），然后再计算一次分数
    //3.恢复原字符
    public static long getMaxScore(String data) {
        char[] charArray = data.toCharArray();
        long maxScore = countGoodCharArray(charArray);
        for (int i = 0; i < charArray.length; i++) {
            char old = charArray[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == old) continue;
                charArray[i] = c;
                long score = countGoodCharArray(charArray);
                maxScore = Math.max(maxScore, score);

            }
            charArray[i] = old;
        }

        return maxScore;
    }

    /*
    统计一个字符串中，所有的好字符串的数量
    好字符串：字符串中每一对相邻的字符的ASCII差值<=1
    用双指针i,j
    i表示区间的起点，j从i位置向右扩展
    只要charArray[j+1] 和 charArray[j]的ASCII差值<=1，就可以把j向右扩展
    当遇到ASCII差值>1,说明号区间的范围[i,j]
    接下来可以统计在[i,j]范围内好字串的数量
    len = 3
    长度为1的好字串的个数有len
    长度为2的好字串的个数有len - 1
    长度为3的好字串的个数有len - 2
    好字串的个数：1+ 2+ 3+...= len*(len+1) /2
     */
    private static long countGoodCharArray(char[] charArray) {
        long res = 0;
        int i = 0;
        int n = charArray.length;
        while (i < n) {
            int j = i;
            while (j + 1 < n && Math.abs(charArray[j + 1] - charArray[j]) <= 1) {
                j++;
            }
            long len = j - i + 1;
            res += len * (len + 1) / 2;
            i = j + 1;
        }

        return res;
    }

//    public long getMaxScore(String data) {
//        if (data == null) return 0;
//        if (data.length() == 1) return 1;
//
//        // 定义方向常量
//        final int LEFT = -1;
//        final int RIGHT = 1;
//
//        char[] chars = data.toCharArray();
//        long maxScore = score(chars);
//
//        // 遍历每一个字母，分别计算出每一个字母向左更改和向右更改后的最大分数
//        for (int i = 0; i < chars.length - 1; i++) {
//            maxScore = Math.max(calculate(chars, i, LEFT, maxScore), calculate(chars, i, RIGHT, maxScore));
//        }
//
//        return maxScore;
//    }
//
//    private long calculate(char[] chars, int index, int direction, long maxScore) {//abez,1,1,5
//        // 第一个字母的左边和最后一个字母的右边无法计算，直接返回0
//        if (index + direction < 0 || index + direction >= chars.length) return 0;
//
//        // 如果这个字母不属于符合条件的子串中，或者当前字母处于子串的头部或者尾部时，参考指定方向的字母进行更改并计算
//        if (Math.abs(chars[index] - chars[index + direction]) > 1) {
//            // 记录当前字母
//            char token = chars[index];//b
//            for (int j = -1; j < 2; j += 2) {
//                // 如果指定方向字母为‘a'，那么跳过减法
//                if (j == -1 && chars[index + direction] == 'a') continue;
//                // 如果指定方向字母为‘z’，那么跳过加法
//                if (j == 1 && chars[index + direction] == 'z') continue;
//                // 如果是其他字母，那么参考指定方向的字母进行更改，字符+1或者字符-1
//                chars[index] = (char) (chars[index + direction] + j);//d
//                // 更改后计算新的分数并取最大分数
//                maxScore = Math.max(maxScore, score(chars));
//            }
//            // 将当前字母还原
//            chars[index] = token;
//        }
//        return maxScore;
//    }
//
//    // 计算当前字符串所得分数
//    private long score(char[] chars) {
//        if (chars.length == 0) return 0;
//        if (chars.length == 1) return 1;
//
//        long score = 1;
//        long adder = 2;
//        for (int i = 1; i < chars.length; i++) {
//            if (Math.abs(chars[i] - chars[i - 1]) <= 1) {
//                score += adder++;
//            } else {
//                score++;
//                adder = 2;
//            }
//        }
//        return score;
//    }
}
