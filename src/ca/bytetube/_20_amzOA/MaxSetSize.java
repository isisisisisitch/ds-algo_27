package ca.bytetube._20_amzOA;

import java.util.HashSet;
import java.util.Set;

public class MaxSetSize {
    public static void main(String[] args) {
        int[] arr = {3,9,4,2,16};
        System.out.println(maxSetSize(arr));
    }
    public static int maxSetSize(int[] riceBags) {

        Set<Integer> set = new HashSet<>();
        for (int num : riceBags) {
            set.add(num);
        }

        int max = 0;
        for (int num : riceBags) {
            int cur = num;
            int len = 1;
            while (set.contains(cur * cur)) {
                cur = cur * cur;
                len++;
            }
            if (len >= 2) max = Math.max(max, len);

        }

        return max;

    }
}
