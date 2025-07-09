package ca.bytetube._20_amzOA;

import java.util.Arrays;
import java.util.Map;

public class GetMinDistance {
    public static void main(String[] args) {
        int[] center = {1,2,2};
        int[] destination = {5,2,4};
        System.out.println( getMinDistance(center,destination));
    }

    /*
        考查点：两个数组的最小绝对值差 ： 排序
     */
    public static int getMinDistance(int[] center, int[] destination) {
        Arrays.sort(center);
        Arrays.sort(destination);
        int minDifference = 0;
        for (int i = 0; i < center.length; i++) {
            minDifference += Math.abs(center[i] - destination[i]);
        }
        return minDifference;
    }
}
