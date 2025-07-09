package ca.bytetube._20_amzOA;

import java.util.HashMap;

public class MinOperation {
    public static void main(String[] args) {

    }

    /*
        每次操作最多发走2个商品（位置必须不同）
        最好情况，每次都能配对2个商品，一共需要操作的次数 (n+1)/2
     */
    public int minOperation(int[] locations) {
        if (locations.length == 0) return -1;
        int maxFrequency = 1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        // 遍历数组，用哈希表记录每个元素重复的次数
        for (int location : locations) {
            if (map.containsKey(location)) {
                int frequency = map.get(location);
                map.put(location, ++frequency);
                maxFrequency = Math.max(maxFrequency, frequency);
            } else {
                map.put(location, 1);
            }
        }
        //n= 5 [2,2,2,3,4]
        // 如果重复元素超过整个数组的一半，那么最小处理数为重复元素的个数，反之为数组长度加1除以2
        return maxFrequency > locations.length - maxFrequency ? maxFrequency : locations.length + 1 >> 1;
    }
}
