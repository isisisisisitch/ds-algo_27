package ca.bytetube._20_amzOA;

/**
 * 解题方向：将一个前缀为"0"或者“1”组成的字符串分割成若干个长度为偶数的subSegment,
 * 使得每一段的字符可以通过最少的flip的次数变成"全1" 或者是"全0"，同时求出在最少flip的次数
 * 的情况下的最少subSegment个数
 */
public class GetMinSubSegments {

    public static void main(String[] args) {
        System.out.println(getMinSubSegments("1110011000"));
    }

    public static int getMinSubSegments(String frames) {
        int n = frames.length();
        int[] pre0 = new int[n + 1];//表示前i个字符中0的数量
        int[] pre1 = new int[n + 1];//表示前i个字符中1的数量
        char[] chars = frames.toCharArray();
        for (int i = 1; i <= n; i++) {
            pre0[i] = pre0[i - 1] + (chars[i - 1] == '0' ? 1 : 0);
            pre1[i] = pre1[i - 1] + (chars[i - 1] == '1' ? 1 : 0);
        }

        int[] minFlips = new int[n + 1];
        int[] minSegs = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            minFlips[i] = Integer.MAX_VALUE / 2;
            minSegs[i] = Integer.MAX_VALUE / 2;
        }
        minSegs[0] = 0;
        minFlips[0] = 0;

        for (int i = 2; i <= n; i++) {
            for (int len = 2; len <= i; len += 2) {//len表示当前考虑的偶数长度的subsegment
                int j = i - len;//subsegment的起点
                int cnt0 = pre0[i] - pre0[j];
                int cnt1 = pre1[i] - pre1[j];
                int flips = Math.min(cnt0, cnt1);//让这段全部变0或者1最少的翻转次数
                int totalFlips = minFlips[j] + flips;
                int totalSegs = minSegs[j] + 1;
                if (totalFlips < minFlips[i] || totalFlips == minFlips[i] && totalSegs < minSegs[i]) {
                    minFlips[i] = totalFlips;
                    minSegs[i] = totalSegs;
                }

            }

        }

        return minSegs[n];
    }
}
